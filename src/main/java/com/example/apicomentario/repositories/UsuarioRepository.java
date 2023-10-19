package com.example.apicomentario.repositories;

import com.example.apicomentario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "select * from post", nativeQuery = true)
    String findPostByEmailQS(String usuarioEmail);
    public Usuario findByUsuarioEmail (String email);

}
