package com.proyectos.DeliveryApp.Model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "detalles_pedidos")
public class DestallesPedidos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private BigDecimal precioUnitario;


    @ManyToOne
    @JoinColumn(name = "producto_id" , nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "pedido_id" , nullable = false)
    private Pedido pedido;


    public DestallesPedidos(){


    }

    public DestallesPedidos(Long id, Integer cantidad,
                            BigDecimal precioUnitario, Producto producto, Pedido pedido) {
        this.id = id;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.producto = producto;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}

