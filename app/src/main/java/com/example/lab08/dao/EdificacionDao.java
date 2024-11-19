package com.example.lab08.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.lab08.Edificacion;
import com.example.lab08.EdificacionConCategoria;

import java.util.List;

@Dao
public interface EdificacionDao {
    @Insert
    long insertarEdificacion(Edificacion edificacion);

    @Update
    int actualizarEdificacion(Edificacion edificacion);

    @Delete
    int borrarEdificacion(Edificacion edificacion);

    @Query("SELECT * FROM edificaciones")
    List<Edificacion> obtenerTodasEdificaciones();

    @Query("SELECT * FROM edificaciones WHERE id_edificacion = :id")
    Edificacion obtenerEdificacionPorId(int id);

    @Transaction
    @Query("SELECT * FROM edificaciones WHERE id_edificacion = :id")
    EdificacionConCategoria obtenerEdificacionConCategoria(int id);
}