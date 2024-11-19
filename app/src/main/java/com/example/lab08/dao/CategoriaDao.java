package com.example.lab08.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import com.example.lab08.Categoria;

import java.util.List;

@Dao
public interface CategoriaDao {

    @Insert
    long insertarCategoria(Categoria categoria);

    @Update
    int actualizarCategoria(Categoria categoria);

    @Delete
    int borrarCategoria(Categoria categoria);

    @androidx.room.Query("SELECT * FROM categorias")
    List<Categoria> obtenerTodasCategorias();

    @androidx.room.Query("SELECT * FROM categorias WHERE id_categoria = :id")
    Categoria obtenerCategoriaPorId(int id);
}

