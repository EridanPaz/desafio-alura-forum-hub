package com.alura.forum_hub.domain.topico.validacao;

import com.alura.forum_hub.domain.topico.TopicoCadastro;

public interface ValidadorDePostagem {

    void validar(TopicoCadastro dadosTopico);

}
