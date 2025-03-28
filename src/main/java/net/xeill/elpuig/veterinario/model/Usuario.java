package net.xeill.elpuig.veterinario.model;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String email;

    // Getters y setters
}