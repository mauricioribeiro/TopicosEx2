package br.sp.gov.fatec;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.model.Rota;
import br.gov.sp.fatec.repository.CaminhaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class CaminhaoRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String NOME = "Caminhao A";
    private static final String ROTA_ORIGEM = "São Paulo";
    private static final String ROTA_DESTINO = "São José dos Campos";

    @Autowired
    private CaminhaoRepository caminhaoRepo;

    private Caminhao create(){
        Caminhao caminhao = new Caminhao();
        caminhao.setNome(NOME);

        Rota rota = new Rota();
        rota.setOrigem(ROTA_ORIGEM);
        rota.setDestino(ROTA_DESTINO);
        caminhao.setRotas(new HashSet<Rota>(Collections.singletonList(rota)));

        return caminhao;
    }

    public void setCaminhaoRepo(CaminhaoRepository caminhaoRepo) {
        this.caminhaoRepo = caminhaoRepo;
    }

    @Test
    public void testeInsercaoOk() {
        Caminhao caminhao = caminhaoRepo.save(create());
        assertTrue(caminhao.getId() != null);
    }

    @Test
    public void testeDeletarOk() {
        Caminhao caminhao = caminhaoRepo.save(create());
        Long id = caminhao.getId();
        caminhaoRepo.delete(id);

        assertNull(caminhaoRepo.findOne(id));
    }

    @Test
    public void testeConsultaOk(){
        Caminhao caminhao = caminhaoRepo.save(create());
        Rota rota = caminhao.getRotas().iterator().next();
        assertNotNull(caminhaoRepo.buscaPorRota(rota.getId()));
    }
}
