package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.model.Motorista;

import java.util.List;


public interface MotoristaService {
	
	void inicializar();

	Motorista salvarNovo(String nome);

	Iterable<Motorista> carregarTodos();

	List<Motorista> carregarPorCaminhao(Caminhao caminhao);

	void adicionarCaminhao(Long caminhoId, Long caminhaoId);

}