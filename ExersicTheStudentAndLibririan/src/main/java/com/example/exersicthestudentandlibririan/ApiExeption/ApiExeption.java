package com.example.exersicthestudentandlibririan.ApiExeption;

import lombok.AllArgsConstructor;
import lombok.Data;


public class ApiExeption extends RuntimeException {
    public ApiExeption(String massage){
        super(massage);
    }
}
