package a.e.i.o.dia.empleados;

import java.util.List;

import a.e.i.o.dia.enumerados.RolEmpleado;
import a.e.i.o.dia.model.Person;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empleado extends Person{

    @Enumerated(EnumType.STRING)
    private RolEmpleado rol;
    private Integer dni; 
    private Integer telefono; 
    private String correo; 
    private Double salario; 
    // TODO: ? private String preferencias; 
    private Integer vacacionesInviernoRestantes; 
    private Integer vacacionesVeranoRestantes;
    // TODO: ? private String responsabilidades; 


    @OneToMany
    private List<Turno> turnoAsignado;


    
}
