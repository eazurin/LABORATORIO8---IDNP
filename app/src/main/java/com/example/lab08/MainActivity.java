package com.example.lab08;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab08.dao.CategoriaDao;
import com.example.lab08.dao.EdificacionDao;
import com.example.lab08.dao.ComentarioDao;
import com.example.lab08.dao.EdificacionCategoriaDao;
import java.util.List;

import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result_text_view);

        Executors.newSingleThreadExecutor().execute(() -> {
            AppDatabase db = AppDatabase.getDatabase(getApplicationContext());

            // Insertar datos de prueba
            insertarDatosPrueba(db);

            // Realizar consultas y mostrar resultados en el TextView
            mostrarResultados(db);
        });
    }

    private void insertarDatosPrueba(AppDatabase db) {
        CategoriaDao categoriaDao = db.categoriaDao();
        EdificacionDao edificacionDao = db.edificacionDao();
        ComentarioDao comentarioDao = db.comentarioDao();
        EdificacionCategoriaDao edificacionCategoriaDao = db.edificacionCategoriaDao();

        Categoria categoriaResidencial = new Categoria();
        categoriaResidencial.nombre_categoria = "Residencial";
        long idResidencial = categoriaDao.insertarCategoria(categoriaResidencial);

        Categoria categoriaComercial = new Categoria();
        categoriaComercial.nombre_categoria = "Comercial";
        long idComercial = categoriaDao.insertarCategoria(categoriaComercial);

        Categoria categoriaTuristica = new Categoria();
        categoriaTuristica.nombre_categoria = "Turística";
        long idTuristica = categoriaDao.insertarCategoria(categoriaTuristica);

        Edificacion casaModerna = new Edificacion();
        casaModerna.nombre = "Casa Moderna";
        casaModerna.descripcion = "Una casa con diseño moderno.";
        casaModerna.imagen = "url_imagen_moderno";
        casaModerna.id_categoria = (int) idResidencial;
        long idCasaModerna = edificacionDao.insertarEdificacion(casaModerna);

        Edificacion casaColonial = new Edificacion();
        casaColonial.nombre = "Casa Colonial";
        casaColonial.descripcion = "Una casa con arquitectura colonial.";
        casaColonial.imagen = "url_imagen_colonial";
        casaColonial.id_categoria = (int) idResidencial;
        long idCasaColonial = edificacionDao.insertarEdificacion(casaColonial);

        Edificacion edificioOficinas = new Edificacion();
        edificioOficinas.nombre = "Edificio de Oficinas";
        edificioOficinas.descripcion = "Un edificio de oficinas en el centro.";
        edificioOficinas.imagen = "url_imagen_oficinas";
        edificioOficinas.id_categoria = (int) idComercial;
        long idEdificioOficinas = edificacionDao.insertarEdificacion(edificioOficinas);

        Edificacion museoArte = new Edificacion();
        museoArte.nombre = "Museo de Arte";
        museoArte.descripcion = "Un museo con exhibiciones de arte moderno.";
        museoArte.imagen = "url_imagen_museo";
        museoArte.id_categoria = (int) idTuristica;
        long idMuseoArte = edificacionDao.insertarEdificacion(museoArte);

        Edificacion parqueCentral = new Edificacion();
        parqueCentral.nombre = "Parque Central";
        parqueCentral.descripcion = "Un parque en el centro de la ciudad.";
        parqueCentral.imagen = "url_imagen_parque";
        parqueCentral.id_categoria = (int) idTuristica;
        long idParqueCentral = edificacionDao.insertarEdificacion(parqueCentral);

        Comentario comentario1 = new Comentario();
        comentario1.id_edificacion = (int) idCasaModerna;
        comentario1.contenido = "Hermosa casa con un diseño moderno.";
        comentario1.fecha_comentario = "2024-11-19";
        comentarioDao.insertarComentario(comentario1);

        Comentario comentario2 = new Comentario();
        comentario2.id_edificacion = (int) idCasaColonial;
        comentario2.contenido = "Arquitectura colonial bien preservada.";
        comentario2.fecha_comentario = "2024-11-19";
        comentarioDao.insertarComentario(comentario2);

        Comentario comentario3 = new Comentario();
        comentario3.id_edificacion = (int) idEdificioOficinas;
        comentario3.contenido = "Gran edificio para negocios.";
        comentario3.fecha_comentario = "2024-11-19";
        comentarioDao.insertarComentario(comentario3);

        Comentario comentario4 = new Comentario();
        comentario4.id_edificacion = (int) idMuseoArte;
        comentario4.contenido = "Exhibiciones impresionantes de arte moderno.";
        comentario4.fecha_comentario = "2024-11-19";
        comentarioDao.insertarComentario(comentario4);

        Comentario comentario5 = new Comentario();
        comentario5.id_edificacion = (int) idParqueCentral;
        comentario5.contenido = "Hermoso parque para relajarse.";
        comentario5.fecha_comentario = "2024-11-19";
        comentarioDao.insertarComentario(comentario5);

        EdificacionCategoriaCrossRef crossRef1 = new EdificacionCategoriaCrossRef((int) idCasaModerna, (int) idComercial);
        edificacionCategoriaDao.insertarCrossRef(crossRef1);

        EdificacionCategoriaCrossRef crossRef2 = new EdificacionCategoriaCrossRef((int) idMuseoArte, (int) idResidencial);
        edificacionCategoriaDao.insertarCrossRef(crossRef2);
    }

    private void mostrarResultados(AppDatabase db) {
        CategoriaDao categoriaDao = db.categoriaDao();
        EdificacionDao edificacionDao = db.edificacionDao();
        ComentarioDao comentarioDao = db.comentarioDao();

        StringBuilder resultados = new StringBuilder();

        resultados.append("Consulta Uno a Uno:\n");
        EdificacionConCategoria edificacionConCategoria = edificacionDao.obtenerEdificacionConCategoria(1); // ID 1: Casa Moderna
        if (edificacionConCategoria != null) {
            resultados.append("Edificación: ").append(edificacionConCategoria.edificacion.nombre).append("\n")
                    .append("Categoría: ").append(edificacionConCategoria.categoria.nombre_categoria).append("\n\n");
        }

        resultados.append("Consulta Uno a Muchos:\n");
        CategoriaConEdificaciones categoriaConEdificaciones = categoriaDao.obtenerCategoriaConEdificaciones(1); // ID 1: Residencial
        if (categoriaConEdificaciones != null) {
            resultados.append("Categoría: ").append(categoriaConEdificaciones.categoria.nombre_categoria).append("\n")
                    .append("Edificaciones:\n");
            for (Edificacion edificacion : categoriaConEdificaciones.edificaciones) {
                resultados.append(" - ").append(edificacion.nombre).append("\n");
            }
            resultados.append("\n");
        }

        resultados.append("Consulta Muchos a Muchos:\n");
        CategoriaConEdificaciones categoriaRelacionada = db.edificacionCategoriaDao().obtenerCategoriaConEdificaciones(1); // ID 1: Residencial
        if (categoriaRelacionada != null) {
            resultados.append("Categoría: ").append(categoriaRelacionada.categoria.nombre_categoria).append("\n")
                    .append("Edificaciones relacionadas:\n");
            for (Edificacion edificacion : categoriaRelacionada.edificaciones) {
                resultados.append(" - ").append(edificacion.nombre).append("\n");
            }
            resultados.append("\n");
        }

        resultados.append("Comentarios por Edificación:\n");
        List<Comentario> comentarios = comentarioDao.obtenerComentariosPorEdificacion(1); // ID 1: Casa Moderna
        if (comentarios != null && !comentarios.isEmpty()) {
            resultados.append("Edificación: Casa Moderna\n");
            for (Comentario comentario : comentarios) {
                resultados.append(" - ").append(comentario.contenido).append(" (Fecha: ").append(comentario.fecha_comentario).append(")\n");
            }
        }

        comentarios = comentarioDao.obtenerComentariosPorEdificacion(3); // ID 3: Edificio de Oficinas
        if (comentarios != null && !comentarios.isEmpty()) {
            resultados.append("\nEdificación: Edificio de Oficinas\n");
            for (Comentario comentario : comentarios) {
                resultados.append(" - ").append(comentario.contenido).append(" (Fecha: ").append(comentario.fecha_comentario).append(")\n");
            }
        }

        runOnUiThread(() -> resultTextView.setText(resultados.toString()));
    }
}
