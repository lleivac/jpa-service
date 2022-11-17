package com.lucia.jpaservice.controller;

import com.lucia.jpaservice.exceptions.ResourceAlreadyExistException;
import com.lucia.jpaservice.exceptions.ResourceNotFoundException;
import com.lucia.jpaservice.model.ClienteModel;
import com.lucia.jpaservice.model.DetalleVentasModel;
import com.lucia.jpaservice.model.ProductoModel;
import com.lucia.jpaservice.services.DetalleVentasService;
import com.lucia.jpaservice.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path="api/jpa/prod")
@RestController
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoModel> create(@RequestBody ProductoModel productoModel) throws ResourceAlreadyExistException {
        return new ResponseEntity<>(this.productoService.create(productoModel), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ProductoModel>> findAll(){
        return new ResponseEntity<>(this.productoService.findAll(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductoModel> update(@RequestBody ProductoModel productoUpdate, @PathVariable Integer id ) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.productoService.update(productoUpdate, id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Integer id){
        this.productoService.delete(id);
    }


}
