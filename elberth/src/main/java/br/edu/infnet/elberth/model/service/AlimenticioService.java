package br.edu.infnet.elberth.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.elberth.model.domain.Alimenticio;
import br.edu.infnet.elberth.model.repository.AlimenticioRepository;

@Service
public class AlimenticioService {

	@Autowired
	private AlimenticioRepository alimenticioRepository;	

	public Collection<Alimenticio> obterLista(){
		return (Collection<Alimenticio>) alimenticioRepository.findAll();
	}
	
	public void incluir(Alimenticio alimenticio) {
		alimenticioRepository.save(alimenticio);
	}

	public long obterQtde() {
		return alimenticioRepository.count();
	}
}