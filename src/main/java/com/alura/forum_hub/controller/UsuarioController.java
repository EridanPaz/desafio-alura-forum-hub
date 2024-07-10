package com.alura.forum_hub.controller;

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

import java.util.Optional;

@RestController
@RequestMapping("usuarios")
//@SecurityRequiriment(name = "bearer-key")
public class UsuarioController {
  
  @Autowired
  private UsuarioRepository usuarioRepository;
  
  @PostMapping
  @Transactional
  public ResponseEntity cadastrar(@RequestBody @Valid UsuarioCadastro dadosUsuario, UriComponentsBuilder uiBuilder){
    var usuario = new Usuario(dadosUsuario);
    
    usuarioRepository.save(usuario);
    
    var uri = uiBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
    
    return ResponseEntity.created(uri).body(new UsuarioDetalhamento(usuario));
  }
  
  @GetMapping
  public ResponseEntity<Page<UsuarioDetalhamento>> listar(@PageableDefault(size = 5, sort = {"nome"})Pageable paginacao){
    var page = usuarioRepository.findAll(paginacao).map(UsuarioDetalhamento::new);

    return ResponseEntity.ok(page);
  }
  
  @PutMapping
  @Transactional
  public ResponseEntity atualizar(@RequestBody @Valid UsuarioAtualizacao dadosUsuario){
    var usuario = usuarioRepository.getReferenceById(dadosUsuario.id());
    
    usuario.atualizar(dadosUsuario);
    
    return ResponseEntity.ok(new UsuarioDetalhamento(usuario));
  }
  
  @GetMapping("/{id}")
  public ResponseEntity listarPorId(@PathVariable Long id){
    var usuario = usuarioRepository.getReferenceById(id);
    
    if (usuario != null) {
      return ResponseEntity.ok(new UsuarioDetalhamento(usuario));
    }
    
    return ResponseEntity.notFound().build();
  }
  
  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity excluir(@PathVariable Long id){
    var usuario = usuarioRepository.getReferenceById(id);
    
    if (usuario != null){
      usuarioRepository.deleteById(id);
      return ResponseEntity.ok().build();
    }
    
    return ResponseEntity.notFound().build();
  }
}
