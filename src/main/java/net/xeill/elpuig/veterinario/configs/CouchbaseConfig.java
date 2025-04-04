package net.xeill.elpuig.veterinario.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.mapping.CouchbaseMappingContext;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration // Anotación para indicar que esta clase es una clase de configuración de Spring.
@EnableCouchbaseRepositories(basePackages = "net.xeill.elpuig.veterinario.repositories") // Habilita la búsqueda de repositorios Couchbase en el paquete especificado.
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    // Método para obtener la cadena de conexión de Couchbase
    @Override
    public String getConnectionString() {
        return "couchbase://localhost"; // Dirección del servidor de Couchbase, en este caso, localhost.
    }

    // Método para obtener el nombre de usuario para la conexión a Couchbase
    @Override
    public String getUserName() {
        return "usuario"; // Nombre de usuario para la autenticación en Couchbase.
    }

    // Método para obtener la contraseña para la conexión a Couchbase
    @Override
    public String getPassword() {
        return "usuario"; // Contraseña para la autenticación en Couchbase.
    }

    // Método para obtener el nombre del bucket en Couchbase
    @Override
    public String getBucketName() {
        return "veterinario"; // Nombre del bucket (base de datos) que se va a usar en Couchbase.
    }

    // Definición del bean de CouchbaseTemplate
    @Bean
    public CouchbaseTemplate couchbaseTemplate() throws Exception {
        // Crea un objeto CouchbaseTemplate utilizando las configuraciones de conexión y conversión definidas en esta clase.
        return new CouchbaseTemplate(couchbaseClientFactory(null), mappingCouchbaseConverter(null, null), couchbaseTranslationService());
    }

    // Definición del bean de CouchbaseMappingContext
    @Bean
    public CouchbaseMappingContext couchbaseMappingContext() {
        // Crea y devuelve un nuevo contexto de mapeo de Couchbase.
        return new CouchbaseMappingContext();
    }
}
