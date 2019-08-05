package br.com.pessoa.service;

import br.com.pessoa.db.h2.model.Municipio;
import br.com.pessoa.db.h2.repository.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;

    public List<Municipio> recuperaMunicipio(Integer idEstado) {
        return municipioRepository.recuperarMunicipios(idEstado);
    }
}
