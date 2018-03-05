package br.gov.sp.fatec.repository;

import br.gov.sp.fatec.model.Rota;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RotaRepository extends CrudRepository<Rota, Long> {

    List<Rota> findAll();

    @Query(value = "select r from Rota r where r.origem like :origem")
    List<Rota> buscaOrigem(@Param("origem") String origem);

    @Query(value = "select r from Rota r where r.destino like :destino")
    List<Rota> buscaDestino(@Param("destino") String destino);

}
