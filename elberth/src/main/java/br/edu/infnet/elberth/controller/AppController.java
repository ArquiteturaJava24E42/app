package br.edu.infnet.elberth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.elberth.model.service.AlimenticioService;
import br.edu.infnet.elberth.model.service.EletronicoService;
import br.edu.infnet.elberth.model.service.ProdutoService;
import br.edu.infnet.elberth.model.service.VendedorService;

@Controller
public class AppController {
	
	@Autowired
	private VendedorService vendedorService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private AlimenticioService alimenticioService;
	@Autowired
	private EletronicoService eletronicoService;

	@GetMapping(value = "/")
	public String telaHome(Model model) {

		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeAlimenticio", alimenticioService.obterQtde());
		model.addAttribute("qtdeEletronico", alimenticioService.obterQtde());

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
		model.addAttribute("listagem", eletronicoService.obterLista());
		
		return telaHome(model);
	}
	
	@GetMapping(value = "/alimenticio/listagem")
	public String alimenticioLista(Model model) {
		
		model.addAttribute("titulo", "Listagem de produtos alimenticios");
		model.addAttribute("listagem", alimenticioService.obterLista());
		
		return telaHome(model);
	}
}