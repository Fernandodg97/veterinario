package net.xeill.elpuig.veterinario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.xeill.elpuig.veterinario.model.*;
import net.xeill.elpuig.veterinario.service.*;

@RestController
@RequestMapping("/api/usuarios") // Define el punto de acceso para las solicitudes HTTP que se refieren a los usuarios.
public class UsuarioController {

    private final UsuarioService usuarioService; // Dependencia del servicio para gestionar la lógica de negocio de los usuarios.

    @Autowired // Inyección de dependencias del servicio UsuarioService.
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Crear un nuevo usuario
    @PostMapping // Método que maneja solicitudes POST para crear un nuevo usuario.
    public UsuarioModel crearUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.guardarUsuario(usuario); // Llama al servicio para guardar el usuario.
    }

    // Obtener un usuario por su ID
    @GetMapping("/{id}") // Método que maneja solicitudes GET para obtener un usuario por su ID.
    public UsuarioModel obtenerUsuarioId(@PathVariable String id) {
        return usuarioService.obtenerUsuarioPorId(id); // Llama al servicio para obtener un usuario por su ID.
    }

    // Obtener todos los usuarios
    @GetMapping // Método que maneja solicitudes GET para obtener todos los usuarios.
    public ResponseEntity<List<UsuarioModel>> obtenerTodosUsuarios() {
        List<UsuarioModel> usuarios = usuarioService.obtenerUsuarios(); // Llama al servicio para obtener la lista de usuarios.
        return ResponseEntity.ok(usuarios); // Devuelve la lista de usuarios con un código de estado HTTP 200 (OK).
    }

    // Actualizar un usuario por su ID
    @PutMapping("/{id}") // Método que maneja solicitudes PUT para actualizar un usuario por su ID.
    public ResponseEntity<UsuarioModel> editarUsuario(@PathVariable String id,
            @RequestBody UsuarioModel usuarioActualizado) {
        UsuarioModel usuario = usuarioService.editarUsuarioPorId(id, usuarioActualizado); // Llama al servicio para actualizar el usuario.
        if (usuario != null) {
            return ResponseEntity.ok(usuario); // Si el usuario se encuentra, devuelve el usuario actualizado con un código de estado 200 (OK).
        } else {
            return ResponseEntity.notFound().build(); // Si el usuario no se encuentra, devuelve un código de estado HTTP 404 (Not Found).
        }
    }

    // Eliminar un usuario por su ID
    @DeleteMapping("/{id}") // Método que maneja solicitudes DELETE para eliminar un usuario por su ID.
    public ResponseEntity<String> eliminarUsuario(@PathVariable String id) {
        usuarioService.eliminarUsuarioPorId(id); // Llama al servicio para eliminar al usuario por su ID.
        return ResponseEntity.ok("Usuario eliminado con éxito."); // Devuelve un mensaje confirmando la eliminación.
    }

    // ### MASCOTAS ### //

    // Agregar una mascota a un usuario
    @PostMapping("/{id}/mascotas") // Método que maneja solicitudes POST para agregar una mascota a un usuario.
    public ResponseEntity<UsuarioModel> agregarMascota(@PathVariable String id, @RequestBody MascotaModel mascota) {
        UsuarioModel usuarioActualizado = usuarioService.agregarMascota(id, mascota); // Llama al servicio para agregar la mascota.
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado); // Si el usuario se actualiza correctamente, devuelve el usuario actualizado.
        }
        return ResponseEntity.notFound().build(); // Si el usuario no se encuentra, devuelve un código de estado HTTP 404 (Not Found).
    }

    // Obtener todas las mascotas de un usuario
    @GetMapping("/{id}/mascotas") // Método que maneja solicitudes GET para obtener todas las mascotas de un usuario.
    public ResponseEntity<List<MascotaModel>> obtenerMascotasDeUsuario(@PathVariable String id) {
        List<MascotaModel> mascotas = usuarioService.obtenerMascotasDeUsuario(id); // Llama al servicio para obtener las mascotas del usuario.
        if (mascotas != null) {
            return ResponseEntity.ok(mascotas); // Si se encuentran las mascotas, devuelve la lista con un código de estado HTTP 200 (OK).
        }
        return ResponseEntity.notFound().build(); // Si no se encuentran mascotas, devuelve un código de estado HTTP 404 (Not Found).
    }

    // Actualizar una mascota de un usuario
    @PutMapping("/{usuarioId}/mascotas/{mascotaId}") // Método que maneja solicitudes PUT para actualizar una mascota de un usuario.
    public ResponseEntity<UsuarioModel> editarMascota(
            @PathVariable String usuarioId,
            @PathVariable String mascotaId,
            @RequestBody MascotaModel mascotaActualizada) {

        UsuarioModel usuario = usuarioService.editarMascota(usuarioId, mascotaId, mascotaActualizada); // Llama al servicio para editar la mascota.
        if (usuario != null) {
            return ResponseEntity.ok(usuario); // Si la mascota se actualiza correctamente, devuelve el usuario actualizado.
        } else {
            return ResponseEntity.notFound().build(); // Si no se encuentra la mascota o el usuario, devuelve un código de estado HTTP 404 (Not Found).
        }
    }

    // Eliminar una mascota de un usuario
    @DeleteMapping("/{id}/mascotas/{mascotaId}") // Método que maneja solicitudes DELETE para eliminar una mascota de un usuario.
    public ResponseEntity<UsuarioModel> eliminarMascota(@PathVariable String id, @PathVariable String mascotaId) {
        UsuarioModel usuarioActualizado = usuarioService.eliminarMascota(id, mascotaId); // Llama al servicio para eliminar la mascota.
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado); // Si la mascota se elimina correctamente, devuelve el usuario actualizado.
        }
        return ResponseEntity.notFound().build(); // Si no se encuentra la mascota o el usuario, devuelve un código de estado HTTP 404 (Not Found).
    }   
}
