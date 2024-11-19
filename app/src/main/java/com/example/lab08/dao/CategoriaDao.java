package com.example.lab08.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import androidx.room.Delete;

import com.example.lab08.Categoria;
import com.example.lab08.CategoriaConEdificaciones;

import java.util.List;

@Dao
public interface CategoriaDao {
    @Insert
    long insertarCategoria(Categoria categoria);

    @Update
    int actualizarCategoria(Categoria categoria);

    @Delete
    int borrarCategoria(Categoria categoria);

    @Query("SELECT * FROM categorias")
    List<Categoria> obtenerTodasCategorias();

    @Query("SELECT * FROM categorias WHERE id_categoria = :id")
    Categoria obtenerCategoriaPorId(int id);

    @Transaction
    @Query("SELECT * FROM categorias WHERE id_categoria = :id")
    CategoriaConEdificaciones obtenerCategoriaConEdificaciones(int id);
}