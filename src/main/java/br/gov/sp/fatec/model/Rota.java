package br.gov.sp.fatec.model;

import javax.persistence.*;

@Entity
@Table(name = "rota")
public class Rota {

	@Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
    
    @Column(name = "origem", length = 50, nullable = false)
    private String origem;
    
    @Column(name = "destino", length = 50, nullable = false)
    private String destino;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
}
