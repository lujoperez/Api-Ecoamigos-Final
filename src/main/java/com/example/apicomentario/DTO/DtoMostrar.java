package com.example.apicomentario.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoMostrar {
    private String postTexto;

    private LocalDateTime PostFechacreado;
    private LocalDateTime postFechaActualizado;
    private Integer postMeGusta;
    private String email;
}
