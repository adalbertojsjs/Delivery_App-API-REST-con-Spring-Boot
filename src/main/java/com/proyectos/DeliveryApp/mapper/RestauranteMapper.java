package com.proyectos.DeliveryApp.mapper;

import com.proyectos.DeliveryApp.DTO.RestauranteDTO;
import com.proyectos.DeliveryApp.Model.Restaurante;

public class RestauranteMapper {

    public static RestauranteDTO toDTO(Restaurante restaurante){

        if (restaurante== null){
            return  null;
        }

        return new RestauranteDTO(restaurante.getId(),
                restaurante.getNombre(),
                restaurante.getDireccion(),
                restaurante.getEstado()
                );

    }
}
