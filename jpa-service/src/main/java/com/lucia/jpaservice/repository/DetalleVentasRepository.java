package com.lucia.jpaservice.repository;

import com.lucia.jpaservice.model.DetalleVentasModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DetalleVentasRepository extends JpaRepository<DetalleVentasModel, Integer> {

    Optional<DetalleVentasModel> findById(Integer id);
    Optional<DetalleVentasModel> findByCantidad (int cantidad);
    Optional<DetalleVentasModel> findBySubTotal (double subTotal);

    }
