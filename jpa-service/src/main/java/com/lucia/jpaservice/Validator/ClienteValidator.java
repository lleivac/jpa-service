package com.lucia.jpaservice.Validator;

import antlr.StringUtils;
import com.lucia.jpaservice.model.ClienteModel;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ClienteValidator {

    public void validate(ClienteModel clienteModel){

        if((clienteModel.getDni().isBlank()) || Integer.parseInt(clienteModel.getDni()) < 0 ){
            throw new IllegalArgumentException("Debe ingresar dni");
        }
        if(clienteModel.getNombre().isBlank()){
            throw new IllegalArgumentException("Debe ingresar nombre");
        }
        if(clienteModel.getApellido().isBlank()){
            throw new IllegalArgumentException("Debe ingresar apellido");
        }

        if(clienteModel.getFechaNacimiento()==null){
            throw new IllegalArgumentException("Debe ingresar fecha de nacimiento");
        }
    }
}
