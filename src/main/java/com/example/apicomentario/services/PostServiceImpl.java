package com.example.apicomentario.services;

import com.example.apicomentario.DTO.DtoMostrar;
import com.example.apicomentario.DTO.PostDto;
import com.example.apicomentario.models.Comentario;
import com.example.apicomentario.models.Post;
import com.example.apicomentario.repositories.PostRepository;
import com.example.apicomentario.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.Like;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public Post buscarPostPorId(Long id) {
        Boolean existePost = postRepository.existsById(id);
        if (existePost) {
            Post postEscogido = postRepository.findById(id).get();
            return postEscogido;
        } else {
            System.out.println("post invalido o inexistente");
            return null;
        }
    }

    @Override
    public DtoMostrar guardarPost(PostDto postNuevo) {
        Post nuevoPost = new Post();
        DtoMostrar postParaMostrar = new DtoMostrar();
        nuevoPost.setPostTexto(postNuevo.getPostTexto());
        nuevoPost.setUsuario(usuarioRepository.findByUsuarioEmail(postNuevo.getEmail()));
        Post postGuardado = postRepository.save(nuevoPost);
        postParaMostrar.setPostFechaActualizado(postGuardado.getPostFechaActualizado());
        postParaMostrar.setPostMeGusta(postGuardado.getPostMeGusta());
        postParaMostrar.setEmail(postGuardado.getUsuario().getUsuarioEmail());
        postParaMostrar.setPostTexto(postGuardado.getPostTexto());
        postParaMostrar.setPostFechacreado(postGuardado.getPostFechacreado());
        return postParaMostrar;
    }

    @Override
    public void borrarPost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post editarPostPorId(Long id, Post postActualizado) {
        Boolean existeComentario = postRepository.existsById(id);
        if (existeComentario) {
            Post postEscogido = postRepository.findById(id).get();
            postEscogido.setPostFechacreado(postActualizado.getPostFechacreado());
            postEscogido.setPostTexto(postActualizado.getPostTexto());
            System.out.println("post actualizado");
            return postRepository.save(postEscogido);
        } else {
            System.out.println("post inexistente o invalido");
            return null;
        }
    }


    public List<Post> findPostByPostFechacreado() {
        List<Post> listaPostPorFecha = postRepository.findPostByPostFechacreado();
        return listaPostPorFecha;

    }

}