package com.lucia.jpaservice.model;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;


@ToString
@Data
@Entity
@Table(name="cliente")
public class ClienteModel {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)//se genera automaticamente el ID
    private Integer id;


    @Column
    private String nombre;


    @Column
    private String apellido;


    @Column
    private String dni;



    @Column(name="fecha_nacimiento")
    private LocalDate fechaNacimiento;




}
