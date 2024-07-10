package com.alura.forum_hub.domain.topico;

import com.alura.forum_hub.domain.curso.Curso;
import com.alura.forum_hub.domain.usuario.Usuario;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record TopicoAtualizacao(@NotNull
                                Long id,
                                @NotNull
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
