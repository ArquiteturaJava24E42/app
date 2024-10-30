package br.edu.infnet.elberth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.elberth.model.domain.Produto;
import br.edu.infnet.elberth.model.service.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
		
	@GetMapping(value = "/produtos/filtrarPorPreco/{min}/{max}")
	public List<Produto> obterListaPorPreco(@PathVariable float min, @PathVariable float max){
		return produtoService.obterListaPorPreco(min, max);
	}	
}