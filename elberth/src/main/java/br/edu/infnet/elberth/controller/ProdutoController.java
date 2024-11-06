package br.edu.infnet.elberth.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.elberth.model.domain.Produto;
import br.edu.infnet.elberth.model.service.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
		
	@GetMapping(value = "/lista/produto")
	public Collection<Produto> obterLista(){
		
		return produtoService.obterLista();
	}

	@GetMapping(value = "/produtos/filtrarPorPreco")
	public ResponseEntity<List<Produto>> obterListaPorPreco(@RequestParam float min, @RequestParam float max){
		
		if(min < 0 || max < 0 || min > max) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		List<Produto> produtos = produtoService.obterListaPorPreco(min, max);
		
		if(produtos.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(produtos);
		}
		
		return ResponseEntity.ok(produtos);
	}	

	@PostMapping(value = "/produto/incluir")
	public String incluir(@RequestBody Produto produto) {
		
		produtoService.incluir(produto);
		
		return "Inclusão realizada com sucesso.";
	}
	
	@DeleteMapping(value = "/produto/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		produtoService.excluir(id);
		
		return "Exclusão realizada com sucesso.";
	}
	
	@GetMapping(value = "/produto/{id}")
	public Produto obterPorId(@PathVariable Integer id) {
		return produtoService.obterPorId(id);
	}
}