package com.alura.forum_hub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record TopicoCadastro(Long id,
                             @NotNull
                             Long autor,
                             
                             @NotNull
                             @Future
                             LocalDateTime dataCriacao,
                             
                             @NotNull
                             String titulo,
                             
                             @NotNull
                             String mensagem,
                             
                             @Enumerated(EnumType.STRING)
                             @NotNull
                             Status status,
                             
                             @NotNull
                             Long curso
) {
}
