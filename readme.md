# Short Link - A simple link shortener
> Um encurtador de links simples com uma api REST inclusa.

## Como usar
Os metodos da API Rest estão no arquivo do [Postman](./Short%20URL-Collection.json).\
Os links podem ser encurtados no navegador em [localhost:8080](localhost:8080).\
Para usar o redirecionamento no navegador basta chamar localhost:8080/l/{encurtamento} 

## Como rodar
O arquivo do programa esta na pasta **package**, para roda-lo é necessário um banco de dados mysql rodando na porta padrão (3306) no qual os dados dos links serão salvos.

## Todo
- [ ] Gerar QrCode do link
