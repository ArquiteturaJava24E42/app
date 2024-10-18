package br.edu.infnet.elberth.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.elberth.model.domain.Vendedor;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Integer> {

}