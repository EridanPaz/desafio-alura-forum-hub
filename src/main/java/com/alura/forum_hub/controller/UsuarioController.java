package com.alura.forum_hub.controller;

import com.alura.forum_hub.domain.usuario.Usuario;
import com.alura.forum_hub.domain.usuario.UsuarioCadastro;
import com.alura.forum_hub.domain.usuario.UsuarioDetalhamento;
import com.alura.forum_hub.domain.usuario.UsuarioRepository;
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
@RequestMapping("usuario")
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
}
