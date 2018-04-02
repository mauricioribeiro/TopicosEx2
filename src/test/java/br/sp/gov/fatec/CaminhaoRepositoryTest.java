package br.sp.gov.fatec;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.repository.CaminhaoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class CaminhaoRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String NOME = "Caminhao A";

    @Autowired
    private CaminhaoRepository caminhaoRepo;
    public void setCaminhaoRepo(CaminhaoRepository caminhaoRepo) {
        this.caminhaoRepo = caminhaoRepo;
    }
    @Test
    public void testeInsercaoOk() {
        Caminhao caminhao = new Caminhao();
        caminhao.setNome(NOME);
        caminhaoRepo.save(caminhao);
        assertTrue(caminhao.getId() != null);
    }
}
