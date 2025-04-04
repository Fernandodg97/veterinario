package net.xeill.elpuig.veterinario.repositories;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;
import net.xeill.elpuig.veterinario.model.*;

// Anotación que marca esta interfaz como un componente de repositorio para que Spring la detecte
@Repository
public interface UsuarioRepository extends CouchbaseRepository<UsuarioModel, String> {

    // Método para encontrar un usuario por su correo electrónico (email)
    UsuarioModel findByEmail(String email);
}
