package net.xeill.elpuig.veterinario.model;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// Define que esta clase será un documento de Couchbase
@Document
public class UsuarioModel {

    // El identificador único de cada usuario en Couchbase
    @Id
    private String id;

    // Tipo del documento (por defecto "usuario")
    private String type = "usuario";

    // Atributos del usuario
    private String nombre;        // Nombre del usuario
    private String apellido;      // Apellido del usuario
    private String email;         // Correo electrónico del usuario
    private String numero_cuenta; // Número de cuenta asociado al usuario

    // Lista de mascotas asociadas al usuario
    private List<MascotaModel> mascotas;

    // Constructor vacío que genera un ID único y una lista vacía de mascotas
    public UsuarioModel() {
        this.id = UUID.randomUUID().toString();  // Asigna un UUID único para el ID
        this.mascotas = new ArrayList<>();       // Inicializa la lista de mascotas
    }

    // Constructor con parámetros para inicializar todos los atributos
    public UsuarioModel(String id, String nombre, String apellido, String email, String numero_cuenta, List<MascotaModel> mascotas) {
        this.id = UUID.randomUUID().toString();  // Asigna un UUID único para el ID
        this.nombre = nombre;                    // Asigna el nombre del usuario
        this.apellido = apellido;                // Asigna el apellido del usuario
        this.email = email;                      // Asigna el correo electrónico del usuario
        this.numero_cuenta = numero_cuenta;      // Asigna el número de cuenta
        this.mascotas = mascotas;                // Asigna la lista de mascotas del usuario
    }

    // Getters y setters para acceder y modificar los atributos del usuario

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

    public List<MascotaModel> getMascotas() { 
        return mascotas; 
    }
    
    public void setMascotas(List<MascotaModel> mascotas) { 
        this.mascotas = mascotas; 
    }

    // Método para obtener una representación en texto del objeto (útil para depuración y logging)
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
