package com.proyectos.DeliveryApp.Service;

import com.proyectos.DeliveryApp.Model.Rol;
import com.proyectos.DeliveryApp.Model.Usuario;
import com.proyectos.DeliveryApp.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

  private final   UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }



    @Override
    public Usuario crear(Usuario usuario) {
        //Verifica que no introduzcan ID en parametros
        if (usuario.getId() != null){
            throw new IllegalArgumentException("El ID no debe ser enviado");
        }

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarRol(Long id, Rol rolActualizado) {
        //Verifica que introduzcan ID en parametros
        if (id == null ){
            throw  new IllegalArgumentException("El ID es obligatorio");
        }

        //Verifica que introduzcan ROL en parametros
        if (rolActualizado == null){
            throw new IllegalArgumentException("El ROL es obligatorio");
        }

        //Busca el id
        Usuario usuario = usuarioRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("El ID no fue encontrado"));

        if (usuario.getRol() == rolActualizado) {
            throw new IllegalStateException("El usuario ya tiene ese rol");
        }


        //Llama el objeto y modifica  el rol y lo guarda
        usuario.setRol(rolActualizado);
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> listarRol(Rol rol) {
        //Verifica que introduzcan ROL en parametros
        if (rol == null){
            throw new IllegalArgumentException("El ROL es obligatorio");
        }
        return usuarioRepository.findByRol(rol);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        //Verificar que introduzcan ID en parametros
        if (id == null){
            throw new IllegalArgumentException("El ID es obligatorio");
        }
        //Busca el ID y lo retorna en caso de que lo encuentre
         return usuarioRepository.
                findById(id).orElseThrow(() -> new EntityNotFoundException("El USUARIO no se encontro"));


    }
}
