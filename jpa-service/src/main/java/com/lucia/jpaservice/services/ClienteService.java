package com.lucia.jpaservice.services;

import com.lucia.jpaservice.Validator.ClienteValidator;
import com.lucia.jpaservice.exceptions.ResourceAlreadyExistException;
import com.lucia.jpaservice.exceptions.ResourceNotFoundException;
import com.lucia.jpaservice.model.ClienteModel;
import com.lucia.jpaservice.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteValidator clienteValidator;


    public ClienteModel create(ClienteModel clienteModel) throws ResourceAlreadyExistException {
        this.clienteValidator.validate(clienteModel);
        Optional<ClienteModel> clienteModel1 = this.clienteRepository.findByDni(clienteModel.getDni());
        if(clienteModel1.isPresent()){
            throw new ResourceAlreadyExistException( "El cliente ya existe.");
        }else{
        return this.clienteRepository.save(clienteModel);
    }
    }
    public List<ClienteModel> findAll(){ return this.clienteRepository.findAll(); }
    public ClienteModel update(ClienteModel clienteModel, Integer id) throws ResourceNotFoundException{
        if(id<=0){
            throw new ResourceNotFoundException("Ingrese id de cliente a modificar.");
        }
        this.clienteValidator.validate(clienteModel);
        Optional<ClienteModel>clienteModelBD = this.clienteRepository.findById(id);
        if(clienteModelBD.isPresent()){
            ClienteModel cliente = clienteModelBD.get();
            cliente.setApellido(clienteModel.getApellido());
            cliente.setNombre(clienteModel.getNombre());
            cliente.setDni(clienteModel.getDni());
            cliente.setFechaNacimiento(clienteModel.getFechaNacimiento());
            return this.clienteRepository.save(cliente);
        }else {

            throw new ResourceNotFoundException("el id no existe en la base de datos.");
        }
    }
    public void delete(Integer id){this.clienteRepository.deleteById(id);
    }
    public ClienteModel getClientConEdad(Integer id){
        ClienteModel cliente = clienteRepository.findById(id).get();
        LocalDate fechaNacimiento = cliente.getFechaNacimiento();
        ChronoUnit.YEARS.between(fechaNacimiento, LocalDate.now());

        return cliente;

    }
}
