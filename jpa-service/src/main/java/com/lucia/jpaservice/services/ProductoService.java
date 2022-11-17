package com.lucia.jpaservice.services;

import com.lucia.jpaservice.Validator.ProductoValidator;
import com.lucia.jpaservice.exceptions.ResourceAlreadyExistException;
import com.lucia.jpaservice.exceptions.ResourceNotFoundException;
import com.lucia.jpaservice.model.ProductoModel;
import com.lucia.jpaservice.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private ProductoValidator productoValidator;

   public ProductoModel create(ProductoModel productoModel) throws ResourceAlreadyExistException{
       this.productoValidator.validate(productoModel);

       Optional<ProductoModel> productoModel1 = this.productoRepository.findByNombreProducto(productoModel.getNombreProducto());
       if (productoModel1.isPresent()) {
           throw new ResourceAlreadyExistException("El producto ya existe");
       }
           else{
               return this.productoRepository.save(productoModel);
           }
       }
    public List<ProductoModel> findAll(){ return this.productoRepository.findAll(); }

    public ProductoModel update(ProductoModel productoModel, Integer id) throws ResourceNotFoundException{
        if(id<=0) {
            throw new ResourceNotFoundException("Ingrese id de producto.");
        }
        this.productoValidator.validate(productoModel);
        Optional<ProductoModel>productoModelBD = this.productoRepository.findById(id);

        if(productoModelBD.isPresent()){
            ProductoModel producto = productoModelBD.get();
            producto.setNombreProducto(productoModel.getNombreProducto());
            producto.setPrecioCompra(productoModel.getPrecioCompra());
            producto.setPrecioVenta(productoModel.getPrecioVenta());
            producto.setStock(productoModel.getStock());
            return this.productoRepository.save(producto);
        }else {
            throw new ResourceNotFoundException("el id no existe en la base de datos.");
        }
    }
    public void delete(Integer id){this.productoRepository.deleteById(id);
    }
    public List<ProductoModel> getControlStock(Integer stock){
        return this.productoRepository.findByStockLessThan(stock);
    }
}
