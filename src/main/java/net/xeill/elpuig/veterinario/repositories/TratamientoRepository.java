package net.xeill.elpuig.veterinario.repositories;

import net.xeill.elpuig.veterinario.model.TratamientoModel;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

public interface TratamientoRepository extends CouchbaseRepository<TratamientoModel, String> {

}
