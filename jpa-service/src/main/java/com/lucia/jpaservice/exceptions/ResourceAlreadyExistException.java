package com.lucia.jpaservice.exceptions;
import lombok.Data;
@Data
public class ResourceAlreadyExistException extends Exception{
    public ResourceAlreadyExistException(String msg){
        super(msg);
    }
}
