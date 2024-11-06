package br.edu.infnet.elberth.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.elberth.model.domain.Alimenticio;
import br.edu.infnet.elberth.model.service.AlimenticioService;

@RestController
public class AlimenticioController {

	@Autowired
	private AlimenticioService alimenticioService;
		
	@GetMapping(value = "/lista/alimenticio")
	public Collection<Alimenticio> obterLista(){
		
		return alimenticioService.obterLista();
	}

	@PostMapping(value = "/alimenticio/incluir")
	public String incluir(@RequestBody Alimenticio alimenticio) {
		
		alimenticioService.incluir(alimenticio);
		
		return "Inclusão realizada com sucesso.";
	}
}