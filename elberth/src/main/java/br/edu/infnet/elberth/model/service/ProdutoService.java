package br.edu.infnet.elberth.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.elberth.Constantes;
import br.edu.infnet.elberth.exceptions.ProdutoNaoEncontradoException;
import br.edu.infnet.elberth.model.domain.Produto;
import br.edu.infnet.elberth.model.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;	

	public Collection<Produto> obterLista(){
		return (Collection<Produto>) produtoRepository.findAll();
	}
	
	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public List<Produto> obterListaPorPreco(float precoInicial, float precoFinal){
		return produtoRepository.findByPrecoBetween(precoInicial, precoFinal);
	}

	public long obterQtde() {
		return produtoRepository.count();
	}

	public void excluir(Integer id) {
		produtoRepository.deleteById(id);		
	}

	public Produto obterPorId(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}

	public Produto alterar(Integer id, float preco) {
		
		Produto produtoExistente = produtoRepository.findById(id).orElseThrow(() -> 
			new ProdutoNaoEncontradoException(Constantes.MSG_PRODUTO_NOT_FOUND));
		
		produtoExistente.setPreco(preco);
		
		return produtoRepository.save(produtoExistente);
	}
}