package com.lucia.jpaservice.exceptions;

import lombok.Data;

@Data
public class Error {
    String msg;
    String status;

    public void getStatus(String error) {
    }
}
