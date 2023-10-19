package com.example.apicomentario.repositories;

import com.example.apicomentario.models.Post;
import com.example.apicomentario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    @Query(value = "select * from post order by post.fecha_creado DESC", nativeQuery= true)
    List<Post> findPostByPostFechacreado();


}
