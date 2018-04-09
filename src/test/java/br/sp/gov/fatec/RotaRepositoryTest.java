package br.sp.gov.fatec;

import br.gov.sp.fatec.model.Rota;
import br.gov.sp.fatec.repository.RotaRepository;
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
public class RotaRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private static final String ORIGEM = "São Paulo";
    private static final String DESTINO = "São José dos Campos";

    @Autowired
    private RotaRepository rotaRepo;

    private Rota create(){
        Rota rota = new Rota();
        rota.setOrigem(ORIGEM);
        rota.setDestino(DESTINO);

        return rota;
    }

    public void setRotaRepo(RotaRepository rotaRepo) {
        this.rotaRepo = rotaRepo;
    }

    @Test
    public void testeInsercaoOk() {
        Rota rota = rotaRepo.save(create());
        assertTrue(rota.getId() != null);
    }

    @Test
    public void testeDeletarOk() {
        Rota rota = rotaRepo.save(create());
        Long id = rota.getId();
        rotaRepo.delete(id);

        assertTrue(rotaRepo.findOne(id) == null);
    }
}
