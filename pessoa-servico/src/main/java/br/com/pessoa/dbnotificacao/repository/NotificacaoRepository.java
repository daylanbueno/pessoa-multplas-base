package br.com.pessoa.dbnotificacao.repository;

import br.com.pessoa.dbnotificacao.model.Notificacao;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

@Resource
public interface NotificacaoRepository extends JpaRepository<Notificacao, Integer> {
}
