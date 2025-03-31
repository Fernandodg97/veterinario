package net.xeill.elpuig.veterinario.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.mapping.CouchbaseMappingContext;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = "net.xeill.elpuig.veterinario.repositories")
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://localhost";
    }

    @Override
    public String getUserName() {
        return "usuario";
    }

    @Override
    public String getPassword() {
        return "usuario";
    }

    @Override
    public String getBucketName() {
        return "veterinario";
    }

    @Bean
    public CouchbaseTemplate couchbaseTemplate() throws Exception {
        return new CouchbaseTemplate(couchbaseClientFactory(null), mappingCouchbaseConverter(null, null), couchbaseTranslationService());
    }

    @Bean
    public CouchbaseMappingContext couchbaseMappingContext() {
        return new CouchbaseMappingContext();
    }
}
