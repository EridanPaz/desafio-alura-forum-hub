package com.alura.forum_hub.domain.topico;

import com.alura.forum_hub.domain.curso.Curso;
import com.alura.forum_hub.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Topico {
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "autor_id")
  private Usuario autor;
  
  private LocalDateTime dataCriacao;
  private String titulo;
  private String mensagem;
  
  @Enumerated(EnumType.STRING)
  private Status status;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "curso_id")
  private Curso curso;
  
//  public Topico(TopicoCadastro dadosTopico){
//    this.autor       = dadosTopico;
//    this.dataCriacao = dadosTopico.dataCriacao();
//    this.titulo      = dadosTopico.titulo();
//    this.mensagem    = dadosTopico.mensagem();
//    this.status      = dadosTopico.status();
//    this.curso       = dadosTopico.curso();
//  }
  
//  public void atualizar(TopicoAtualizacao dadosTopico){
//    if (dadosTopico.autor() != null) {
//      this.autor = dadosTopico.autor();
//    }
//
//    if (dadosTopico.dataCriacao() != null) {
//      this.dataCriacao = dadosTopico.dataCriacao();
//    }
//
//    if (dadosTopico.titulo() != null) {
//      this.titulo = dadosTopico.titulo();
//    }
//
//    if (dadosTopico.mensagem() != null) {
//      this.mensagem = dadosTopico.mensagem();
//    }
//
//    if (dadosTopico.status() != null) {
//      this.status = dadosTopico.status();
//    }
//
//    if (dadosTopico.curso() != null) {
//      this.curso = dadosTopico.curso();
//    }
//  }
}
