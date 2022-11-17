package com.lucia.jpaservice.services;

import com.lucia.jpaservice.Validator.ClienteValidator;
import com.lucia.jpaservice.Validator.VentasValidator;
import com.lucia.jpaservice.exceptions.ResourceAlreadyExistException;
import com.lucia.jpaservice.exceptions.ResourceNotFoundException;
import com.lucia.jpaservice.model.ClienteModel;
import com.lucia.jpaservice.model.ProductoModel;
import com.lucia.jpaservice.model.VentasModel;
import com.lucia.jpaservice.repository.ClienteRepository;
import com.lucia.jpaservice.repository.ProductoRepository;
import com.lucia.jpaservice.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentasService {

    @Autowired
    private VentaRepository ventaRepository;
    @Autowired
    private VentasValidator ventasValidator;
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    private ClienteModel clienteModel;
    private Integer id;

    public VentasModel create(VentasModel ventasModel)throws ResourceNotFoundException {
        this.ventasValidator.validate(ventasModel);

            return this.ventaRepository.save(ventasModel);

    }



    public List<VentasModel> findAll() { return this.ventaRepository.findAll(); }

    public VentasModel update(VentasModel ventasModel, Integer id) throws ResourceNotFoundException {
        Optional<VentasModel> VentasModelBD = this.ventaRepository.findById(id);
        if (VentasModelBD.isPresent()) {
            VentasModel venta = VentasModelBD.get();
            venta.setMontoTotal(ventasModel.getMontoTotal());
            return this.ventaRepository.save(venta);
        } else {
            throw new ResourceNotFoundException("No existe venta");

        }
    }

    public String delete(Integer id) throws ResourceNotFoundException {
        Optional<VentasModel> VentasModelBD = this.ventaRepository.findById(id);
        if (VentasModelBD.isPresent()) {
            VentasModelBD.get();
            this.ventaRepository.deleteById(id);
            return "Venta Eliminada";
        }
        throw new ResourceNotFoundException("La venta no existe");
    }

}
