package br.edu.infnet.elberth.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

	public Vendedor incluir(Vendedor vendedor) {
		
		String cep = vendedor.getEndereco().getCep();
		
		Endereco endereco = localizacaoService.findByCep(cep);

		vendedor.setEndereco(endereco);

		return vendedorRepository.save(vendedor);
	}
	
	public boolean excluir(Integer id) {
		
		vendedorRepository.deleteById(id);
		
		return true;
	}
	
	public Collection<Vendedor> obterLista(){
		return (Collection<Vendedor>) vendedorRepository.findAll(Sort.by(Sort.Order.asc("nome")));
	}
	
	public List<Vendedor> obterPorNome(String nome){
		return vendedorRepository.findByNomeContaining(nome, Sort.by(Sort.Order.asc("nome")));
	}
	
	public long obterQtde() {
		return vendedorRepository.count();
	}

	public Vendedor obterPorId(Integer id) {
		return vendedorRepository.findById(id).orElse(null);
	}
}