package br.com.pessoa.dbpessoa.repository;

import br.com.pessoa.dbpessoa.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
