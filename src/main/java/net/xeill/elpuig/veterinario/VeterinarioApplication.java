package net.xeill.elpuig.veterinario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@SpringBootApplication
public class VeterinarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinarioApplication.class, args);
	}

}
