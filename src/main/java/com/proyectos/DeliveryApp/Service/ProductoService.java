package com.proyectos.DeliveryApp.Service;

import com.proyectos.DeliveryApp.Model.Disponible;
import com.proyectos.DeliveryApp.Model.Producto;

import java.util.List;

public interface ProductoService {




    public List<Producto> listar();

    Producto crear(Producto producto);
    Producto cambiarDisponibilidad(Long id, Disponible disponible);
    List<Producto> listarPorRestaurante(Long restauranteId);
    Producto buscarPorId(Long id);

}
