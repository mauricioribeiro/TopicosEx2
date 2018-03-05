package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Rota;

import java.util.List;


public interface RotaService {

    void inicializar();

    Rota salvarNovo(String origem, String destino);

    Iterable<Rota> carregarTodos();

    List<Rota> carregarPorOrigem(String origem);

    List<Rota> carregarPorDestino(String destino);

}
