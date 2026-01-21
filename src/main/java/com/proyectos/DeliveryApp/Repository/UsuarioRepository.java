package com.proyectos.DeliveryApp.Repository;

import com.proyectos.DeliveryApp.Model.Rol;
import com.proyectos.DeliveryApp.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByRol(Rol rol);
}
