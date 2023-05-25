package com.example.exersicthestudentandlibririan.ControllerAdvise;

import com.example.exersicthestudentandlibririan.ApiExeption.ApiExeption;
import com.example.exersicthestudentandlibririan.ApiRecponse.ApiResponce;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdvise {
    @ExceptionHandler(ApiExeption.class)
    public ResponseEntity<ApiResponce>ApiExeption(ApiExeption e){
        String massage= e.getMessage();
        return ResponseEntity.status(400).body(new ApiResponce(massage));
    }
    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    public ResponseEntity<ApiResponce>InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e1){
        String massage=e1.getMessage();
        return ResponseEntity.status(400).body(new ApiResponce(massage));
    }
}
