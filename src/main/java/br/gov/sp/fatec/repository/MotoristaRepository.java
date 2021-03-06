package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Motorista;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface MotoristaRepository extends CrudRepository<Motorista, Long> {

	Motorista findOneByNome(String nome);

	@Query(value = "select m from Motorista m where m.nome like :nome")
	Set<Motorista> buscaMotorista(@Param("nome") String nome);

	@Query(value="select m from Motorista m join m.caminhoes as c where c.id = :id")
	Set<Motorista> buscaPorCaminhao(@Param("id") Long id);

}
