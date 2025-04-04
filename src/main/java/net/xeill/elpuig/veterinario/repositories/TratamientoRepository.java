package net.xeill.elpuig.veterinario.repositories;

import net.xeill.elpuig.veterinario.model.TratamientoModel;

import java.util.List;

// Extiende CouchbaseRepository, lo que permite acceder y manipular documentos de tipo TratamientoModel en Couchbase
import org.springframework.data.couchbase.repository.CouchbaseRepository;

// Interfaz para interactuar con la base de datos de Couchbase para los tratamientos
public interface TratamientoRepository extends CouchbaseRepository<TratamientoModel, String> {

    // Método de consulta para obtener todos los tratamientos asociados a una mascota mediante su ID
    List<TratamientoModel> findByMascotaId(String mascotaId);
}
