package net.xeill.elpuig.veterinario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Esta anotación indica que esta clase es una clase de configuración principal para una aplicación Spring Boot.
public class VeterinarioApplication {

    public static void main(String[] args) {
        // SpringApplication.run se encarga de iniciar la aplicación Spring Boot. 
        // Lanza el contexto de la aplicación y arranca el servidor de aplicaciones embebido (por defecto Tomcat).
        SpringApplication.run(VeterinarioApplication.class, args);
    }
}
