package br.edu.infnet.elberth.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.elberth.model.domain.Produto;
import br.edu.infnet.elberth.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;	
	
	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}
}
