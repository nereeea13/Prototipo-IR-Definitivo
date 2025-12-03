package a.e.i.o.dia.empleados;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import a.e.i.o.dia.enumerados.EstadoTurno;
import a.e.i.o.dia.enumerados.TipoTurno;

public class Turno {

    private TipoTurno tipo; 

    private LocalTime horaInicio; 

    private LocalTime horaFin;

    private LocalDate fecha;

    private Duration duracion; 

    private EstadoTurno estado; 
    
}
