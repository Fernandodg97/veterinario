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

    @GetMapping("/{email}")
    public UsuarioModel obtenerUsuario(@PathVariable String email) {
        return usuarioService.obtenerUsuarioPorEmail(email);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> obtenerTodosUsuarios() {
        List<UsuarioModel> usuarios = usuarioService.obtenerUsuarios(); 
        return ResponseEntity.ok(usuarios);
    }

}
