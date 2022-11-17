package com.lucia.jpaservice.model;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;

@ToString
@Data
@Entity
@Table(name="detalle_ventas")
public class DetalleVentasModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer cantidad;

    @Column(name ="sub_total")
    private double subTotal;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private ProductoModel producto;


}
