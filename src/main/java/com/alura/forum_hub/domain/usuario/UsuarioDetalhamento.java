package com.alura.forum_hub.domain.usuario;

public record UsuarioDetalhamento(Long id,
                                  String nome,
                                  String email
                                  ) {
  public UsuarioDetalhamento(Usuario usuario){
    this(usuario.getId(),
         usuario.getNome(),
         usuario.getEmail());
  }
}
