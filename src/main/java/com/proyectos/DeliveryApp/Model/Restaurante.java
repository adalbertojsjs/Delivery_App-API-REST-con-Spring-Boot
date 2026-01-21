package com.proyectos.DeliveryApp.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurantes")
public class Restaurante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Enumerated(EnumType.STRING)
    private EstadoRestaurante estado;


    @OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "restaurante-pedidos")
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "restaurante", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "restaurante-productos")
    private List<Producto> productos;


    public Restaurante() {
    }

    public Restaurante(Long id, String nombre, String direccion, EstadoRestaurante estado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.estado = estado;
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Producto> getProducto() {
        return productos;
    }

    public void setProducto(List<Producto> producto) {
        this.productos = producto;
    }
}
