package com.proyectos.DeliveryApp.Service;

import com.proyectos.DeliveryApp.Model.Disponible;
import com.proyectos.DeliveryApp.Model.Producto;
import com.proyectos.DeliveryApp.Repository.ProductoRepository;
import com.proyectos.DeliveryApp.Repository.RestauranteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService{

    private  final ProductoRepository productoRepository;
    private  final RestauranteRepository restauranteRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository, RestauranteRepository restauranteRepository){
        this.productoRepository = productoRepository;
        this.restauranteRepository = restauranteRepository;
    }


    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }


    @Override
    public Producto crear(Producto producto) {
        if (producto == null){
            throw  new IllegalArgumentException("No puede estar vacio el parametro");
        }
        if (producto.getId() != null){
            throw  new IllegalArgumentException("El ID no debe ser ingresado");
        }
        if (producto.getDisponible() == Disponible.AGOTADO){
            throw new IllegalArgumentException("No puedes crear un producto y que este agotado");
        }

        if (producto.getRestaurante() == null || producto.getRestaurante().getId() == null) {
            throw new IllegalArgumentException("El restaurante es obligatorio");
        }


        return productoRepository.save(producto);

    }

    @Override
    public Producto cambiarDisponibilidad(Long id, Disponible disponible) {
        if (id == null){
            throw new IllegalArgumentException("El Id es obligatorio");
        }

        if (disponible == null) {
            throw new IllegalArgumentException("El estado de disponibilidad es obligatorio");
        }

        Producto producto =  productoRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        producto.setDisponible(disponible);
       return productoRepository.save(producto);


    }

    @Override
    public List<Producto> listarPorRestaurante(Long restauranteId) {
        if (restauranteId == null){
            throw new IllegalArgumentException("El Id del restaurante es obligatorio");
        }

        if (!restauranteRepository.existsById(restauranteId)){
            throw new EntityNotFoundException("El ID no existe");
        }

       return productoRepository.findByRestauranteId(restauranteId);

    }

    @Override
    public Producto buscarPorId(Long id) {
        if (id == null){
            throw new IllegalArgumentException("El Id es obligatorio");
        }

       return productoRepository.findById(id).orElseThrow
                (() -> new EntityNotFoundException("Producto no encontrado"));


    }
}
