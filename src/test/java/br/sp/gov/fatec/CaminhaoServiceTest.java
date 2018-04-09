package br.sp.gov.fatec;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.model.Rota;
import br.gov.sp.fatec.service.CaminhaoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.HashSet;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
@Transactional
public class CaminhaoServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String NOME = "Caminhao A";

    @Autowired
    private CaminhaoService caminhaoService;

    public void setCaminhaoRepo(CaminhaoService caminhaoService) {
        this.caminhaoService = caminhaoService;
    }

    @Test
    public void testeInsercaoOk() {
        Caminhao caminhao = caminhaoService.salvarNovo(NOME);
        assertTrue(caminhao.getId() != null);
    }

    @Test
    public void testeDeletarOk() {
        Caminhao caminhao = caminhaoService.salvarNovo(NOME);
        Long id = caminhao.getId();
        caminhaoService.removerPorId(id);

        assertTrue(caminhaoService.buscarPorId(id) == null);
    }
}
