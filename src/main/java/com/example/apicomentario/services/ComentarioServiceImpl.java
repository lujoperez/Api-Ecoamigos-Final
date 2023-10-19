package com.example.apicomentario.services;

import com.example.apicomentario.models.Comentario;
import com.example.apicomentario.models.Post;
import com.example.apicomentario.repositories.ComentarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class ComentarioServiceImpl implements ComentarioService{
    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public Comentario buscarComentarioPorId(Long id){
        Boolean existeComentario = comentarioRepository.existsById(id);
        if (existeComentario){
            Comentario comentarioEscogido = comentarioRepository.findById(id).get();
            return comentarioEscogido;
        }else {
            System.out.println("comentario invalido o inexistente");
            return null;
        }
    }
    @Override
    public Comentario guardarComentario(Comentario comentarioNuevo){
        Comentario comentarioGuardado = comentarioRepository.save(comentarioNuevo);
        return comentarioGuardado;
    }

    @Override
    public void borrarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }

    @Override
    public Comentario editarComentarioPorId(Long id, Comentario comentarioActualizado) {
        Boolean existeComentario = comentarioRepository.existsById(id);
        if (existeComentario){
            Comentario comentarioEscogido = comentarioRepository.findById(id).get();
            comentarioEscogido.setComentarioTexto(comentarioActualizado.getComentarioTexto());
            comentarioEscogido.setComentarioFechaCreado(comentarioActualizado.getComentarioFechaCreado());
            System.out.println("comentario actualizado");
            return comentarioRepository.save(comentarioEscogido);
        }else {
            System.out.println("comentario inexistente o invalido");
            return null;

        }
    }

    public List<Comentario> findComentarioByComentarioFechacreado() {
        List<Comentario> listaComentarioPorFecha = comentarioRepository.findComentarioByComentarioFechacreado();
        return listaComentarioPorFecha;

    }


}
