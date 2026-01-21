package com.proyectos.DeliveryApp.Repository;

import com.proyectos.DeliveryApp.Model.Producto;
import com.proyectos.DeliveryApp.Model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByRestauranteId(Long restauranteId);
}
