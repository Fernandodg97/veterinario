package net.xeill.elpuig.veterinario.model;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class TratamientoModel {

    @Id
    private String id;  // El identificador único del tratamiento en Couchbase
    private String type;
    private String mascotaId;
    private String medicamento;
    private String dosis;
    private String duracion;

    // Constructor
    public TratamientoModel() {}

    // Getters and Setters
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

    // Override toString method for easy debugging and logging
    @Override
    public String toString() {
        return "TratamientoModel{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", mascotaId='" + mascotaId + '\'' +
                ", medicamento='" + medicamento + '\'' +
                ", dosis='" + dosis + '\'' +
                ", duracion='" + duracion + '\'' +
                '}';
    }
}
