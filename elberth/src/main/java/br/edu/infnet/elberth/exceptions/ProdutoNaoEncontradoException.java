package br.edu.infnet.elberth.exceptions;

public class ProdutoNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProdutoNaoEncontradoException(String message) {
		super(message);
	}
}
