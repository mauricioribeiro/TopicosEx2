package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.model.Rota;
import br.gov.sp.fatec.repository.CaminhaoRepository;
import br.gov.sp.fatec.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service("caminhaoService")
public class CaminhaoServiceImpl implements CaminhaoService {
	
	@Autowired
	private CaminhaoRepository caminhaoRepo;

	@Autowired
	private RotaRepository rotaRepo;

	public void setCaminhaoRepo(CaminhaoRepository caminhaoRepo) {
		this.caminhaoRepo = caminhaoRepo;
	}

	@Override
	@Transactional
	public void inicializar() {
		// Criar caminhoes
		Caminhao caminhao1 = new Caminhao();
		caminhao1.setNome("Caminhão 1");
        caminhao1.setRotas(rotaRepo.findAll());
		caminhaoRepo.save(caminhao1);

		Caminhao caminhao2 = new Caminhao();
		caminhao2.setNome("Caminhão 2");
		caminhaoRepo.save(caminhao2);
	}

	@Override
	@Transactional
	public Caminhao salvarNovo(String nome) {
		Caminhao caminhao = new Caminhao();
		caminhao.setNome(nome);
		return caminhaoRepo.save(caminhao);
	}

	@Override
	public Iterable<Caminhao> carregarTodos() {
		return caminhaoRepo.findAll();
	}

    @Override
    public Set<Caminhao> carregarPorRota(Rota rota) {
        return caminhaoRepo.buscaPorRota(rota.getId());
    }

	@Override
	@Transactional
	public void adicionarRota(Long caminhoId, Long rotaId) {
		Caminhao caminhao = caminhaoRepo.findOne(caminhoId);
		Rota rota = rotaRepo.findOne(rotaId);
        if(caminhao.getId() != null && rota.getId() != null){
            Set<Rota> rotas = caminhao.getRotas();
            if(!rotas.contains(rota)){
                rotas.add(rota);
                caminhao.setRotas(rotas);
                caminhaoRepo.save(caminhao);
            }
        }
	}

	@Override
	public void removerPorId(Long id) {
		caminhaoRepo.delete(id);
	}

	@Override
	public Caminhao buscarPorId(Long id) {
		return caminhaoRepo.findOne(id);
	}
}
