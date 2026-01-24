package com.proyectos.DeliveryApp.Controller;


import com.proyectos.DeliveryApp.DTO.ProductoDTO;
import com.proyectos.DeliveryApp.Model.Disponible;
import com.proyectos.DeliveryApp.Model.Producto;
import com.proyectos.DeliveryApp.Service.ProductoService;
import com.proyectos.DeliveryApp.mapper.ProductoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/productos")
public class ControllerProducto {

    private final ProductoService service;

    public ControllerProducto(ProductoService service){
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<ProductoDTO>> listar(){
        return ResponseEntity.ok(service.listar().stream().map(ProductoMapper::toDTO).toList());//200.ok
    }

    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(producto));//201
    }

    @PatchMapping("/{id}/disponible")
    public ResponseEntity<Producto> actualizarDisponibilidad(@PathVariable Long id,
                                                             @RequestParam Disponible disponible){
        return ResponseEntity.ok().body(service.cambiarDisponibilidad(id,disponible));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> buscarId(@PathVariable Long id){
       Producto producto = service.buscarPorId(id);
        ProductoDTO productoDTO = ProductoMapper.toDTO(producto);
      return ResponseEntity.ok(productoDTO);
    }

    @GetMapping(params = "restauranteId")
    public ResponseEntity<List<Producto>> listarPor_Restaurante(@RequestParam Long restauranteId){
        return ResponseEntity.ok(service.listarPorRestaurante(restauranteId));
    }

    //URL para las peticiones HTTP
    //GET    /v1/pedidos
    //POST   /v1/pedidos
    //DELETE /v1/pedidos/{id}
    //
    //PUT    /v1/pedidos/{id}/estado?estado=EN_CAMINO
    //PUT    /v1/pedidos/{id}/repartidor?repartidorId=7
    //
    //GET    /v1/pedidos?estado=ENTREGADO
    //GET    /v1/pedidos?clienteId=5
    //GET    /v1/pedidos?restauranteId=3
}
