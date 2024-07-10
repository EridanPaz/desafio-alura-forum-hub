package com.alura.forum_hub.domain.curso;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "curso")
@Entity(name = "Curso")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  
  private String nome;
  @Enumerated(EnumType.STRING)
  private Categoria categoria;
  
  public Curso(CursoCadastro dadosCurso){
    this.nome     = dadosCurso.nome();
    this.categoria = dadosCurso.categoria();
  }
  
  public void atualizar(CursoAtualizacao dadosCurso) {
    if (dadosCurso.nome() != null){
      this.nome = dadosCurso.nome();
    }
    
    if (dadosCurso.categoria() != null){
      this.categoria = dadosCurso.categoria();
    }
  }
}
