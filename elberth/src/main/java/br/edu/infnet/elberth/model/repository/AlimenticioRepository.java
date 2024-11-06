package br.edu.infnet.elberth.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.elberth.model.domain.Alimenticio;

@Repository
public interface AlimenticioRepository extends CrudRepository<Alimenticio, Integer> {
}