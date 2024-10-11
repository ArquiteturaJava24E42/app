package br.edu.infnet.elberth;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.elberth.model.domain.Alimenticio;
import br.edu.infnet.elberth.model.domain.Eletronico;
import br.edu.infnet.elberth.model.domain.Endereco;
import br.edu.infnet.elberth.model.domain.Vendedor;
import br.edu.infnet.elberth.model.service.VendedorService;

@Component
public class Loader implements ApplicationRunner {
	
	@Autowired
	private VendedorService vendedorService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("files/vendedores.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		
		Vendedor vendedor = null;

		while(linha != null) {
			
			String[] campos = linha.split(";");
			
			switch (campos[0].toUpperCase()) {
			case "V":
				
				Endereco endereco = new Endereco();
				endereco.setCep(campos[4]);

				vendedor = new Vendedor();			
				vendedor.setCpf(campos[1]);
				vendedor.setEmail(campos[2]);
				vendedor.setNome(campos[3]);
				vendedor.setEndereco(endereco);				
				
				vendedorService.incluir(vendedor);
				
				break;

			case "A":
				Alimenticio alimenticio = new Alimenticio();
				alimenticio.setCodigo(Integer.valueOf(campos[1]));
				alimenticio.setDescricao(campos[2]);
				alimenticio.setEstoque(Boolean.valueOf(campos[3]));
				alimenticio.setPreco(Float.valueOf(campos[4]));
				alimenticio.setCaracteristica(campos[5]);
				alimenticio.setOrganico(Boolean.valueOf(campos[6]));
				
				vendedor.getProdutos().add(alimenticio);				
				
				break;

			case "E":
				
				Eletronico eletronico = new Eletronico();
				eletronico.setCodigo(Integer.valueOf(campos[1]));
				eletronico.setDescricao(campos[2]);
				eletronico.setEstoque(Boolean.valueOf(campos[3]));
				eletronico.setPreco(Float.valueOf(campos[4]));
				eletronico.setMarca(campos[5]);
				eletronico.setGarantiaMeses(Integer.valueOf(campos[6]));

				vendedor.getProdutos().add(eletronico);				
				
				break;

			default:
				break;
			}
					
			linha = leitura.readLine();
		}
		
		for(Vendedor v: vendedorService.obterLista()) {
			System.out.println("Vendedor cadastrado com sucesso: " + v);			
		}

		leitura.close();
	}
}