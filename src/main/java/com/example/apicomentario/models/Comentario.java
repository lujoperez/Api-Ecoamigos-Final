package com.example.apicomentario.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comentario_id;

    @Column(name = "comentario")
    @NotNull
    private String comentarioTexto;

    @Column(name = "fecha_creado")
    @CreationTimestamp
    private LocalDateTime comentarioFechaCreado;

    @Column(name = "fecha_actualizado")
    @UpdateTimestamp
    private LocalDateTime comentarioFechaActualizado;

    @Column(name = "me_gusta")
    private Integer comentarioMeGusta;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuariosId")
    private Usuario usuario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "postsId")
    private Post post;

}