package br.edu.infnet.elberth.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.elberth.model.domain.Eletronico;

@Repository
public interface EletronicoRepository extends CrudRepository<Eletronico, Integer> {
}