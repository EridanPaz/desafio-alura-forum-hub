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
//@SecurityRequiriment(name = "bearer-key")
public class TopicoController {
  
  @Autowired
  private TopicoPostagem postagem;
  
  @PostMapping
  @Transactional
  public ResponseEntity cadastrar(@RequestBody @Valid TopicoCadastro dadosTopico, UriComponentsBuilder uiBuilder){
    System.out.println("AQUI ESTÃO OS DADOS: " + dadosTopico);
    
    var topicoDTO = postagem.postar(dadosTopico);

    return ResponseEntity.ok(topicoDTO);
  }
  
}
