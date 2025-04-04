package net.xeill.elpuig.veterinario.model;

import java.util.Date;
import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonFormat;

// Representa una mascota en el sistema
public class MascotaModel {
    
    // Identificador único de la mascota
    private String id;

    // Tipo de documento (por defecto "mascota")
    private String type = "mascota";

    // Atributos de la mascota
    private String nombre;        // Nombre de la mascota
    private String raza;          // Raza de la mascota
    private String genero;        // Género de la mascota

    // Fecha de nacimiento de la mascota, con formato específico para su serialización
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date fechaNacimiento;

    // Peso de la mascota
    private double peso;

    // Constructor vacío: genera un UUID único para el id de la mascota
    public MascotaModel() {
        this.id = UUID.randomUUID().toString(); // Genera un identificador único para la mascota
    }

    // Constructor con parámetros: inicializa todos los atributos de la mascota
    public MascotaModel(String nombre, String raza, String genero, Date fechaNacimiento, double peso) {
        this.id = UUID.randomUUID().toString();  // Genera un identificador único para la mascota
        this.nombre = nombre;                    // Inicializa el nombre de la mascota
        this.raza = raza;                        // Inicializa la raza de la mascota
        this.genero = genero;                    // Inicializa el género de la mascota
        this.fechaNacimiento = fechaNacimiento;  // Inicializa la fecha de nacimiento
        this.peso = peso;                        // Inicializa el peso de la mascota
    }

    // Métodos getters y setters para acceder y modificar los atributos de la mascota

    public String getId() { 
        return id; 
    }

    public void setId(String id) { 
        this.id = id; 
    }

    public String getType() { 
        return type; 
    }

    public String getNombre() { 
        return nombre; 
    }

    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }

    public String getRaza() { 
        return raza; 
    }

    public void setRaza(String raza) { 
        this.raza = raza; 
    }

    public String getGenero() { 
        return genero; 
    }

    public void setGenero(String genero) { 
        this.genero = genero; 
    }

    public Date getFechaNacimiento() { 
        return fechaNacimiento; 
    }

    public void setFechaNacimiento(Date fechaNacimiento) { 
        this.fechaNacimiento = fechaNacimiento; 
    }

    public double getPeso() { 
        return peso; 
    }

    public void setPeso(double peso) { 
        this.peso = peso; 
    }

    // Método para obtener una representación en texto del objeto, útil para depuración y logging
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
