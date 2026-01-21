package com.proyectos.DeliveryApp.Service;

import com.proyectos.DeliveryApp.Model.Rol;
import com.proyectos.DeliveryApp.Model.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario crear(Usuario usuario);

    Usuario actualizarRol(Long id, Rol rolActualizado);

    List<Usuario> listarRol(Rol rol);

    Usuario buscarPorId(Long id);


    public List<Usuario> listar();


}
