package com.proyectos.DeliveryApp.DTO;

import com.proyectos.DeliveryApp.Model.EstadoPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoDTO {

    private Long id;
    private LocalDateTime fecha;
    private BigDecimal total;
    private EstadoPedido estado;

    private UsuarioDTO cliente;
    private UsuarioDTO repartidor;
    private RestauranteDTO restaurante;

    public PedidoDTO(Long id, LocalDateTime fecha, BigDecimal  total, EstadoPedido estado,
                     UsuarioDTO cliente, UsuarioDTO repartidor, RestauranteDTO restaurante) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
        this.cliente = cliente;
        this.repartidor = repartidor;
        this.restaurante = restaurante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public UsuarioDTO getCliente() {
        return cliente;
    }

    public void setCliente(UsuarioDTO cliente) {
        this.cliente = cliente;
    }

    public UsuarioDTO getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(UsuarioDTO repartidor) {
        this.repartidor = repartidor;
    }

    public RestauranteDTO getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteDTO restaurante) {
        this.restaurante = restaurante;
    }
}
