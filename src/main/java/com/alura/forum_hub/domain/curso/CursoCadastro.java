package com.alura.forum_hub.domain.curso;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record CursoCadastro(@NotNull
                            String nome,
                            @NotNull
                            @Enumerated(EnumType.STRING)
                            Categoria categoria
) {
}
