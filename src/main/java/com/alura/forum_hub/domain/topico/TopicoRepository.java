package com.alura.forum_hub.domain.topico;

import com.alura.forum_hub.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

  void deleteById(Long id);
}
