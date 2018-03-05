package br.gov.sp.fatec.repository;

import java.util.List;

import br.gov.sp.fatec.model.Caminhao;
import br.gov.sp.fatec.model.Rota;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CaminhaoRepository extends CrudRepository<Caminhao, Long> {

	Caminhao findByNome(String nome);

	@Query(value = "select c from Caminhao c where c.nome like :nome")
	List<Caminhao> buscaCaminhao(@Param("nome") String nome);

	@Query(value="select c from Caminhao c join c.rotas as r where r.id = :id")
	List<Caminhao> buscaPorRota(@Param("id") Long id);

}
