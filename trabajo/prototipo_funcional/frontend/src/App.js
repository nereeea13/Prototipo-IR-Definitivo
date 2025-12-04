import React from "react";
import { Route, Routes } from "react-router-dom";
import jwt_decode from "jwt-decode";
import { ErrorBoundary } from "react-error-boundary";
import AppNavbar from "./AppNavbar";
import Home from "./home";
import PrivateRoute from "./privateRoute";
import Register from "./auth/register";
import Login from "./auth/login";
import Logout from "./auth/logout";
import PlanList from "./public/plan";
import tokenService from "./services/token.service";
import UserListAdmin from "./admin/users/UserListAdmin";
import UserEditAdmin from "./admin/users/UserEditAdmin";
import SwaggerDocs from "./public/swagger";
import HomeJefe from "./home/homeJefe";
import HomeEmpleado from "./home/homeEmpleado";

function ErrorFallback({ error, resetErrorBoundary }) {
  return (
    <div role="alert">
      <p>Something went wrong:</p>
      <pre>{error.message}</pre>
      <button onClick={resetErrorBoundary}>Try again</button>
    </div>
  )
}

function App() {
  const jwt = tokenService.getLocalAccessToken();
  let roles = []
  if (jwt) {
    roles = getRolesFromJWT(jwt);
  }

  function getRolesFromJWT(jwt) {
    return jwt_decode(jwt).authorities;
  }

  const isJefe = roles.includes("JEFE");
  const isEmpleado = roles.includes("EMPLEADO");

  let adminRoutes = <></>;
  let ownerRoutes = <></>;
  let userRoutes = <></>;
  let vetRoutes = <></>;
  let publicRoutes = <></>;

  roles.forEach((role) => {
    if (role === "JEFE") {
      adminRoutes = (
        <>
          <Route path="/users" exact={true} element={<PrivateRoute><UserListAdmin /></PrivateRoute>} />
          <Route path="/users/:username" exact={true} element={<PrivateRoute><UserEditAdmin /></PrivateRoute>} />          
        </>)
    }
    if (role === "EMPLEADO") {
      ownerRoutes = (
        <>
          
        </>)
    }    
  })
  if (!jwt) {
    publicRoutes = (
      <>        
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
      </>
    )
  } else {
    userRoutes = (
      <>
        {/* <Route path="/dashboard" element={<PrivateRoute><Dashboard /></PrivateRoute>} /> */}        
        <Route path="/logout" element={<Logout />} />
        <Route path="/login" element={<Login />} />
      </>
    )
  }

  return (
    <div>
      <ErrorBoundary FallbackComponent={ErrorFallback} >
        <AppNavbar />
        <Routes>

          {/* Página de inicio dinámica por rol */}
          {isJefe && (
            <Route
              path="/"
              element={
                <PrivateRoute>
                  <HomeJefe />
                </PrivateRoute>
              }
            />
          )}

          {isEmpleado && !isJefe && (
            <Route
              path="/"
              element={
                <PrivateRoute>
                  <HomeEmpleado />
                </PrivateRoute>
              }
            />
          )}

          {/* Si no tiene rol → inicio normal público */}
          {!isJefe && !isEmpleado && (
            <Route path="/" element={<Home />} />
          )}

          {publicRoutes}
          {userRoutes}
          {adminRoutes}
          {ownerRoutes}
        </Routes>
      </ErrorBoundary>
    </div>
  );
}

export default App;
