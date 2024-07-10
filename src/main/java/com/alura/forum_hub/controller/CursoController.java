package com.alura.forum_hub.controller;

import com.alura.forum_hub.domain.curso.Curso;
import com.alura.forum_hub.domain.curso.CursoCadastro;
import com.alura.forum_hub.domain.curso.CursoDetalhamento;
import com.alura.forum_hub.domain.curso.CursoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(name = "curso")
//@SecurityRequiriment(name = "bearer-key")
public class CursoController {
  
  @Autowired
  private CursoRepository cursoRepository;
  
  @PostMapping
  @Transactional
  public ResponseEntity cadastrar(@RequestBody @Valid CursoCadastro dadosCurso, UriComponentsBuilder uriBuilder) {
    var curso = new Curso(dadosCurso);
    cursoRepository.save(curso);
    
    var uri = uriBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();
    return ResponseEntity.created(uri).body(new CursoDetalhamento(curso));
  }
}
