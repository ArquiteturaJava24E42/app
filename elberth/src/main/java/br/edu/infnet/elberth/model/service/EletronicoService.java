package br.edu.infnet.elberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.elberth.model.domain.Eletronico;
import br.edu.infnet.elberth.model.repository.EletronicoRepository;

@Service
public class EletronicoService {

	@Autowired
	private EletronicoRepository eletronicoRepository;	

	public Collection<Eletronico> obterLista(){
		return (Collection<Eletronico>) eletronicoRepository.findAll();
	}
	
	public void incluir(Eletronico eletronico) {
		eletronicoRepository.save(eletronico);
	}

	public long obterQtde() {
		return eletronicoRepository.count();
	}
}