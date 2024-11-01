package br.edu.infnet.elberth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.elberth.model.service.ProdutoService;
import br.edu.infnet.elberth.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/")
	public String telaHome(Model model) {

		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeAlimenticio", 123);
		model.addAttribute("qtdeEletronico", 234);

		return "home";
	}
	
	@GetMapping(value = "/vendedor/listagem")
	public String vendedorLista(Model model) {
				
		model.addAttribute("titulo", "Listagem de vendedores");
		model.addAttribute("listagem", vendedorService.obterLista());
		
		return telaHome(model);
	}

	@GetMapping(value = "/produto/listagem")
	public String produtoLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de produtos");
		model.addAttribute("listagem", produtoService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/eletronico/listagem")
	public String eletronicoLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de produtos eletrônicos");
		model.addAttribute("listagem", produtoService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/alimenticio/listagem")
	public String alimenticioLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de produtos alimenticios");
		model.addAttribute("listagem", produtoService.obterLista());
		
		return telaHome(model);
	}
}