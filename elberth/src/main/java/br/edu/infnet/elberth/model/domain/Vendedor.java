package br.edu.infnet.elberth.model.domain;

import java.util.ArrayList;
import java.util.List;

public class Vendedor {
	private String nome;
	private String cpf;
	private String email;
	private List<Produto> produtos;
	private Endereco endereco;
	
	public Vendedor() {
		produtos = new ArrayList<Produto>();
	}
	
	@Override
	public String toString() {

		return String.format("[%s] Vendedor %s cadastrado com sucesso! %s; Produtos: %d", 
				cpf,
				nome,
				endereco,
				produtos.size()
			);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}