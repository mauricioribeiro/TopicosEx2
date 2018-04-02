package br.gov.sp.fatec.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "motorista")
public class Motorista {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "motorista")
    private Set<Caminhao> caminhoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Caminhao> getCaminhoes() {
        return caminhoes;
    }

    public void setCaminhoes(Set<Caminhao> caminhoes) {
        this.caminhoes = caminhoes;
    }
}
