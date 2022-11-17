package com.lucia.jpaservice.model;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@ToString
@Data
@Entity
@Table(name="ventas")
public class VentasModel implements Serializable{

        private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @ManyToOne
        @JoinColumn(name="id_cliente")
        //private Integer idCliente;
        private ClienteModel cliente;

        @Column(name="monto_total")
        private Integer montoTotal;

        @Column(name="fecha_pedido")
        private LocalDate fechaPedido;

        @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
        @JoinColumn(name="id_ventas")
        private List<DetalleVentasModel> detalle;


}
