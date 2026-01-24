package com.proyectos.DeliveryApp.mapper;

import com.proyectos.DeliveryApp.DTO.PedidoDTO;
import com.proyectos.DeliveryApp.DTO.RestauranteDTO;
import com.proyectos.DeliveryApp.DTO.UsuarioDTO;
import com.proyectos.DeliveryApp.Model.Pedido;

public class PedidoMapper {

    public static PedidoDTO toDTO(Pedido pedido){

        //Para acceder al nombre del cliente y su Id,
        //Pero no estoy accediendo a la entidad si construyendo un DTO con los datos minimos que quiero devolver
        UsuarioDTO clienteDTO = new UsuarioDTO(pedido.getCliente().getId(),
                pedido.getCliente().getNombre(),
                pedido.getCliente().getEmail(),
                pedido.getCliente().getRol());


        //Para acceder al nombre del repartidor y su Id,
        //Pero no estoy accediendo a la entidad si construyendo un DTO con los datos minimos que quiero devolver
        UsuarioDTO repartidorDTO = pedido.getRepartidor() != null ? new UsuarioDTO(pedido.getRepartidor().getId(),
                pedido.getRepartidor().getNombre(),
                pedido.getCliente().getEmail(),
                pedido.getCliente().getRol()): null;


        //Para acceder al Nombre del restaurante y su Id,
        //Pero no estoy accediendo a la entidad si construyendo un DTO con los datos minimos que quiero devolver
        RestauranteDTO restauranteDTO = new RestauranteDTO(pedido.getRestaurante().getId()
                ,pedido.getRestaurante().getNombre(),pedido.getRestaurante().getDireccion(),
                pedido.getRestaurante().getEstado());

        return new PedidoDTO(
                pedido.getId(),
                pedido.getFecha(),
                pedido.getTotal(),
                pedido.getEstadoPedido(),
                clienteDTO,
                repartidorDTO,
                restauranteDTO
        );
    }
}
