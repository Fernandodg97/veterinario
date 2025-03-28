package net.xeill.elpuig.veterinario.repositories;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;
import net.xeill.elpuig.veterinario.model.*;

@Repository
public interface UsuarioRepository extends CouchbaseRepository<Usuario, String> {
    Usuario findByEmail(String email);
}