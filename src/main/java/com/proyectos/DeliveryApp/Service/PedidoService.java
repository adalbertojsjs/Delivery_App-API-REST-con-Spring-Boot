package com.proyectos.DeliveryApp.Service;

import com.proyectos.DeliveryApp.Model.EstadoPedido;
import com.proyectos.DeliveryApp.Model.Pedido;

import java.util.List;

public interface PedidoService {

    Pedido crear(Pedido pedido);

    public List<Pedido> listar();

    Pedido cancelar(Long id);

    Pedido cambiarEstado(Long id, EstadoPedido estado);

    Pedido asignarRepartidor(Long pedidoId, Long repartidorId);

    List<Pedido> obtenerPedidosPorCliente(Long clienteId);

    List<Pedido> obtenerPedidosPorRestaurante(Long restauranteId);

    List<Pedido> obtenerPorEstado(EstadoPedido estado);

    Pedido buscarPorId(Long id);


}
