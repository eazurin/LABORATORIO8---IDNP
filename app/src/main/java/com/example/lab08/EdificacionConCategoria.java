package com.example.lab08;

import androidx.room.Embedded;
import androidx.room.Relation;

public class EdificacionConCategoria {

    @Embedded
    public Edificacion edificacion;

    @Relation(
            parentColumn = "id_categoria",
            entityColumn = "id_categoria"
    )
    public Categoria categoria;
}
