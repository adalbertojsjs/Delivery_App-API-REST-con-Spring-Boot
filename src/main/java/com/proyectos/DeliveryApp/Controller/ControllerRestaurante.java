package com.proyectos.DeliveryApp.Controller;

import com.proyectos.DeliveryApp.DTO.RestauranteDTO;
import com.proyectos.DeliveryApp.Model.Restaurante;
import com.proyectos.DeliveryApp.Service.ServiceRestaurante;
import com.proyectos.DeliveryApp.mapper.RestauranteMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/restaurantes")
    public class ControllerRestaurante {

        private final ServiceRestaurante service;

        public ControllerRestaurante(ServiceRestaurante service){
            this.service = service;
        }

        // LISTAR
        @GetMapping
        public ResponseEntity<List<RestauranteDTO>> listar(){
            return ResponseEntity.ok(service.listar().stream().map(RestauranteMapper::toDTO).toList());
        }

        // CREAR
        @PostMapping
        public ResponseEntity<Restaurante> crear(@RequestBody Restaurante restaurante){
            return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(restaurante));
        }

        // ACTUALIZAR
        @PutMapping("/{id}")
        public ResponseEntity<Restaurante> actualizar(@PathVariable Long id,
                                                      @RequestBody Restaurante restaurante){
            return ResponseEntity.ok(service.actualizar(id, restaurante));
        }

        // ELIMINAR
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> eliminar(@PathVariable Long id){
            service.eliminar(id);
            return ResponseEntity.noContent().build(); // 204
        }
    }


