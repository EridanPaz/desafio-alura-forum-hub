package com.alura.forum_hub.domain.curso;

import jakarta.validation.constraints.NotNull;

public record CursoCadastro(@NotNull
                            String nome,
                            @NotNull
                            Categoria categoria
) {
}
