package net.xeill.elpuig.veterinario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.xeill.elpuig.veterinario.model.*;
import net.xeill.elpuig.veterinario.service.*;

@RestController
@CrossOrigin(origins = "http://192.168.253.131")
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public UsuarioModel crearUsuario(@RequestBody UsuarioModel usuario) {
        return usuarioService.guardarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public UsuarioModel obtenerUsuarioId(@PathVariable String id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @GetMapping("/{email}")
    public UsuarioModel obtenerUsuarioEmail(@PathVariable String email) {
        return usuarioService.obtenerUsuarioPorEmail(email);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> obtenerTodosUsuarios() {
        List<UsuarioModel> usuarios = usuarioService.obtenerUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> editarUsuario(@PathVariable String id,
            @RequestBody UsuarioModel usuarioActualizado) {
        UsuarioModel usuario = usuarioService.editarUsuarioPorId(id, usuarioActualizado);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable String id) {
        usuarioService.eliminarUsuarioPorId(id);
        return ResponseEntity.ok("Usuario eliminado con éxito.");
    }

    // Agregar una mascota a un usuario
    @PostMapping("/{id}/mascotas")
    public ResponseEntity<UsuarioModel> agregarMascota(@PathVariable String id, @RequestBody MascotaModel mascota) {
        UsuarioModel usuarioActualizado = usuarioService.agregarMascota(id, mascota);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
        }
        return ResponseEntity.notFound().build();
    }

    // Obtener todas las mascotas de un usuario
    @GetMapping("/{id}/mascotas")
    public ResponseEntity<List<MascotaModel>> obtenerMascotasDeUsuario(@PathVariable String id) {
        List<MascotaModel> mascotas = usuarioService.obtenerMascotasDeUsuario(id);
        if (mascotas != null) {
            return ResponseEntity.ok(mascotas);
        }
        return ResponseEntity.notFound().build();
    }

    // Actualiza una mascota por id
    @PutMapping("/{usuarioId}/mascotas/{mascotaId}")
    public ResponseEntity<UsuarioModel> editarMascota(
            @PathVariable String usuarioId,
            @PathVariable String mascotaId,
            @RequestBody MascotaModel mascotaActualizada) {

        UsuarioModel usuario = usuarioService.editarMascota(usuarioId, mascotaId, mascotaActualizada);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una mascota por id
    @DeleteMapping("/{id}/mascotas/{mascotaId}")
    public ResponseEntity<UsuarioModel> eliminarMascota(@PathVariable String id, @PathVariable String mascotaId) {
        UsuarioModel usuarioActualizado = usuarioService.eliminarMascota(id, mascotaId);
        if (usuarioActualizado != null) {
            return ResponseEntity.ok(usuarioActualizado);
        }
        return ResponseEntity.notFound().build();
    }

}
