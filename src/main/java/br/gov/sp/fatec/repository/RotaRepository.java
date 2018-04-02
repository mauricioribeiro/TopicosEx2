package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Rota;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface RotaRepository extends CrudRepository<Rota, Long> {

    Set<Rota> findAll();

    @Query(value = "select r from Rota r where r.origem like :origem")
    Set<Rota> buscaOrigem(@Param("origem") String origem);

    @Query(value = "select r from Rota r where r.destino like :destino")
    Set<Rota> buscaDestino(@Param("destino") String destino);

}
