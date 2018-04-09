package br.gov.sp.fatec.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "caminhao")
public class Caminhao {

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
    
    @Column(name = "nome", unique=true, length = 50, nullable = false)
    private String nome;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "caminhao_rotas",
			joinColumns = { @JoinColumn(name = "rota_id") },
			inverseJoinColumns = { @JoinColumn(name = "caminhao_id") })
	private Set<Rota> rotas;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Motorista motorista;

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

	public Set<Rota> getRotas() {
		return rotas;
	}

	public void setRotas(Set<Rota> rotas) {
		this.rotas = rotas;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
}
