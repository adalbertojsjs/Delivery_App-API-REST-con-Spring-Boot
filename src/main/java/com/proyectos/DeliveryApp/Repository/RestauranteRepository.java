package com.proyectos.DeliveryApp.Repository;

import com.proyectos.DeliveryApp.Model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
