package com.example.lab08.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.lab08.Comentario;

import java.util.List;

@Dao
public interface ComentarioDao {

    @Insert
    long insertarComentario(Comentario comentario);

    @Update
    int actualizarComentario(Comentario comentario);

    @Delete
    int borrarComentario(Comentario comentario);

    @androidx.room.Query("SELECT * FROM comentarios")
    List<Comentario> obtenerTodosComentarios();

    @androidx.room.Query("SELECT * FROM comentarios WHERE id_comentario = :id")
    Comentario obtenerComentarioPorId(int id);

    @Query("SELECT * FROM comentarios WHERE id_edificacion = :idEdificacion")
    List<Comentario> obtenerComentariosPorEdificacion(int idEdificacion);
}
