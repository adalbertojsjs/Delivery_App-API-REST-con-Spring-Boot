package com.proyectos.DeliveryApp.Controller;


import com.proyectos.DeliveryApp.Model.Rol;
import com.proyectos.DeliveryApp.Model.Usuario;
import com.proyectos.DeliveryApp.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/usuarios")
public class ControllerUsuario {

   private final UsuarioService service;

    public ControllerUsuario(UsuarioService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        return  ResponseEntity.ok(service.listar());
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(usuario));

    }

    // PATCH /v1/usuarios/{id}/rol?rol=ADMIN
    @PatchMapping("{id}/rol")
    public ResponseEntity<Usuario> actualizarRol(@PathVariable Long id, @RequestParam Rol rol){
        return ResponseEntity.ok(service.actualizarRol(id , rol));
    }

    @GetMapping(params = "rol")
    public ResponseEntity<List<Usuario>> listarPor_Rol(@RequestParam Rol rol){
        return ResponseEntity.ok(service.listarRol(rol));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));

    }


    //Endpoints:

   // GET    /v1/usuarios
    //POST   /v1/usuarios
    //GET    /v1/usuarios/{id}
    //PATCH  /v1/usuarios/{id}/rol?rol=REPARTIDOR
    //GET    /v1/usuarios?rol=CLIENTE


}
