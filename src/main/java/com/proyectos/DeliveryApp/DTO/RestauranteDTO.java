package com.proyectos.DeliveryApp.DTO;

import com.proyectos.DeliveryApp.Model.EstadoRestaurante;

public class RestauranteDTO {

    private Long id;
    private  String nombre;
    private String direccion;
    private EstadoRestaurante estado;


    public RestauranteDTO(Long id, String nombre,String direccion, EstadoRestaurante estado) {
        this.id = id;
        this.direccion= direccion;
        this.estado = estado;
        this.nombre = nombre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public EstadoRestaurante getEstado() {
        return estado;
    }

    public void setEstado(EstadoRestaurante estado) {
        this.estado = estado;
    }
}
