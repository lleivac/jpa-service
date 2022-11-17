package com.lucia.jpaservice.model;
import lombok.Data;
import javax.persistence.*;


@Data
@Entity
@Table(name="producto")
public class ProductoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name="nombre_producto")
    private String nombreProducto;


    @Column(name="precio_compra")
    private double precioCompra;


    @Column(name="precio_venta")
    private double precioVenta;

    @Column(name = "existencia")
    private Integer stock;

}
