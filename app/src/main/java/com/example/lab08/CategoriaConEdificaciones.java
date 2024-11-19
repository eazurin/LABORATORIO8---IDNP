package com.example.lab08;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;
import java.util.List;

public class CategoriaConEdificaciones {
    @Embedded
    public Categoria categoria;

    @Relation(
            parentColumn = "id_categoria",
            entityColumn = "id_edificacion",
            associateBy = @Junction(EdificacionCategoriaCrossRef.class)
    )
    public List<Edificacion> edificaciones;
}


