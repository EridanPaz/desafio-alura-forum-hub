package com.alura.forum_hub.domain.curso;

public record CursoDetalhamento(Long id,
                                String nome,
                                Categoria categoria
                                ) {
  public CursoDetalhamento(Curso curso){
    this(curso.getId(),
        curso.getNome(),
        curso.getCategoria());
  }
}
