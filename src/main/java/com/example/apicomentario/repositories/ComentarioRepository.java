package com.example.apicomentario.repositories;

import com.example.apicomentario.models.Comentario;
import com.example.apicomentario.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    @Query(value = "select * from comentario order by comentario.fecha_creado DESC", nativeQuery= true)
    List<Comentario> findComentarioByComentarioFechacreado();
}
