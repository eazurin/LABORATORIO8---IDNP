package com.example.lab08.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.lab08.EdificacionCategoriaCrossRef;
import com.example.lab08.CategoriaConEdificaciones;

@Dao
public interface EdificacionCategoriaDao {
    @Insert
    void insertarCrossRef(EdificacionCategoriaCrossRef crossRef);

    @Transaction
    @Query("SELECT * FROM categorias WHERE id_categoria = :id")
    CategoriaConEdificaciones obtenerCategoriaConEdificaciones(int id);
}
