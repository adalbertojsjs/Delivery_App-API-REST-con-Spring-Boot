package com.proyectos.DeliveryApp.mapper;

import com.proyectos.DeliveryApp.DTO.ProductoDTO;
import com.proyectos.DeliveryApp.DTO.RestauranteDTO;
import com.proyectos.DeliveryApp.Model.Producto;

public class ProductoMapper {

    public static ProductoDTO toDTO(Producto producto){

        if (producto == null){
            return null;
        }

        RestauranteDTO restauranteDTO = new RestauranteDTO(producto.getRestaurante().getId()
                ,producto.getRestaurante().getNombre(),producto.getRestaurante()
                .getDireccion(),producto.getRestaurante().getEstado()
        );

        return new ProductoDTO(producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getDisponible(),
                restauranteDTO);
    }
}
