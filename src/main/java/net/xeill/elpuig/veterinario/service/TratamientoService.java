package net.xeill.elpuig.veterinario.service;

import net.xeill.elpuig.veterinario.model.TratamientoModel;
import net.xeill.elpuig.veterinario.repositories.TratamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TratamientoService {

    private final TratamientoRepository tratamientoRepository;

    @Autowired
    public TratamientoService(TratamientoRepository tratamientoRepository) {
        this.tratamientoRepository = tratamientoRepository;
    }

    // Guardar un tratamiento
    public TratamientoModel guardarTratamiento(TratamientoModel tratamiento) {
        return tratamientoRepository.save(tratamiento);
    }

    // Obtener tratamiento por ID
    public TratamientoModel obtenerTratamientoPorId(String id) {
        return tratamientoRepository.findById(id).orElse(null);
    }

    // Eliminar tratamiento por ID
    public void eliminarTratamientoPorId(String id) {
        tratamientoRepository.deleteById(id);
    }
}
