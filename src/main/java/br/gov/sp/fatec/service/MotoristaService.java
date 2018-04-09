package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.model.Motorista;

import java.util.Set;


public interface MotoristaService {
	
	void inicializar();

	Motorista salvarNovo(String nome);

	Iterable<Motorista> carregarTodos();

	Set<Motorista> carregarPorCaminhao(Caminhao caminhao);

	void adicionarCaminhao(Long caminhoId, Long caminhaoId);

	void removerPorId(Long id);

	Motorista buscarPorId(Long id);

}
