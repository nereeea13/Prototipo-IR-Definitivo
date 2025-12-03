package a.e.i.o.dia.pedidos;

import java.time.LocalDate;

import a.e.i.o.dia.model.BaseEntity;
import a.e.i.o.dia.enumerados.EstadoPedido;


public class PedidoMercancia extends BaseEntity {

    private LocalDate fechaCreacion; 
    private LocalDate fechaLlegada; 
    private EstadoPedido estado;
    
}
