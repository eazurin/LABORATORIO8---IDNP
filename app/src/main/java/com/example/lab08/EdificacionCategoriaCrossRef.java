package com.example.lab08;

import androidx.room.Entity;

@Entity(tableName = "edificacion_categoria_cross_ref")
public class EdificacionCategoriaCrossRef {
    public int edificacionId;
    public int categoriaId;

    // Constructor
    public EdificacionCategoriaCrossRef(int edificacionId, int categoriaId) {
        this.edificacionId = edificacionId;
        this.categoriaId = categoriaId;
    }

    // Getters y Setters
    public int getEdificacionId() {
        return edificacionId;
    }

    public void setEdificacionId(int edificacionId) {
        this.edificacionId = edificacionId;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }
}


