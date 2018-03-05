package br.gov.sp.fatec;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.model.Rota;
import br.gov.sp.fatec.repository.CaminhaoRepository;
import br.gov.sp.fatec.service.CaminhaoService;
import br.gov.sp.fatec.service.RotaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App 
{

	public static void main( String[] args )
    {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		CaminhaoService caminhaoService = (CaminhaoService)context.getBean("caminhaoService");
		RotaService rotaService = (RotaService)context.getBean("rotaService");

		try {
			rotaService.inicializar();
			caminhaoService.inicializar();
		}
		catch(Exception e) {
			System.out.println("Erro esperado! Rollback realizado!");
			e.printStackTrace();
		}

		Caminhao teste = caminhaoService.salvarNovo("Teste");
		List<Rota> rotas = rotaService.carregarPorOrigem("São José dos Campos");

		for (Rota rota : rotas){
			caminhaoService.adicionarRota(teste.getId(), rota.getId());
		}

        for(Caminhao caminhao : caminhaoService.carregarTodos()){
            System.out.println(caminhao.getNome());
        }

        for(Rota rota : rotaService.carregarTodos()){
            System.out.println("Caminhões para a rota: " + rota.getOrigem() + " à " + rota.getDestino());

			for(Caminhao caminhao : caminhaoService.carregarPorRota(rota)){
				System.out.println(caminhao.getNome());
			}
        }

    }
    
}
