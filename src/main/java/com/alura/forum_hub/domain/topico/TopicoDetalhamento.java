package com.alura.forum_hub.domain.topico;

import com.alura.forum_hub.domain.curso.Curso;
import com.alura.forum_hub.domain.usuario.Usuario;

import java.time.LocalDate;

public record TopicoDetalhamento(long id,
                                 Usuario autor,
                                 LocalDate dataCriacao,
                                 String titulo,
                                 String mensagem,
                                 Status status,
                                 Curso curso) {
  public TopicoDetalhamento(Topico topico){
    this(topico.getId(),
         topico.getAutor(),
         topico.getDataCriacao(),
         topico.getTitulo(),
         topico.getMensagem(),
         topico.getStatus(),
         topico.getCurso());
  }
}
