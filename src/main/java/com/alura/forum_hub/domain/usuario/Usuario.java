package com.alura.forum_hub.domain.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuario")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  @Enumerated(EnumType.STRING)
  private Perfil perfil;
  
  public Usuario(UsuarioCadastro usuarioCadastro){
    this.nome   = usuarioCadastro.nome();
    this.email  = usuarioCadastro.email();
    this.perfil = usuarioCadastro.perfil();
  }
  
  public void atualizar(UsuarioAtualizacao dadosUsuario){
    if (dadosUsuario.nome() != null){
      this.nome = dadosUsuario.nome();
    }
    
    if (dadosUsuario.email() != null){
      this.email = dadosUsuario.email();
    }
    
    if (dadosUsuario.perfil() != null){
      this.perfil = dadosUsuario.perfil();
    }
  }
}
