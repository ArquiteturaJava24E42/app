# Projeto Final Arquitetura Java [24E4_2] - Cadastro de Vendedores e Produtos

Este projeto faz parte da disciplina de **Arquitetura Java** e será desenvolvido em quatro etapas. Esta é a **primeira entrega**, na qual implementamos a funcionalidade de **Cadastro de Vendedores e Produtos**, que permite registrar vendedores com seus respectivos produtos (alimentícios e eletrônicos) em um sistema básico utilizando Spring Boot.

## Funcionalidades Entregues

### Feature 1: Cadastro de Vendedores e Produtos
Nesta primeira entrega, foram implementadas as seguintes funcionalidades:

- **Cadastro de Vendedores**: Cada vendedor possui nome, CPF, e-mail e um endereço associado.
- **Cadastro de Produtos**: Dois tipos de produtos podem ser cadastrados:
  - **Alimentícios**: Produtos com características como orgânico ou não e descrição detalhada.
  - **Eletrônicos**: Produtos com informações sobre marca e garantia.
- **Leitura de Arquivo**: O sistema lê um arquivo de texto com informações de vendedores e produtos e realiza o cadastro automático no sistema.
- **Listagem de Vendedores e Produtos**: Exibe os vendedores cadastrados, bem como seus produtos associados.

### Estrutura do Projeto

- **`br.edu.infnet.elberth.ElberthApplication`**: Classe principal do projeto Spring Boot.
- **`br.edu.infnet.elberth.Loader`**: Classe responsável por carregar dados iniciais a partir de um arquivo de texto.
- **Domínio**:
  - `Vendedor`: Representa o vendedor e contém uma lista de produtos.
  - `Produto`: Classe abstrata para representar produtos.
  - `Alimenticio`: Subclasse de `Produto` que representa produtos alimentícios.
  - `Eletronico`: Subclasse de `Produto` que representa produtos eletrônicos.
  - `Endereco`: Representa o endereço do vendedor.
- **Serviço**:
  - `VendedorService`: Classe que gerencia a inclusão e recuperação dos vendedores cadastrados.

### Arquivo de Entrada

Os vendedores e produtos são cadastrados automaticamente a partir do arquivo `files/vendedores.txt`. O arquivo deve seguir o seguinte formato:
V;cpf;email;nome;cep A;codigo;descricao;estoque;preco;caracteristica;organico 
E;codigo;descricao;estoque;preco;marca;garantiaMeses

Exemplo:
V;123123123123;elberth@elberth.com;Elberth Moraes;01001000 
A;1;coca-cola;false;10;normal;false E;4;celular;true;40;xpto;15


### Tecnologias Utilizadas

- **Java 11**
- **Spring Boot 2.7.5**
- **Maven**

### Como Executar

1. Clone este repositório.
2. Certifique-se de que o Java 11 e o Maven estão instalados em sua máquina.
3. Compile o projeto executando:
mvn clean install

4. Execute o projeto com o comando:
mvn spring-boot

5. O sistema irá carregar os dados a partir do arquivo `files/vendedores.txt` e exibir a lista de vendedores e seus produtos no console.

## Autor

- **Elberth Moraes** - br.edu.infnet
