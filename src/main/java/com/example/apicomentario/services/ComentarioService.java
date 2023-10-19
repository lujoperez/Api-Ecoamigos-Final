package com.example.apicomentario.services;

import com.example.apicomentario.models.Comentario;

import java.util.List;

public interface ComentarioService {

    Comentario buscarComentarioPorId(Long id);
    Comentario guardarComentario(Comentario comentarioNuevo);
    void borrarComentario(Long id);
    Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado);
}
