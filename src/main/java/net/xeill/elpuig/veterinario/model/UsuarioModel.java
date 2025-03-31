package net.xeill.elpuig.veterinario.model;

import org.springframework.data.couchbase.core.mapping.Document;

import java.util.UUID;

import org.springframework.data.annotation.Id;

@Document
public class UsuarioModel {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private String numero_cuenta;

    // Constructor vacío (necesario para Couchbase y frameworks como Spring)
    public UsuarioModel() {
        this.id = UUID.randomUUID().toString();
    }

    // Constructor con parámetros
    public UsuarioModel(String id, String nombre, String apellido, String email, String numero_cuenta) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numero_cuenta = numero_cuenta;
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

    public String getNumeroCuenta() {
        return numero_cuenta;
    }

    public void setNumeroCuenta(String numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }

    // Método toString para depuración
    @Override
    public String toString() {
        return "UsuarioModel{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", numero_cuenta='" + numero_cuenta + '\'' +
                '}';
    }
}