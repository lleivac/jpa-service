package com.lucia.jpaservice.services;

import com.lucia.jpaservice.Validator.DetalleVentasValidator;
import com.lucia.jpaservice.exceptions.ResourceAlreadyExistException;
import com.lucia.jpaservice.exceptions.ResourceNotFoundException;
import com.lucia.jpaservice.model.ClienteModel;
import com.lucia.jpaservice.model.DetalleVentasModel;
import com.lucia.jpaservice.model.ProductoModel;
import com.lucia.jpaservice.repository.ClienteRepository;
import com.lucia.jpaservice.repository.DetalleVentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class DetalleVentasService {

    @Autowired
    private DetalleVentasRepository detalleVentasRepository;
    @Autowired
    private DetalleVentasValidator detalleVentasValidator;

    public DetalleVentasModel create(DetalleVentasModel detalleVentasModel){
        this.detalleVentasValidator.validate(detalleVentasModel);

            return this.detalleVentasRepository.save(detalleVentasModel);

    }

    public List<DetalleVentasModel> findAll(){ return this.detalleVentasRepository.findAll(); }
    public DetalleVentasModel update(DetalleVentasModel detalleVentasModel, Integer id){
        Optional<DetalleVentasModel> detalleVentasModelBD = this.detalleVentasRepository.findById(id);
        if(detalleVentasModelBD.isPresent()){
            DetalleVentasModel detalle = detalleVentasModelBD.get();
            detalle.setCantidad(detalleVentasModel.getCantidad());
            detalle.setSubTotal(detalleVentasModel.getSubTotal());
            detalle.setProducto(detalleVentasModel.getProducto());

            return this.detalleVentasRepository.save(detalle);
        }else {
            return null;

        }
    }
    public void delete(Integer id){this.detalleVentasRepository.deleteById(id);
    }

}
