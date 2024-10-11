package br.edu.infnet.elberth.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.elberth.model.domain.Vendedor;

@Service
public class VendedorService {

	private Map<String, Vendedor> mapaVendedores = new HashMap<String, Vendedor>();
	
	public void incluir(Vendedor vendedor) {
		mapaVendedores.put(vendedor.getCpf(), vendedor);		
	}
	
	public Collection<Vendedor> obterLista(){
		return mapaVendedores.values();
	}
}