package com.lucia.jpaservice.exceptions;

import lombok.Data;

@Data
public class ResourceNotFoundException extends Exception{

    public ResourceNotFoundException(String msg){
        super (msg);
    }

}
