package com.example.lab08;

import androidx.room.Embedded;
import androidx.room.Relation;
import java.util.List;

public class CategoriaConEdificaciones {
    @Embedded
    public Categoria categoria;

    @Relation(
            parentColumn = "id_categoria",
            entityColumn = "id_categoria"
    )
    public List<Edificacion> edificaciones;
}