package trab.projetoassitenciatenicajavaspring.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//criaçao da tabela cliente
@Entity
public class Produto implements Serializable {
    // id automatico
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // atributos da tabela produto
    private String tipo;

    // constructor vazio
    public Produto() {
    }

    // get e set
    public Produto(String tipo) {
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
