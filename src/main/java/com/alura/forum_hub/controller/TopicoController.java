package com.alura.forum_hub.controller;

import com.alura.forum_hub.domain.topico.*;
import com.alura.forum_hub.domain.usuario.*;
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
@RequestMapping("topicos")
public class TopicoController {
  
  @Autowired
  private TopicoPostagem postagem;
  
  @Autowired
  private TopicoAtualizarPostagem atualizarPostagem;
  
  @Autowired
  private TopicoRepository topicoRepository;
  
  @PostMapping
  @Transactional
  public ResponseEntity cadastrar(@RequestBody @Valid TopicoCadastro dadosTopico, UriComponentsBuilder uiBuilder){
    
    var topicoDTO = postagem.postar(dadosTopico);

    return ResponseEntity.ok(topicoDTO);
  }
  
  @GetMapping
  public ResponseEntity<Page<TopicoDetalhamento>> listar(@PageableDefault(size = 5, sort = {"id"})Pageable paginacao){
    var pageOfTopico = topicoRepository.findAll(paginacao).map(TopicoDetalhamento::new);
    
    return ResponseEntity.ok(pageOfTopico);
  }
  
  @GetMapping("/{id}")
  public ResponseEntity listarPorId(@PathVariable Long id){
    var topico = topicoRepository.getReferenceById(id);

    if (topico != null) {
      return ResponseEntity.ok(new TopicoDetalhamento(topico));
    }

    return ResponseEntity.notFound().build();
  }
  
  @PutMapping("/{id}")
  @Transactional
  public ResponseEntity atualizar(@RequestBody @Valid TopicoCadastro dadosTopico, UriComponentsBuilder uiBuilder){
    
    var topicoDTO = atualizarPostagem.postarAtualizacao(dadosTopico);
    
    return ResponseEntity.ok(topicoDTO);
  }
  
  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity excluir(@PathVariable Long id){
    var usuario = topicoRepository.getReferenceById(id);
    
    if (usuario != null){
      topicoRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    
    return ResponseEntity.notFound().build();
  }
}
