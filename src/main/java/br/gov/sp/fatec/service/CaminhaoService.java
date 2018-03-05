package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.model.Rota;

import java.util.List;


public interface CaminhaoService {
	
	void inicializar();

	Caminhao salvarNovo(String nome);

	Iterable<Caminhao> carregarTodos();

	List<Caminhao> carregarPorRota(Rota rota);

	void adicionarRota(Long caminhoId, Long rotaId);

}
