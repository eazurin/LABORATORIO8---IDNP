package com.example.lab08;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ForeignKey;

@Entity(
        tableName = "edificaciones",
        foreignKeys = @ForeignKey(
                entity = Categoria.class,
                parentColumns = "id_categoria",
                childColumns = "id_categoria",
                onDelete = ForeignKey.CASCADE
        )
)
public class Edificacion {
    @PrimaryKey(autoGenerate = true)
    private int id_edificacion;
    private String nombre;
    private String descripcion;
    private String imagen;
    private int id_categoria;

    // Getters y setters
    public int getId_edificacion() {
        return id_edificacion;
    }

    public void setId_edificacion(int id_edificacion) {
        this.id_edificacion = id_edificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
}

