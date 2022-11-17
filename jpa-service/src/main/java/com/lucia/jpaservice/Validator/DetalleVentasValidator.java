package com.lucia.jpaservice.Validator;

import com.lucia.jpaservice.exceptions.ResourceNotFoundException;
import com.lucia.jpaservice.model.DetalleVentasModel;
import com.lucia.jpaservice.model.ProductoModel;
import org.springframework.stereotype.Component;

@Component
public class DetalleVentasValidator {
    public void validate(DetalleVentasModel detalleVentasModel){


        if(detalleVentasModel.getCantidad()<= 0 || detalleVentasModel.getCantidad()==null){
            throw new IllegalArgumentException("Ingrese cantidad");
        }
        if(detalleVentasModel.getSubTotal()<= 0){
            throw new IllegalArgumentException("Ingrese precio venta");
        }

    }
}
