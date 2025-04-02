package net.xeill.elpuig.veterinario.controller;

import net.xeill.elpuig.veterinario.model.TratamientoModel;
import net.xeill.elpuig.veterinario.service.TratamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tratamientos")
public class TratamientoController {

    private final TratamientoService tratamientoService;

    @Autowired
    public TratamientoController(TratamientoService tratamientoService) {
        this.tratamientoService = tratamientoService;
    }

    @PostMapping
    public ResponseEntity<TratamientoModel> crearTratamiento(@RequestBody TratamientoModel tratamiento) {
        TratamientoModel creado = tratamientoService.guardarTratamiento(tratamiento);
        return ResponseEntity.ok(creado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TratamientoModel> obtenerTratamiento(@PathVariable String id) {
        TratamientoModel tratamiento = tratamientoService.obtenerTratamientoPorId(id);
        return (tratamiento != null) ? ResponseEntity.ok(tratamiento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTratamiento(@PathVariable String id) {
        tratamientoService.eliminarTratamientoPorId(id);
        return ResponseEntity.ok("Tratamiento eliminado con éxito.");
    }
}
