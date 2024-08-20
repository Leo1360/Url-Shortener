# Short Link - A simple link shortener
> Um encurtador de links simples com uma api REST inclusa.

## Como usar
Os metodos da API Rest estão no arquivo do [Postman](./Short%20URL-Collection.json).\
Os links podem ser encurtados no navegador em [localhost:8080](localhost:8080).\
Para usar o redirecionamento no navegador basta chamar localhost:8080/l/{encurtamento} 

## Como instalar
Recomendo fazer fazer a instalação pelo docker. Basta baixar esse repositório e dentro dele rolar `docker compose up` e tudo irá rodar com as configurações padrão, incluindo o banco de dados. As configurações de banco podem ser alteradas no `compose.yaml` caso seja necessário.


## Todo
- [ ] Gerar QrCode do link
