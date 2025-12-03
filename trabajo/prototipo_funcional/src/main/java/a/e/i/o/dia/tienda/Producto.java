package a.e.i.o.dia.tienda;

import java.time.LocalDate;

import a.e.i.o.dia.enumerados.CategoriaProducto;
import a.e.i.o.dia.model.BaseEntity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "productos")
public class Producto extends BaseEntity {

    private String nombre;
    private String descripcion;
    private Double precio;
    // private String ubicacion; // TODO: ????
    private LocalDate  fechaCaducidad;
    private CategoriaProducto categoria;
    
}
