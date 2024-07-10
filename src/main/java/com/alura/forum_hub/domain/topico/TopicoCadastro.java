package com.alura.forum_hub.domain.topico;

import com.alura.forum_hub.domain.curso.Curso;
import com.alura.forum_hub.domain.usuario.Perfil;
import com.alura.forum_hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TopicoCadastro(@NotNull
                             Usuario autor,
                             @NotNull
                             LocalDate dataCriacao,
                             @NotNull
                             String titulo,
                             @NotNull
                             String mensagem,
                             @Enumerated(EnumType.STRING)
                             @NotNull
                             Status status,
                             @NotNull
                             Curso curso
) {
}
