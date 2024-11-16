package com.example.lab08;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity(
        tableName = "comentarios",
        foreignKeys = @ForeignKey(
                entity = Edificacion.class,
                parentColumns = "id_edificacion",
                childColumns = "id_edificacion",
                onDelete = ForeignKey.CASCADE
        )
)
public class Comentario {
    @PrimaryKey(autoGenerate = true)
    private int id_comentario;
    private int id_edificacion;
    private String contenido;
    private String fecha_comentario;

    // Getters y setters
    public int getId_comentario() {
        return id_comentario;
    }

    public void setId_comentario(int id_comentario) {
        this.id_comentario = id_comentario;
    }

    public int getId_edificacion() {
        return id_edificacion;
    }

    public void setId_edificacion(int id_edificacion) {
        this.id_edificacion = id_edificacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha_comentario() {
        return fecha_comentario;
    }

    public void setFecha_comentario(String fecha_comentario) {
        this.fecha_comentario = fecha_comentario;
    }
}

