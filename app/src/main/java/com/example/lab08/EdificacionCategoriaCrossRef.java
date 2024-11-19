package com.example.lab08;

import androidx.room.Entity;

@Entity(primaryKeys = {"id_edificacion", "id_categoria"})
public class EdificacionCategoriaCrossRef {

    public int id_edificacion;
    public int id_categoria;

    public EdificacionCategoriaCrossRef() {}

    public EdificacionCategoriaCrossRef(int id_edificacion, int id_categoria) {
        this.id_edificacion = id_edificacion;
        this.id_categoria = id_categoria;
    }
}
