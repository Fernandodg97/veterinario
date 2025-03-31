package net.xeill.elpuig.veterinario.model;

import org.springframework.data.couchbase.core.mapping.Document;

import java.util.UUID;

import org.springframework.data.annotation.Id;

@Document
public class Usuario {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String email;

    

    // Constructor vacío (necesario para Couchbase y frameworks como Spring)
    public Usuario() {
        this.id = UUID.randomUUID().toString();
    }

    // Constructor con parámetros
    public Usuario(String id, String nombre, String apellido, String email) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}