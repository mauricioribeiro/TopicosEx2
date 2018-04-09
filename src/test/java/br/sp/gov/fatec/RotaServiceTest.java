package br.sp.gov.fatec;

import br.gov.sp.fatec.model.Rota;
import br.gov.sp.fatec.repository.RotaRepository;
import br.gov.sp.fatec.service.RotaService;
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
public class RotaServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String ORIGEM = "São Paulo";
    private static final String DESTINO = "São José dos Campos";

    @Autowired
    private RotaService rotaService;

    public void setRotaRepo(RotaService rotaService) {
        this.rotaService = rotaService;
    }

    @Test
    public void testeInsercaoOk() {
        Rota rota = rotaService.salvarNovo(ORIGEM, DESTINO);
        assertTrue(rota.getId() != null);
    }

    @Test
    public void testeDeletarOk() {
        Rota rota = rotaService.salvarNovo(ORIGEM, DESTINO);
        Long id = rota.getId();
        rotaService.removerPorId(id);

        assertTrue(rotaService.buscarPorId(id) == null);
    }
}
