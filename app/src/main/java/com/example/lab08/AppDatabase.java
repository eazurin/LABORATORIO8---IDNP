package com.example.lab08;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

import com.example.lab08.dao.CategoriaDao;
import com.example.lab08.dao.EdificacionDao;
import com.example.lab08.dao.ComentarioDao;
import com.example.lab08.dao.EdificacionCategoriaDao;

@Database(entities = {
        Categoria.class,
        Edificacion.class,
        Comentario.class,
        EdificacionCategoriaCrossRef.class
}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract CategoriaDao categoriaDao();
    public abstract EdificacionDao edificacionDao();
    public abstract ComentarioDao comentarioDao();
    public abstract EdificacionCategoriaDao edificacionCategoriaDao();

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "app_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}