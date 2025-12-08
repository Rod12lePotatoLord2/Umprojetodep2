🔧 Passos Obrigatórios Antes de Executar a Aplicação


Este projeto utiliza persistência em arquivos JSON.
Antes de rodar o código, é necessário ir em usuarios.json e adicionar manualmente o tipo de cada usuário existente.


Exemplo:

  {
  
  "tipoUsuario" : "COMUM" <--------- ESSA LINHA DEVE EXISTIR EM CADA USUÁRIO COM O TIPO "COMUM" OU "PROFISSIONAL" PARA O CÓDIGO RODAR.
  
  "id" : 1,
  
  "nome" : "Fulano
  
  "email" : "fulano@gmail.com",
  
  "senha" : "123",
  
  "nivelMotivacao" : 5

}

Para que todos os CRUDs funcionem corretamente no Postman, é necessário rodar a classe principal da aplicação:


GestaoHabitosSaudaveisApplication.java


A aplicação deve permanecer em execução enquanto você:


usa rotas no Postman,
cria hábitos,
cria registros,
atualiza ou deleta dados.


Todos os dados são persistidos em arquivos JSON, como:


habitos.json

registro_diario.json

registro_habito.json

usuarios.json
