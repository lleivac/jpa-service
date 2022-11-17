package com.lucia.jpaservice.Validator;

import com.lucia.jpaservice.model.VentasModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Component
public class VentasValidator {
    public void validate(VentasModel ventasModel){
        if((ventasModel.getMontoTotal()<=0) ) {
            throw new IllegalArgumentException("Ingrese Monto total de ventas");
        }
        if(ventasModel.getFechaPedido() == null){
            throw new IllegalArgumentException("Ingrese fecha de pedido");
        }

    }

}
