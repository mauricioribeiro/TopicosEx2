package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Caminhao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CaminhaoRepository extends CrudRepository<Caminhao, Long> {

	Caminhao findByNome(String nome);

	@Query(value = "select c from Caminhao c where c.nome like :nome")
	Set<Caminhao> buscaCaminhao(@Param("nome") String nome);

	Set<Caminhao> findByRotasId(Long id);

	@Query(value="select c from Caminhao c join c.rotas as r where r.id = :id")
	Set<Caminhao> buscaPorRota(@Param("id") Long id);

}
