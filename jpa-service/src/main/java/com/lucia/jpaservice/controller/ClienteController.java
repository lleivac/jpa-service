package com.lucia.jpaservice.controller;
import com.lucia.jpaservice.exceptions.ResourceAlreadyExistException;
import com.lucia.jpaservice.exceptions.ResourceNotFoundException;
import com.lucia.jpaservice.model.ClienteModel;
import com.lucia.jpaservice.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
@RequestMapping(path="api/jpa/cli")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteModel> create(@RequestBody ClienteModel clienteModel) throws ResourceAlreadyExistException {
        return new ResponseEntity<>(this.clienteService.create(clienteModel), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){
        return new ResponseEntity<>(this.clienteService.findAll(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> update(@RequestBody ClienteModel clienteUpdate, @PathVariable Integer id )throws ResourceNotFoundException {
        return new ResponseEntity<>(this.clienteService.update(clienteUpdate, id),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
        public void delete(@PathVariable("id")Integer id){
        this.clienteService.delete(id);
    }


}
