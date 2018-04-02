package br.gov.sp.fatec.service;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.model.Motorista;
import br.gov.sp.fatec.repository.CaminhaoRepository;
import br.gov.sp.fatec.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service("motoristaService")
public class MotoristaServiceImpl implements MotoristaService {
	
	@Autowired
	private MotoristaRepository motoristaRepo;

	@Autowired
	private CaminhaoRepository caminhaoRepo;

	public void setMotoristaRepo(MotoristaRepository motoristaRepo) {
		this.motoristaRepo = motoristaRepo;
	}

	@Override
	@Transactional
	public void inicializar() {
		// Criar motorista
		Motorista mauricio = new Motorista();
		mauricio.setNome("Mauricio");
        mauricio.setCaminhoes((Set<Caminhao>) caminhaoRepo.findAll());
		motoristaRepo.save(mauricio);

		Motorista jullyana = new Motorista();
		jullyana.setNome("Jullyana");
		motoristaRepo.save(jullyana);

		Motorista koto = new Motorista();
		koto.setNome("Koto");
		motoristaRepo.save(koto);
	}

	@Override
	public Motorista salvarNovo(String nome) {
		Motorista motorista = new Motorista();
		motorista.setNome(nome);
		return motoristaRepo.save(motorista);
	}

	@Override
	public Iterable<Motorista> carregarTodos() {
		return motoristaRepo.findAll();
	}

    @Override
    public Set<Motorista> carregarPorCaminhao(Caminhao caminhao) {
        return motoristaRepo.buscaPorCaminhao(caminhao.getId());
    }

	@Override
	@Transactional
	public void adicionarCaminhao(Long motoristaId, Long caminhaoId) {
		Motorista motorista = motoristaRepo.findOne(motoristaId);
		Caminhao caminhao = caminhaoRepo.findOne(caminhaoId);
        if(motorista.getId() != null && caminhao.getId() != null){
            Set<Caminhao> caminhaos = motorista.getCaminhoes();
            if(!caminhaos.contains(caminhao)){
                caminhaos.add(caminhao);
                motorista.setCaminhoes(caminhaos);
                motoristaRepo.save(motorista);
            }
        }
	}
}
