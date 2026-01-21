package com.proyectos.DeliveryApp.Service;

import com.proyectos.DeliveryApp.Model.Restaurante;
import com.proyectos.DeliveryApp.Repository.RestauranteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteServiceImpl implements ServiceRestaurante {

    private final RestauranteRepository repository;

    public RestauranteServiceImpl(RestauranteRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Restaurante> listar() {
        return repository.findAll();
    }

    @Override
    public Restaurante crear(Restaurante restaurante) {
        return repository.save(restaurante);
    }

    @Override
    public Restaurante actualizar(Long id, Restaurante restaurante) {
        Restaurante restauranteExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));

        restauranteExistente.setNombre(restaurante.getNombre());
        restauranteExistente.setDireccion(restaurante.getDireccion());

        return repository.save(restauranteExistente);
    }

    @Override
    public void eliminar(Long id) {
        Restaurante restauranteExistente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurante no encontrado"));
        repository.delete(restauranteExistente);
    }
}

