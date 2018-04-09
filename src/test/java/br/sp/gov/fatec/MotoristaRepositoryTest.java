package br.sp.gov.fatec;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.model.Motorista;
import br.gov.sp.fatec.repository.MotoristaRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class MotoristaRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String NOME = "Maria";
    private static final String CAMINHAO_NOME = "Caminhao 1";

    @Autowired
    private MotoristaRepository motoristaRepo;

    private Motorista create(){
        Caminhao caminhao = new Caminhao();
        caminhao.setNome(CAMINHAO_NOME);

        Motorista motorista = new Motorista();
        motorista.setNome(NOME);
        motorista.setCaminhoes(new HashSet<Caminhao>(Collections.singletonList(caminhao)));
        return motorista;
    }

    public void setMotoristaRepo(MotoristaRepository motoristaRepo) {
        this.motoristaRepo = motoristaRepo;
    }

    @Test
    public void testeInsercaoOk() {
        Motorista motorista = motoristaRepo.save(create());
        assertTrue(motorista.getId() != null);
    }

    @Test
    public void testeDeletarOk() {
        Motorista motorista = motoristaRepo.save(create());
        Long id = motorista.getId();
        motoristaRepo.delete(id);

        assertTrue(motoristaRepo.findOne(id) == null);
    }
}
