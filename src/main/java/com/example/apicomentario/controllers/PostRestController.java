package com.example.apicomentario.controllers;

import com.example.apicomentario.DTO.DtoMostrar;
import com.example.apicomentario.DTO.PostDto;
import com.example.apicomentario.models.Post;
import com.example.apicomentario.repositories.PostRepository;
import com.example.apicomentario.services.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")

@RestController
@RequestMapping("/post")
public class PostRestController {

    @Autowired
    PostServiceImpl postService;

    @Autowired
    PostRepository postRepository;


    @GetMapping("/lista")
    public List<Post> listaPostPorFecha() {
        List<Post> mostrarListaPostPorFecha = postService.findPostByPostFechacreado();
        return mostrarListaPostPorFecha;
    }

    @PostMapping("/guardar")
    public DtoMostrar guardarPost(@RequestBody PostDto nuevoPost) {
        DtoMostrar postGuardar = postService.guardarPost(nuevoPost);
        return postGuardar;
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarPostPorId(@PathVariable Long id){
        postService.borrarPost(id);
        return "El post ha sido borrado";
    }

    @PutMapping("/editar/{id}")
    public Post editarPostPorId(@PathVariable Long id, @RequestBody Post postActualizado){
        Post postEditado = postService.editarPostPorId(id, postActualizado);
        return postEditado;

    }

    @GetMapping("/buscar/{id}")
    public Post postPorId(@PathVariable Long id){
        Post postMostrar = postService.buscarPostPorId(id);
        return postMostrar;
    }

    @PostMapping("/like/{id}")
    public Post meGustaPost(@PathVariable Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setPostMeGusta(post.getPostMeGusta() + 1);
            postRepository.save(post);

        }
        return post;
    }

    @PostMapping("/dislike/{id}")
        public Post noMeGustaPost(@PathVariable Long id) {
            Post post = postRepository.findById(id).orElse(null);
            if (post != null && post.getPostMeGusta() > 0) {
                post.setPostMeGusta(post.getPostMeGusta() - 1);
                postRepository.save(post);
            }
            return post;
        }

}
