package br.edu.infnet.elberth.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.elberth.Constantes;
import br.edu.infnet.elberth.model.domain.Vendedor;
import br.edu.infnet.elberth.model.service.VendedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@Operation(summary = "Recupera todos os vendedores existentes.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Sucesso"),
			@ApiResponse(responseCode = "500", description = "Erro interno do sistema")
		})
	@GetMapping
	public ResponseEntity<Collection<Vendedor>> obterLista(){		
		return ResponseEntity.ok(vendedorService.obterLista());
	}
	
	@Operation(summary = "Inclui um novo vendedor.")
	@PostMapping(value = "/incluir")
	public ResponseEntity<String> incluir(@Valid @RequestBody Vendedor vendedor) {
		
		vendedorService.incluir(vendedor);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(Constantes.MSG_INCLUSAO_SUCESSO);
	}
	
	@Operation(summary = "Exclui um vendedor através do ID.")
	@DeleteMapping(value = "/{id}/excluir")
	public ResponseEntity<String> excluir(@PathVariable Integer id) {
		
		if(vendedorService.excluir(id)) {
			return ResponseEntity.ok(Constantes.MSG_EXCLUSAO_SUCESSO);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Constantes.MSG_VENDEDOR_NOT_FOUND);
	}
	
	@Operation(summary = "Busca um vendedor através do nome.")
	@GetMapping(value = "/buscar/{nome}")
	public ResponseEntity<List<Vendedor>> obterPorNome(@PathVariable String nome){
		
		List<Vendedor> vendedores = vendedorService.obterPorNome(nome);
		
		if(vendedores.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(vendedores);
		}
		
		return ResponseEntity.ok(vendedores);
	}	
	
	@Operation(summary = "Busca um vendedor através do ID.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Vendedor> obterPorId(@PathVariable Integer id) {
		
		Vendedor vendedor = vendedorService.obterPorId(id);
		
		if(vendedor == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(vendedor);
	}
}