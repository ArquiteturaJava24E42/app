package br.edu.infnet.elberth.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.elberth.model.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {

}
