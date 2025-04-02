package net.xeill.elpuig.veterinario.model;

import java.util.Date;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MascotaModel {
    private String id;
    private String type = "mascota";
    private String nombre;
    private String raza;
    private String genero;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    private double peso;

    // Constructor vacío
    public MascotaModel() {
        this.id = UUID.randomUUID().toString();
    }

    // Constructor con parámetros
    public MascotaModel(String nombre, String raza, String genero, Date fechaNacimiento, double peso) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.raza = raza;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
    }

    // Getters y setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getType() { return type; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public Date getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(Date fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    @Override
    public String toString() {
        return "MascotaModel{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", raza='" + raza + '\'' +
                ", genero='" + genero + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", peso=" + peso +
                '}';
    }
}
