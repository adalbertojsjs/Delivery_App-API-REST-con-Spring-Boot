package com.proyectos.DeliveryApp.Exception;

public class UsuarioNoEncontradoException extends  RuntimeException{

    public UsuarioNoEncontradoException(Long id){
        super("Usuario con id " + id + " no fue encontrado");
    }
}
