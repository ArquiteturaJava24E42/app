package br.edu.infnet.elberth.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.elberth.model.domain.Eletronico;
import br.edu.infnet.elberth.model.service.EletronicoService;

@RestController
public class EletronicoController {

	@Autowired
	private EletronicoService eletronicoService;
		
	@GetMapping(value = "/lista/eletronico")
	public Collection<Eletronico> obterLista(){
		
		return eletronicoService.obterLista();
	}

	@PostMapping(value = "/eletronico/incluir")
	public String incluir(@RequestBody Eletronico eletronico) {
		
		eletronicoService.incluir(eletronico);
		
		return "Inclusão realizada com sucesso.";
	}
}