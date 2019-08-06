package br.com.pessoa.dbpessoa.repository;

import br.com.pessoa.dbpessoa.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

    @Query(value = "SELECT m From Municipio m   WHERE  m.estado.id = :idEstado")
    public List<Municipio> recuperarMunicipios(Integer idEstado);

}
