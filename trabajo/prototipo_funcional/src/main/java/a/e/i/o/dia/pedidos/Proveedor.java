package a.e.i.o.dia.pedidos;

import java.time.LocalDate;

import a.e.i.o.dia.model.BaseEntity;
import a.e.i.o.dia.model.Person;


public class Proveedor extends Person {

    private Integer telefono;
    private String email; 
    private String direccion;
    private Integer tiempoEntregaEstimado; 
    private LocalDate inicioHorarioEntrega; 
    private LocalDate finHorarioEntrega;
    private Double costeEnvio; 

    
    
}
