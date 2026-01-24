package com.proyectos.DeliveryApp.Exception;

import com.proyectos.DeliveryApp.Model.Producto;

public class ProductoNoEncontrado extends RuntimeException{

    public ProductoNoEncontrado(Long id){
        super("Pedido con id " + id + " no fue encontrado");
    }
}
