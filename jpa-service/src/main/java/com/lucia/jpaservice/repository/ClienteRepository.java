package com.lucia.jpaservice.repository;

import com.lucia.jpaservice.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel,Integer> {

    Optional<ClienteModel> findById (Integer id);
    Optional<ClienteModel> findByNombre (String nombre);
    Optional<ClienteModel> findByApellido (String apellido);
    Optional<ClienteModel> findByDni (String dni);
    Optional<ClienteModel> findByFechaNacimiento (LocalDate fechaNacimiento);
}
