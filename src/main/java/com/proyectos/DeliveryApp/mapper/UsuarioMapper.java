package com.proyectos.DeliveryApp.mapper;

import com.proyectos.DeliveryApp.DTO.UsuarioDTO;
import com.proyectos.DeliveryApp.Model.Usuario;

public class UsuarioMapper {


    public static UsuarioDTO toDTO(Usuario usuario){
        if (usuario == null){
            return  null;
        }

        return new UsuarioDTO(usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getRol());

    }
}
