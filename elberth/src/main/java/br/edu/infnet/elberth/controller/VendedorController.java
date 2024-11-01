package br.edu.infnet.elberth.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.elberth.model.domain.Vendedor;
import br.edu.infnet.elberth.model.service.VendedorService;

@RestController
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping(value = "/lista/vendedor")
	public Collection<Vendedor> obterLista(){
		
		return vendedorService.obterLista();
	}
	
	@PostMapping(value = "/vendedor/incluir")
	public String incluir(@RequestBody Vendedor vendedor) {
		
		vendedorService.incluir(vendedor);
		
		return "Inclusão realizada com sucesso.";
	}
	
	@DeleteMapping(value = "/vendedor/{id}/excluir")
	public String excluir(@PathVariable Integer id) {
		
		vendedorService.excluir(id);
		
		return "Exclusão realizada com sucesso.";
	}
	
	@GetMapping(value = "/vendedores/buscar/{nome}")
	public List<Vendedor> obterPorNome(@PathVariable String nome){
		return vendedorService.obterPorNome(nome);
	}	
	
	@GetMapping(value = "/vendedor/{id}")
	public Vendedor obterPorId(@PathVariable Integer id) {
		return vendedorService.obterPorId(id);
	}
}