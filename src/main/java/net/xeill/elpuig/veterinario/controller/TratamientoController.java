package net.xeill.elpuig.veterinario.controller;

import net.xeill.elpuig.veterinario.model.TratamientoModel;
import net.xeill.elpuig.veterinario.service.TratamientoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TratamientoController {

    // Se inyecta el servicio que maneja los tratamientos
    private final TratamientoService tratamientoService;

    @Autowired
    public TratamientoController(TratamientoService tratamientoService) {
        this.tratamientoService = tratamientoService; // Se asigna el servicio en el constructor
    }

    // Obtener todos los tratamientos
    @GetMapping("/tratamientos")
    public List<TratamientoModel> obtenerTodosLosTratamientos() {
        // Llama al servicio para obtener todos los tratamientos registrados
        return tratamientoService.obtenerTodosLosTratamientos();
    }

    // Obtener un tratamiento específico por su ID
    @GetMapping("/tratamientos/{id}")
    public ResponseEntity<TratamientoModel> obtenerTratamiento(@PathVariable String id) {
        // Llama al servicio para obtener un tratamiento por su ID
        TratamientoModel tratamiento = tratamientoService.obtenerTratamientoPorId(id);
        // Si se encuentra el tratamiento, devuelve una respuesta OK con el tratamiento; si no, devuelve 404 Not Found
        return (tratamiento != null) ? ResponseEntity.ok(tratamiento) : ResponseEntity.notFound().build();
    }

    // Eliminar un tratamiento de una mascota específico
    @DeleteMapping("/usuarios/{usuarioId}/mascotas/{mascotaId}/tratamientos/{tratamientoId}")
    public ResponseEntity<String> eliminarTratamientoDeMascota(@PathVariable String usuarioId,
            @PathVariable String mascotaId,
            @PathVariable String tratamientoId) {
        // Llama al servicio para eliminar el tratamiento por su ID
        boolean eliminado = tratamientoService.eliminarTratamientoPorId(tratamientoId);
        // Si el tratamiento fue eliminado con éxito, devuelve un mensaje de éxito; si no, devuelve 404 Not Found
        if (eliminado) {
            return ResponseEntity.ok("Tratamiento eliminado con éxito.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Crear un tratamiento para una mascota
    @PostMapping("/usuarios/{usuarioId}/mascotas/{mascotaId}/tratamientos")
    public ResponseEntity<TratamientoModel> crearTratamientoParaMascota(
            @PathVariable String usuarioId,
            @PathVariable String mascotaId,
            @RequestBody TratamientoModel tratamiento) {
        // Se asegura de que el tratamiento esté asociado a la mascota correcta
        tratamiento.setMascotaId(mascotaId);
        // Llama al servicio para guardar el tratamiento
        TratamientoModel creado = tratamientoService.guardarTratamiento(tratamiento);
        // Devuelve una respuesta OK con el tratamiento recién creado
        return ResponseEntity.ok(creado);
    }

    // Obtener todos los tratamientos de una mascota específica
    @GetMapping("/usuarios/{usuarioId}/mascotas/{mascotaId}/tratamientos")
    public ResponseEntity<?> obtenerTratamientosDeMascota(
            @PathVariable String usuarioId,
            @PathVariable String mascotaId) {
        // Llama al servicio para obtener los tratamientos de la mascota con el ID correspondiente
        return ResponseEntity.ok(tratamientoService.obtenerTratamientosPorMascotaId(mascotaId));
    }
}

