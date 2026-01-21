package com.proyectos.DeliveryApp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "productos")
public class Producto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private BigDecimal precio;

    @Enumerated(EnumType.STRING)
    private Disponible disponible;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    @JsonBackReference(value = "restaurante-productos")
    private Restaurante restaurante;

    @OneToMany(mappedBy = "producto")
    private List<DestallesPedidos> destallesPedidos;


    public Producto(){

    }

    public Producto(Long id, String nombre, BigDecimal precio, Disponible disponible, Restaurante restaurante) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.disponible = disponible;
        this.restaurante = restaurante;
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

    public BigDecimal  getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Disponible getDisponible() {
        return disponible;
    }

    public void setDisponible(Disponible disponible) {
        this.disponible = disponible;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }


}
