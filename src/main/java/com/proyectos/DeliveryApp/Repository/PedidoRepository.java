package com.proyectos.DeliveryApp.Repository;

import com.proyectos.DeliveryApp.Model.EstadoPedido;
import com.proyectos.DeliveryApp.Model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {


    List<Pedido> findByClienteId(Long clienteId);

    List<Pedido> findByRestauranteId(Long restauranteId);

    List<Pedido> findByEstadoPedido(EstadoPedido estadoPedido);
}
