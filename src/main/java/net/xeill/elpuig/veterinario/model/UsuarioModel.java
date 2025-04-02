package net.xeill.elpuig.veterinario.model;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Document
public class UsuarioModel {
    @Id
    private String id;
    private String type = "usuario";
    private String nombre;
    private String apellido;
    private String email;
    private String numero_cuenta;
    private List<MascotaModel> mascotas;

    // Constructor vacío
    public UsuarioModel() {
        this.id = UUID.randomUUID().toString();
        this.mascotas = new ArrayList<>();
    }

    // Constructor con parámetros
    public UsuarioModel(String id, String nombre, String apellido, String email, String numero_cuenta, List<MascotaModel> mascotas) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numero_cuenta = numero_cuenta;
        this.mascotas = mascotas;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return type; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getNumeroCuenta() { return numero_cuenta; }
    public void setNumeroCuenta(String numero_cuenta) { this.numero_cuenta = numero_cuenta; }

    public List<MascotaModel> getMascotas() { return mascotas; }
    public void setMascotas(List<MascotaModel> mascotas) { this.mascotas = mascotas; }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", numero_cuenta='" + numero_cuenta + '\'' +
                ", mascotas=" + mascotas +
                '}';
    }
}
