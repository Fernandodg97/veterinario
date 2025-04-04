package net.xeill.elpuig.veterinario.service;

import net.xeill.elpuig.veterinario.model.TratamientoModel;
import net.xeill.elpuig.veterinario.repositories.TratamientoRepository;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TratamientoService {

    // Se inyecta el repositorio que maneja las operaciones CRUD para los tratamientos
    private final TratamientoRepository tratamientoRepository;

    @Autowired
    public TratamientoService(TratamientoRepository tratamientoRepository) {
        this.tratamientoRepository = tratamientoRepository; // Se asigna el repositorio en el constructor
    }

    // Guardar un tratamiento
    public TratamientoModel guardarTratamiento(TratamientoModel tratamiento) {
        // Llama al repositorio para guardar el tratamiento en la base de datos
        return tratamientoRepository.save(tratamiento);
    }

    // Obtener todos los tratamientos
    public List<TratamientoModel> obtenerTodosLosTratamientos() {
        // Llama al repositorio para obtener todos los tratamientos
        return tratamientoRepository.findAll();
    }

    // Obtener tratamiento por ID
    public TratamientoModel obtenerTratamientoPorId(String id) {
        // Llama al repositorio para obtener un tratamiento por su ID
        // Si no se encuentra, devuelve null
        return tratamientoRepository.findById(id).orElse(null);
    }

    // Obtener todos los tratamientos de una mascota específica usando el ID de la mascota
    public List<TratamientoModel> obtenerTratamientosPorMascotaId(String mascotaId) {
        // Llama al repositorio para obtener todos los tratamientos asociados a la mascota con el ID proporcionado
        return tratamientoRepository.findByMascotaId(mascotaId);
    }

    // Eliminar un tratamiento por ID
    public boolean eliminarTratamientoPorId(String tratamientoId) {
        // Busca el tratamiento por ID en el repositorio
        Optional<TratamientoModel> tratamiento = tratamientoRepository.findById(tratamientoId);
        if (tratamiento.isPresent()) {
            // Si el tratamiento existe, lo elimina
            tratamientoRepository.delete(tratamiento.get());
            return true; // Retorna verdadero si se eliminó correctamente
        }
        return false; // Retorna falso si no se encontró el tratamiento
    }
}

