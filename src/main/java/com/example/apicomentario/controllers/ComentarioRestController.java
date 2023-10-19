package com.example.apicomentario.controllers;

import com.example.apicomentario.models.Comentario;
import com.example.apicomentario.models.Post;
import com.example.apicomentario.repositories.ComentarioRepository;
import com.example.apicomentario.repositories.PostRepository;
import com.example.apicomentario.services.ComentarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/comentario")
public class ComentarioRestController {

    @Autowired
    ComentarioServiceImpl comentarioService;

    @Autowired
    ComentarioRepository comentarioRepository;

    @GetMapping("/lista")
    public List<Comentario> listaComentarioPorFecha() {
        List<Comentario> mostrarListaComentarioPorFecha = comentarioService.findComentarioByComentarioFechacreado();
        return mostrarListaComentarioPorFecha;
    }

    @PostMapping("/guardar")
    public Comentario guardarcomentario(@RequestBody Comentario nuevoComentario) {
        Comentario comentarioGuardar = comentarioService.guardarComentario(nuevoComentario);
        return comentarioGuardar;
    }

    @DeleteMapping("/borrar/{id}")
    public String borrarComentarioPorId(@PathVariable Long id){
        comentarioService.borrarComentario(id);
        return "El comentario ha sido borrado";
    }

    @PutMapping("/editar/{id}")
    public Comentario editarComentarioPorId(@PathVariable Long id, @RequestBody Comentario comentarioActualizado){
        Comentario comentarioEditado = comentarioService.editarComentarioPorId(id, comentarioActualizado);
        return comentarioEditado;
    }

    @GetMapping("/buscar/{id}")
    public Comentario comentarioPorId(@PathVariable Long id){
        Comentario comentarioMostrar = comentarioService.buscarComentarioPorId(id);
        return comentarioMostrar;
    }

    @PostMapping("/like/{id}")
    public Comentario meGustaComentario(@PathVariable Long id) {
        Comentario comentario = comentarioRepository.findById(id).orElse(null);
        if (comentario != null) {
            comentario.setComentarioMeGusta(comentario.getComentarioMeGusta() + 1);
            comentarioRepository.save(comentario);

        }
        return comentario;
    }

    @PostMapping("/dislike/{id}")
    public Comentario noMeGustaComentario(@PathVariable Long id) {
        Comentario comentario = comentarioRepository.findById(id).orElse(null);
        if (comentario != null && comentario.getComentarioMeGusta() > 0) {
            comentario.setComentarioMeGusta(comentario.getComentarioMeGusta() - 1);
            comentarioRepository.save(comentario);
        }
        return comentario;
    }



}
