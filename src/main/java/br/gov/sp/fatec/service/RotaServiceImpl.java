package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Rota;
import br.gov.sp.fatec.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("rotaService")
public class RotaServiceImpl implements RotaService {

    @Autowired
    private RotaRepository rotaRepo;

    @Override
    @Transactional
    public void inicializar() {
        // Criar rotas
        Rota rota1 = new Rota();
        rota1.setOrigem("São José dos Campos");
        rota1.setDestino("São Paulo");
        rotaRepo.save(rota1);

        Rota rota2 = new Rota();
        rota2.setOrigem("Jacareí");
        rota2.setDestino("Taubaté");
        rotaRepo.save(rota2);
    }

    @Override
    @Transactional
    public Rota salvarNovo(String origem, String destino) {
        Rota rota = new Rota();
        rota.setOrigem(origem);
        rota.setDestino(destino);
        return rotaRepo.save(rota);
    }

    @Override
    public Iterable<Rota> carregarTodos() {
        return rotaRepo.findAll();
    }

    @Override
    public List<Rota> carregarPorOrigem(String origem) {
        return rotaRepo.buscaOrigem(origem);
    }

    @Override
    public List<Rota> carregarPorDestino(String destino) {
        return rotaRepo.buscaDestino(destino);
    }
}
