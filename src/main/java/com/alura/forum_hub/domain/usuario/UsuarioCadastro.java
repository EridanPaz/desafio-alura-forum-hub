package com.alura.forum_hub.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioCadastro(@NotBlank
                              String nome,
                              @NotBlank
                              @Email
                              String email,
                              @NotNull
                              Perfil perfil) {
}