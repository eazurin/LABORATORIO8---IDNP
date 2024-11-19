package com.example.lab08;

import androidx.room.Embedded;
import androidx.room.Relation;
import java.util.List;

public class EdificacionConComentarios {

    @Embedded
    public Edificacion edificacion;

    @Relation(
            parentColumn = "id_edificacion",
            entityColumn = "id_edificacion"
    )
    public List<Comentario> comentarios;
}