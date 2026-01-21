package com.proyectos.DeliveryApp.Controller;

import com.proyectos.DeliveryApp.Model.EstadoPedido;
import com.proyectos.DeliveryApp.Model.Pedido;
import com.proyectos.DeliveryApp.Service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pedidos")
public class ControllerPedido {

    private final PedidoService service;

    public ControllerPedido(PedidoService service){
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Pedido>> listar(){
        return ResponseEntity.ok().body(service.listar());//200.ok
    }

    @PostMapping
    public ResponseEntity<Pedido> crear(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(pedido));//201
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id){
        service.cancelar(id);
        return ResponseEntity.noContent().build();//204
    }

    @PatchMapping("/{id}/estadoPedido")
    public ResponseEntity<Pedido> actualizarEstado(@PathVariable Long id ,
                                                   @RequestParam EstadoPedido estadoPedido){
        return ResponseEntity.ok(service.cambiarEstado(id, estadoPedido));
    }

    @PatchMapping("/{id}/repartidor")
    public ResponseEntity<Pedido> asignarPedido(@PathVariable Long id
            ,@RequestParam Long repartidor){

               //respuesta http  -  el cuerpo de la respuesta
        return ResponseEntity.ok().body(service.asignarRepartidor(id, repartidor));//200.ok

    }

    @GetMapping(params = "restauranteId")
    public ResponseEntity<List<Pedido>> listarPor_Restaurante(@RequestParam Long restauranteId){
        return  ResponseEntity.ok(service.obtenerPedidosPorRestaurante(restauranteId));//200.ok
    }

    @GetMapping(params = "clienteId")
    public ResponseEntity<List<Pedido>> listarPor_Cliente(@RequestParam Long clienteId){
        return ResponseEntity.ok(service.obtenerPedidosPorCliente(clienteId));//200.ok
    }

    @GetMapping(params = "estado")
    public ResponseEntity<List<Pedido>> listarPor_Estado(@RequestParam EstadoPedido estado){
        return ResponseEntity.ok(service.obtenerPorEstado(estado));
    }

    //URL para llamar los metodos
    //GET /v1/pedidos
    //GET /v1/pedidos?estado=EN_CAMINO
    //GET /v1/pedidos?clienteId=5
    //GET /v1/pedidos?restauranteId=3
    //PUT /v1/pedidos/10/estado?estado=ENTREGADO
    //PUT /v1/pedidos/10/repartidor?repartidorId=7
    //DELETE /v1/pedidos/10

}
