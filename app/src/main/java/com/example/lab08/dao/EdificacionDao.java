package com.example.lab08.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.lab08.Edificacion;

import java.util.List;

@Dao
public interface EdificacionDao {

    @Insert
    long insertarEdificacion(Edificacion edificacion);

    @Update
    int actualizarEdificacion(Edificacion edificacion);

    @Delete
    int borrarEdificacion(Edificacion edificacion);

    @androidx.room.Query("SELECT * FROM edificaciones")
    List<Edificacion> obtenerTodasEdificaciones();

    @androidx.room.Query("SELECT * FROM edificaciones WHERE id_edificacion = :id")
    Edificacion obtenerEdificacionPorId(int id);
}

