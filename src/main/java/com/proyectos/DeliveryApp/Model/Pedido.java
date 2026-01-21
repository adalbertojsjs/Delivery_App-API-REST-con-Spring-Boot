package com.proyectos.DeliveryApp.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    private EstadoPedido estadoPedido;

    // CLIENTE -> 1 a N
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;

    // REPARTIDOR -> 1 a N
    @ManyToOne
    @JoinColumn(name = "repartidor_id")
    private Usuario repartidor;

    // RESTAURANTE -> 1 a N
    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    @JsonBackReference(value = "restaurante-pedidos")
    private Restaurante restaurante;

    // PEDIDO -> DETALLE PEDIDO (1 a N)
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DestallesPedidos> detalles;


public Pedido(){

    }

    public Pedido(Long id, LocalDateTime fecha, BigDecimal total,
                  EstadoPedido estadoPedido, Usuario cliente, Usuario repartidor, Restaurante restaurante) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.estadoPedido = estadoPedido;
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

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Usuario getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Usuario repartidor) {
        this.repartidor = repartidor;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }
}
