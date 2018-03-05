package br.gov.sp.fatec.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CAMINHAO")
public class Caminhao {

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID")
	private Long id;
    
    @Column(name = "NOME", unique=true, length = 50, nullable = false)
    private String nome;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "CAMINHAO_ROTAS",
			joinColumns = { @JoinColumn(name = "ROTA_ID") },
			inverseJoinColumns = { @JoinColumn(name = "CAMINHAO_ID") })
	private List<Rota> rotas = new ArrayList<Rota>();

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

	public List<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(List<Rota> rotas) {
		this.rotas = rotas;
	}
}
