package com.proyectos.DeliveryApp.Service;

import com.proyectos.DeliveryApp.Model.EstadoPedido;
import com.proyectos.DeliveryApp.Model.Pedido;
import com.proyectos.DeliveryApp.Model.Rol;
import com.proyectos.DeliveryApp.Model.Usuario;
import com.proyectos.DeliveryApp.Repository.PedidoRepository;
import com.proyectos.DeliveryApp.Repository.RestauranteRepository;
import com.proyectos.DeliveryApp.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService{

   private final PedidoRepository repository;

   private final UsuarioRepository usuarioRepository;

   private final RestauranteRepository restauranteRepository;


    //Inyeccion de dependecias por constructor
    public PedidoServiceImpl(PedidoRepository repository, UsuarioRepository usuarioRepository,
                             RestauranteRepository restauranteRepository){
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.restauranteRepository = restauranteRepository;
    }



    @Override
    public List<Pedido> listar() {
        return repository.findAll();
    }


    @Override
    public Pedido crear(Pedido pedido) {
        // 🔎 Validar cliente
        Long clienteId = pedido.getCliente().getId();

        Usuario cliente = usuarioRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        // 🔗 Asignar cliente persistido
        pedido.setCliente(cliente);

        // 📅 Valores por defecto
        pedido.setFecha(LocalDateTime.now());
        pedido.setEstadoPedido(EstadoPedido.ACEPTADO);

        return repository.save(pedido);
    }


    @Override
    public Pedido cancelar(Long id) {
        if (id == null){
            throw  new IllegalStateException("El ID es obligatorio");
        }

        Pedido pedido1 = repository.findById(id).
                orElseThrow(() -> new IllegalStateException("El ID no fue encontrado"));

        pedido1.setEstadoPedido(EstadoPedido.CANCELADO);
        return repository.save(pedido1);
    }

    @Override
    public Pedido cambiarEstado(Long id, EstadoPedido estado) {
        if (id == null){
            throw  new IllegalStateException("El ID es obligatorio");
        }
        Pedido pedido = repository.findById(id).
                orElseThrow(() -> new IllegalStateException("El ID no fue encontrado"));

        //Evitar que cambien un pedido finalizado
        if(pedido.getEstadoPedido() == EstadoPedido.ENTREGADO ||
                pedido.getEstadoPedido() == EstadoPedido.CANCELADO){
            throw  new IllegalStateException("El estado no se puede modificar una vez este finalizado");
        }

        pedido.setEstadoPedido(estado);
        return repository.save(pedido);
    }

    @Override
    public Pedido asignarRepartidor(Long pedidoId, Long repartidorId) {
        if (pedidoId == null) {
            throw new IllegalArgumentException("El ID del pedido es obligatorio");
        }
        if (repartidorId == null) {
            throw new IllegalArgumentException("El ID del repartidor es obligatorio");
        }

        // Buscar pedido
        Pedido pedido = repository.findById(pedidoId)
                .orElseThrow(() -> new EntityNotFoundException("El pedido no fue encontrado"));

        // Validar estado del pedido
        if (pedido.getEstadoPedido() == EstadoPedido.CANCELADO ||
                pedido.getEstadoPedido() == EstadoPedido.ENTREGADO) {
            throw new IllegalStateException("No se puede asignar repartidor a un pedido finalizado");
        }

        // Validar que no tenga repartidor
        if (pedido.getRepartidor() != null) {
            throw new IllegalStateException("El pedido ya tiene repartidor asignado");
        }

        // Buscar repartidor
        Usuario repartidor = usuarioRepository.findById(repartidorId)
                .orElseThrow(() -> new EntityNotFoundException("El repartidor no fue encontrado"));

        // Validar rol (que el usuario sea repartidor)
        if (repartidor.getRol() != Rol.REPARTIDOR) {
            throw new IllegalStateException("El usuario no es repartidor");
        }

        // Asignar repartidor
        pedido.setRepartidor(repartidor);
        pedido.setEstadoPedido(EstadoPedido.EN_CAMINO);

        return repository.save(pedido);
    }

    @Override
    public List<Pedido> obtenerPedidosPorCliente(Long clienteId) {
        if(clienteId == null){
            throw new IllegalArgumentException("El ID del cliente es obligatorio");
        }

        //Verifica que exista un cliente con es ID
        if (!usuarioRepository.existsById(clienteId)){
            throw new  EntityNotFoundException("El cliente no existe");
        }

        return repository.findByClienteId(clienteId);
    }

    @Override
    public List<Pedido> obtenerPedidosPorRestaurante(Long restauranteId) {

        if (restauranteId == null){
            throw new IllegalArgumentException("El ID del restaurante es obligatorio");
        }

        //Verifica que exista un restaurante con es ID
        if (!restauranteRepository.existsById(restauranteId)){
            throw new EntityNotFoundException("El restaurante no existe");
        }

        return repository.findByRestauranteId(restauranteId);
    }

    @Override
    public List<Pedido> obtenerPorEstado(EstadoPedido estado) {

        if (estado == null){
        throw new IllegalArgumentException("El ESTADO del pedido es obligatorio");
        }

        return repository.findByEstadoPedido(estado);
    }

}
