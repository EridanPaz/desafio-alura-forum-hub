package com.alura.forum_hub.domain.topico;

import com.alura.forum_hub.domain.ValidacaoException;
import com.alura.forum_hub.domain.curso.CursoRepository;
import com.alura.forum_hub.domain.topico.validacao.ValidadorDePostagem;
import com.alura.forum_hub.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicoPostagem {
  
  @Autowired
  private UsuarioRepository usuarioRepository;
  
  @Autowired
  private CursoRepository cursoRepository;
  
  @Autowired
  private TopicoRepository topicoRepository;
  
  @Autowired
  private List<ValidadorDePostagem> validarPostagens;
  
  public TopicoDetalhamento postar(TopicoCadastro dadosTopico){
    
    if (!usuarioRepository.existsById(dadosTopico.autor())){
      throw new ValidacaoException("ID do autor da postagem é obrigatório.");
    }
    
    if (!cursoRepository.existsById(dadosTopico.curso())){
      throw new ValidacaoException("ID do curso referente à postagem é obrigatório.");
    }
    
    validarPostagens.forEach(v -> v.validar(dadosTopico));;
    
    var autor = usuarioRepository.getReferenceById(dadosTopico.autor());
    var curso = cursoRepository.getReferenceById(dadosTopico.curso());
    
    var topico = new Topico(null,
                            autor,
                            dadosTopico.dataCriacao(),
                            dadosTopico.titulo(),
                            dadosTopico.mensagem(),
                            dadosTopico.status(),
                            curso);
    
    topicoRepository.save(topico);
    
    return new TopicoDetalhamento(topico);
  }
}
