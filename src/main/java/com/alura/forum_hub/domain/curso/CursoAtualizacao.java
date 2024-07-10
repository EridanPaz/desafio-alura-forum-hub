package com.alura.forum_hub.domain.curso;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoAtualizacao(@NotNull
                               Long id,
                               @NotBlank
                               String nome,
                               @NotNull
                               @Enumerated(EnumType.STRING)
                               Categoria categoria) {
}
