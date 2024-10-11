package br.edu.infnet.elberth.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}