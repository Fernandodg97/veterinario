package net.xeill.elpuig.veterinario.model;

import org.springframework.data.couchbase.core.mapping.Document;
import java.util.UUID;
import org.springframework.data.annotation.Id;

// Marca esta clase como un documento de Couchbase (documento de base de datos)
@Document
public class TratamientoModel {

    // El identificador único del tratamiento en la base de datos (usado por Couchbase)
    @Id
    private String id;

    // Tipo de objeto, usado para diferenciación en Couchbase
    private String type = "tratamiento";

    // El ID de la mascota a la que se le asigna este tratamiento
    private String mascotaId;

    // El nombre del medicamento que se está usando en el tratamiento
    private String medicamento;

    // La dosis del medicamento que se administra
    private String dosis;

    // La duración del tratamiento, por ejemplo, en días o semanas
    private String duracion;

    // Constructor vacío (sin parámetros), genera un ID aleatorio para el tratamiento
    public TratamientoModel() {
        this.id = UUID.randomUUID().toString();  // Asigna un UUID aleatorio al ID
    }

    // Constructor con parámetros, para crear el tratamiento con valores definidos
    public TratamientoModel(String id, String mascotaId, String medicamento, String dosis, String duracion) {
        this.id = UUID.randomUUID().toString();  // Genera un nuevo UUID para cada tratamiento
        this.mascotaId = mascotaId;
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.duracion = duracion;
    }

    // Getters y Setters para acceder y modificar los atributos del tratamiento
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMascotaId() {
        return mascotaId;
    }

    public void setMascotaId(String mascotaId) {
        this.mascotaId = mascotaId;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    // Método toString() para convertir el objeto en una cadena de texto (útil para depuración y registros)
    @Override
    public String toString() {
        return "TratamientoModel{" +
                "id='" + id + '\'' +  // Muestra el ID del tratamiento
                ", type='" + type + '\'' +  // Muestra el tipo de tratamiento (usualmente 'tratamiento')
                ", mascotaId='" + mascotaId + '\'' +  // Muestra el ID de la mascota
                ", medicamento='" + medicamento + '\'' +  // Muestra el nombre del medicamento
                ", dosis='" + dosis + '\'' +  // Muestra la dosis del medicamento
                ", duracion='" + duracion + '\'' +  // Muestra la duración del tratamiento
                '}';
    }
}
