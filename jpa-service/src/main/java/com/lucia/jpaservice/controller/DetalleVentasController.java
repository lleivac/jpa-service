package com.lucia.jpaservice.controller;

import com.lucia.jpaservice.exceptions.ResourceNotFoundException;
import com.lucia.jpaservice.model.ClienteModel;

import com.lucia.jpaservice.model.DetalleVentasModel;
import com.lucia.jpaservice.services.DetalleVentasService;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="api/jpa/det")
@RestController
public class DetalleVentasController {

    @Autowired
    private DetalleVentasService detalleVentasService;

    @PostMapping
    public ResponseEntity<DetalleVentasModel> create(@RequestBody DetalleVentasModel detalleVentasModel) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.detalleVentasService.create(detalleVentasModel), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<DetalleVentasModel>> findAll(){
        return new ResponseEntity<>(this.detalleVentasService.findAll(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DetalleVentasModel> update(@RequestBody DetalleVentasModel detalleVentasUpdate, @PathVariable Integer id ){
        return new ResponseEntity<>(this.detalleVentasService.update(detalleVentasUpdate, id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){
        this.detalleVentasService.delete(id);
    }

}
