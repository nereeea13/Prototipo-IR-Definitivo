package a.e.i.o.dia.tienda;

import java.time.LocalDateTime;
import java.util.List;

import a.e.i.o.dia.model.BaseEntity;
import jakarta.persistence.OneToMany;



public class Compra extends BaseEntity {

    private LocalDateTime fechaHora; 
    private Double precioTotal; 

    @OneToMany
    private List<Producto> productos;

    
}
