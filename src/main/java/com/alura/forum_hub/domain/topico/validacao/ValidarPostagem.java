package com.alura.forum_hub.domain.topico.validacao;

import com.alura.forum_hub.domain.ValidacaoException;
import com.alura.forum_hub.domain.topico.TopicoCadastro;
import com.alura.forum_hub.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPostagem implements ValidadorDePostagem {
  
  @Autowired
  private TopicoRepository topicoRepository;
  
  
  @Override
  public void validar(TopicoCadastro dadosTopico) {
    var tituloJaExiste = topicoRepository.existsByTituloAndMensagem(dadosTopico.titulo(), dadosTopico.mensagem());
    
    if(tituloJaExiste){
      throw new ValidacaoException("Já existe uma postagem com esse título e mensagem.");
    }
  }
}
