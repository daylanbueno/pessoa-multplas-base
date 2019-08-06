package br.com.pessoa.service;

import br.com.pessoa.dbpessoa.repository.EstadoRepository;
import br.com.pessoa.dbpessoa.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> recuperarEstados() {
        return estadoRepository.findAll();
    }
}
