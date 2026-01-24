package com.proyectos.DeliveryApp.DTO;

import com.proyectos.DeliveryApp.Model.Disponible;

import java.math.BigDecimal;

public class ProductoDTO {

    private Long id;
    private String nombre;
    private BigDecimal precio;
    private Disponible disponible;

    private RestauranteDTO restauranteDTO;


    public ProductoDTO(Long id, String nombre, BigDecimal precio, Disponible disponible, RestauranteDTO restauranteDTO) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.restauranteDTO = restauranteDTO;
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

    public Disponible getDisponible() {
        return disponible;
    }

    public void setDisponible(Disponible disponible) {
        this.disponible = disponible;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public RestauranteDTO getRestauranteDTO() {
        return restauranteDTO;
    }

    public void setRestauranteDTO(RestauranteDTO restauranteDTO) {
        this.restauranteDTO = restauranteDTO;
    }
}
