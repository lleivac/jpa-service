package com.lucia.jpaservice.repository;

import com.lucia.jpaservice.model.ClienteModel;
import com.lucia.jpaservice.model.VentasModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<VentasModel, Integer> {
    Optional<VentasModel> findById(Integer id);
    Optional<VentasModel> findByMontoTotal(Integer montoTotal);
    Optional<VentasModel> findByFechaPedido(Date fechaPedido);



}
