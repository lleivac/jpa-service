package com.lucia.jpaservice.controller;

import com.lucia.jpaservice.exceptions.ResourceAlreadyExistException;
import com.lucia.jpaservice.exceptions.ResourceNotFoundException;
import com.lucia.jpaservice.model.ClienteModel;
import com.lucia.jpaservice.model.DetalleVentasModel;
import com.lucia.jpaservice.model.VentasModel;
import com.lucia.jpaservice.services.VentasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="api/jpa/vta")
@RestController
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @PostMapping
    public ResponseEntity<VentasModel> create(@RequestBody VentasModel ventasModel) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ventasService.create(ventasModel), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<VentasModel>>findAll(){
        return new ResponseEntity<>(this.ventasService.findAll(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<VentasModel> update(@RequestBody VentasModel ventasUpdate, @PathVariable Integer id ) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ventasService.update(ventasUpdate, id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id) throws ResourceNotFoundException {
        this.ventasService.delete(id);
    }


}
