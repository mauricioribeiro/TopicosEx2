package br.gov.sp.fatec;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.model.Motorista;
import br.gov.sp.fatec.model.Rota;
import br.gov.sp.fatec.service.CaminhaoService;
import br.gov.sp.fatec.service.MotoristaService;
import br.gov.sp.fatec.service.RotaService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class App 
{

	public static void main( String[] args )
    {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		CaminhaoService caminhaoService = (CaminhaoService)context.getBean("caminhaoService");
		RotaService rotaService = (RotaService)context.getBean("rotaService");
		MotoristaService motoristaService = (MotoristaService)context.getBean("motoristaService");

		try {
			rotaService.inicializar();
			caminhaoService.inicializar();
			motoristaService.inicializar();
		}
		catch(Exception e) {
			System.out.println("Erro esperado! Rollback realizado!");
			e.printStackTrace();
		}

		Caminhao testeCaminhao = caminhaoService.salvarNovo("Teste Caminhão");
		Set<Rota> rotas = rotaService.carregarPorOrigem("São José dos Campos");
		Motorista testeMotorista = motoristaService.salvarNovo("Teste Motorista");

		for (Rota rota : rotas){
			caminhaoService.adicionarRota(testeCaminhao.getId(), rota.getId());
		}

        for(Caminhao caminhao : caminhaoService.carregarTodos()){
            System.out.println(caminhao.getNome());
        }

		for(Motorista motorista : motoristaService.carregarTodos()){
			System.out.println(motorista.getNome());
		}

        for(Rota rota : rotaService.carregarTodos()){
            System.out.println("Caminhões para a rota: " + rota.getOrigem() + " à " + rota.getDestino());

			for(Caminhao caminhao : caminhaoService.carregarPorRota(rota)){
				System.out.println(caminhao.getNome());
			}
        }

    }
    
}
