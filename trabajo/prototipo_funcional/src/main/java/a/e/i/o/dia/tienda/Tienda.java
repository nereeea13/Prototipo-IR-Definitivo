package a.e.i.o.dia.tienda;

import java.time.LocalTime;

import a.e.i.o.dia.model.BaseEntity;

public class Tienda extends BaseEntity {

    private String ubicacion; 
    private LocalTime horaApertura;
    private LocalTime horaCierre;
    private Integer numeroEmpleados;    
}
