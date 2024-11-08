package br.edu.infnet.elberth.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.elberth.Constantes;
import br.edu.infnet.elberth.model.domain.Alimenticio;
import br.edu.infnet.elberth.model.service.AlimenticioService;

@RestController
@RequestMapping("/alimenticios")
public class AlimenticioController {

	@Autowired
	private AlimenticioService alimenticioService;
		
	@GetMapping
	public ResponseEntity<Collection<Alimenticio>> obterLista(){
		
		return ResponseEntity.ok(alimenticioService.obterLista());
	}

	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@RequestBody Alimenticio alimenticio) {
		
		alimenticioService.incluir(alimenticio);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	@PutMapping(value = "/alterar")
	public ResponseEntity<Alimenticio> alterar(@RequestBody Alimenticio alimenticio) {
		
		Alimenticio alimenticioAtualizado = alimenticioService.alterar(alimenticio);
		
		return ResponseEntity.ok(alimenticioAtualizado);
	}
}