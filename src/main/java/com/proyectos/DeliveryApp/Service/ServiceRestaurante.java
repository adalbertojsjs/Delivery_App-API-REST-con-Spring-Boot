package com.proyectos.DeliveryApp.Service;

import com.proyectos.DeliveryApp.Model.Restaurante;

import java.util.List;

public interface ServiceRestaurante {



        List<Restaurante> listar();
        Restaurante crear(Restaurante restaurante);
        Restaurante actualizar(Long id, Restaurante restaurante);
        void eliminar(Long id);


}
