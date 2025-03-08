# Serviço de Busca de CEP

Este é um projeto desenvolvido com o framework [Spring](https://spring.io/) 3.0.6, que fornece um serviço REST para buscar informações sobre um CEP (Código de Endereçamento Postal) e calcular o valor do frete baseado na unidade federativa (UF) de destino.

## Estrutura do Projeto

O projeto possui um único controlador (`novoCep`) responsável pela busca do CEP e cálculo do frete. O controlador interage com o serviço `CepService` para buscar os dados do CEP e realizar o cálculo do frete.

### Arquitetura

- **Controller**: `novoCep` (responsável pela definição das rotas HTTP e a lógica de chamada ao serviço de CEP)
- **Serviço**: `CepService` (responsável por buscar os dados de um CEP a partir de uma fonte externa)
- **Modelo de Dados**: `Cep` (representa o endereço com campos como logradouro, bairro, localidade e UF)

## Funcionalidades

- **GET /cep/{cep}**: Busca o endereço e o valor do frete associado a um CEP específico.

  - **Parâmetro de entrada**:

    - `cep` (String): O CEP desejado para consulta.

  - **Resposta**:
    - Um objeto JSON com os dados do endereço e o valor do frete calculado.

## Exemplo de Resposta

### Requisição

```bash
GET http://localhost:8080/cep/01001-000
```

### Resposta

```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "frete": 7.85
}
```

## Dependências

Este projeto utiliza as seguintes dependências principais:

- Spring Web: Para criação de serviços REST.
- Spring Boot: Para inicializar e configurar o aplicativo de forma simples e rápida.
- Spring Framework 3.0.6: Para gerenciamento de dependências e estrutura do projeto.

## Como Rodar o Projeto

### Pré-requisitos

- _Java 8_ ou superior
- Maven ou Gradle (para gerenciamento de dependências e execução)
- IDE: Como IntelliJ IDEA, Eclipse, ou VSCode (opcional)

### Passos para Execução

Clone o repositório:

```bash
git clone https://github.com/Dieg0Ch4ves/projeto-frete-cep.git
```

Navegue até o diretório do projeto:

```bash
cd projeto-frete-cep.git
```

Compile e execute o projeto:

```bash
mvn spring-boot:run
```

Acesse a API via [http://localhost:8080/cep/{cep}](http://localhost:8080/cep/{cep}).

### Contribuições

Contribuições são bem-vindas! Se você encontrou um bug ou deseja melhorar o projeto, fique à vontade para abrir um pull request.
