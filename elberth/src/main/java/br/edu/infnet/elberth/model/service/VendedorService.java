package br.edu.infnet.elberth.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.elberth.model.domain.Endereco;
import br.edu.infnet.elberth.model.domain.Vendedor;
import br.edu.infnet.elberth.model.repository.VendedorRepository;

@Service
public class VendedorService {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private LocalizacaoService localizacaoService;

	private Map<String, Vendedor> mapaVendedores = new HashMap<String, Vendedor>();
	
	public void incluir(Vendedor vendedor) {
		
		String cep = vendedor.getEndereco().getCep();
		
		Endereco endereco = localizacaoService.findByCep(cep);

		vendedor.setEndereco(endereco);

		mapaVendedores.put(vendedor.getCpf(), vendedor);	
		
		vendedorRepository.save(vendedor);
	}
	
	public Collection<Vendedor> obterLista(){
		return mapaVendedores.values();
	}
}