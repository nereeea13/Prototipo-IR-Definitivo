package a.e.i.o.dia.tienda;

import java.time.LocalDate;

import a.e.i.o.dia.enumerados.EstadoPedido;
import a.e.i.o.dia.model.BaseEntity;

public class PedidoTienda extends BaseEntity {

    private LocalDate fechaCreacion; 
    private LocalDate fechaEntrega;
    private EstadoPedido estado;
    private String empresaReparto; 
    private String direccionEnvio; 
    private Double precioTotal; 
    
}
