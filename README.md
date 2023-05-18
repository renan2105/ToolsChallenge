# ToolsChallenge

Projeto com intuito de simular apis de pagamentos com tratamento para utilização local.

### Tecnologias Utilizadas

-Java 17<br />
-Springboot<br />
-Maven<br />
-JPA<br />
-H2<br />
-Junit<br />
-Mockito<br />

### APIs

-Api de Pagamento(Método Post que simula um pagamento);
-Api de Consulta pagamento(Método Get que passando o id de uma transição retorna a informações desta transição, ou se apenas chamar sem passar id retorna todas transições.); <br />
-Api de Estorno(Método Get que se passa o id de uma transição, simulando assim um estorno e cancelando o pagamento.); <br /> <br />
*Estou deixando a collection "ToolsChallenge.postman_collection.json" para o postman dentro do projeto no caminho "ToolsChallenge\src\main\resources\collections"); <br />

### Rodar o Projeto

-Para rodar o projeto, basta apenas clonar ou baixar o projeto em um local de preferencia;<br />
-Abrir na idea de preferencia;<br />
-Configurar com Java SDK 17;<br />
-Configurar o Maven de preferencia;<br />
-Ao rodar o projeto basta importar a collection no postman de exemplo e executar.
