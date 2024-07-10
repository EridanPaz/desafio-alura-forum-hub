package com.alura.forum_hub.controller;

import com.alura.forum_hub.domain.curso.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("cursos")
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
  
  @GetMapping
  public ResponseEntity<Page<CursoDetalhamento>> listar(/*@PageableDefault(size = 50, sort = {"nome"}) */Pageable paginacao) {
    var page = cursoRepository.findAll(paginacao).map(CursoDetalhamento::new);
    return ResponseEntity.ok(page);
  }
  
  @PutMapping
  @Transactional
  public ResponseEntity atualizar(@RequestBody @Valid CursoAtualizacao dadosCurso) {
    var curso = cursoRepository.getReferenceById(dadosCurso.id());
    curso.atualizar(dadosCurso);
    
    return ResponseEntity.ok(new CursoDetalhamento(curso));
  }
  
  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity excluir(@PathVariable Long id){
    var curso = cursoRepository.getReferenceById(id);
    
    if (curso != null){
      cursoRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    
    return ResponseEntity.notFound().build();
  }
}
