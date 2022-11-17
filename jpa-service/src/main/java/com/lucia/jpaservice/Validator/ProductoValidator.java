package com.lucia.jpaservice.Validator;


import com.lucia.jpaservice.model.ProductoModel;
import org.springframework.stereotype.Component;

@Component
public class ProductoValidator {
    public void validate(ProductoModel productoModel){

        if((productoModel.getNombreProducto().isBlank()) ) {
            throw new IllegalArgumentException("Ingrese Nombre de producto");
        }
        if(productoModel.getPrecioCompra()<=0.0){
            throw new IllegalArgumentException("Ingrese precio compra");
        }
        if(productoModel.getPrecioVenta()<=0.0){
            throw new IllegalArgumentException("Ingrese precio venta");
        }
        if(productoModel.getStock()<0){
            throw new IllegalArgumentException("Debe ingresar cantidad");
        }
    }
}
