package br.sp.gov.fatec;

import br.gov.sp.fatec.model.Motorista;
import br.gov.sp.fatec.service.MotoristaService;
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
public class MotoristaServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String NOME = "Maria";

    @Autowired
    private MotoristaService motoristaService;

    public void setMotoristaRepo(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @Test
    public void testeInsercaoOk() {
        Motorista motorista = motoristaService.salvarNovo(NOME);
        assertTrue(motorista.getId() != null);
    }

    @Test
    public void testeDeletarOk() {
        Motorista motorista = motoristaService.salvarNovo(NOME);
        Long id = motorista.getId();
        motoristaService.removerPorId(id);

        assertTrue(motoristaService.buscarPorId(id) == null);
    }
}
