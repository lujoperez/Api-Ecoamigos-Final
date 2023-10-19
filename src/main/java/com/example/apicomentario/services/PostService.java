package com.example.apicomentario.services;

import com.example.apicomentario.DTO.DtoMostrar;
import com.example.apicomentario.DTO.PostDto;
import com.example.apicomentario.models.Comentario;
import com.example.apicomentario.models.Post;

import java.util.List;

public interface PostService {

    Post buscarPostPorId(Long id);
    DtoMostrar guardarPost(PostDto postNuevo);
    void borrarPost(Long id);
    Post editarPostPorId(Long id, Post postActualizado);
    //Post meGustaPost(Long id, Post postMeGustaActualizado);

}
