package br.com.pessoa.dbnotificacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codigo;

    private String descricao;

    public Notificacao() {
    }

    public Notificacao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
