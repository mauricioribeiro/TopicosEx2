package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Rota;

import java.util.Set;


public interface RotaService {

    void inicializar();

    Rota salvarNovo(String origem, String destino);

    Iterable<Rota> carregarTodos();

    Set<Rota> carregarPorOrigem(String origem);

    Set<Rota> carregarPorDestino(String destino);

    void removerPorId(Long id);

    Rota buscarPorId(Long id);

}
