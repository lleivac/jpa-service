package com.lucia.jpaservice.repository;

import com.lucia.jpaservice.model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel,Integer> {

    Optional<ProductoModel> findById(Integer id);


    Optional<ProductoModel> findByNombreProducto (String nombreProducto);
    Optional<ProductoModel> findByPrecioVenta (double precioVenta);
    Optional<ProductoModel> findByPrecioCompra (double precioCompra);


    List<ProductoModel> findByStockLessThan(Integer stock);
}
