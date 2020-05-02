# lab-tcc
Laboratorio do Trabalho de Conclusão de Curso  - UNIFOR 2017.1

Laboratorio para deteirminar a influência da estratégia de modelagem dos dados  
no armazenamento e processamento de consultas em banco de dados NoSQL baseado
no modelo famílias de colunas.

## Sistemas NoSQL estudados

* HBase
* Cassandra


##O experimento

Com objetivo de validar as tecnicas de armazenamento em NoSQl foi obtido uma base
base de dados relacional já existente e elaborado conjunto de consultas, esta base de dados e
consultas é utilizado de exemplo para inserção e seleção de dados nos sistemas
NoSQL, o resultado do trabalho realizado em cada modelo é analisado.

###Estrategia do Experimento

* Criar base de dados relacional e consultas
* Implantar base de dados em sistemas NoSQL no Habse para todos os modelos de dados sugeridos.
* Implantar base de dados em sistemas NoSQL no Cassanra para todos os modelos de dados sugeridos.
* Fazer analise dos resultados de cada modelo no Habase
* Fazer analise dos resultados de cada modelo no Cassandra
* Conclusão

## Categorização de consultas

* **Simples**: Consulta em apenas uma tabela com ou sem filtro simples.
* **Media**: Consulta em apenas uma tabela com um relacionamento ou agragação.
* **Complexa**: Consulta com um relacionamento e agregação, ou mais de um relacionamento.


## Experimentos

* **workload** - Carga do dataset no banco de dados (HBase/Cassandra).
* **queryrun** - Executa consultas e obem metricas.
* **dashboard** - Exibe resultado da analise.

## Modelagem dos dados

Aplicar moelagem relacional e comparar com modelagem orientada a consulta.

## Analise

Consulta, banco de dados, complexidade, modo de execução, tecnologia de consulta,
quantidade de nos, tempo de execução, espaço de armazenamento.

## Categorização de consultas

* **Simples**: Consulto em apenas uma tabela com filtro simples.
* **Media**: Consulta com dois relacionamentos ou com agregação em uma única tabela.
* **Complexa**: Consultas com relacionamentos.  

## Consultas

* Q1 - Selecionar PostHistory por PostId - Simples

        SELECT *
        FROM PostHistory
        WHERE PostId = 33

* Q2 - Selecionar total de Scores por ID do usuario - Media

        SELECT OwnerUserId, sum(Scores)
        FROM Posts
        GROUP BY OwnerUserId

* Q3 - Selecionar todos as postagens (Posts) fechadas (PostHistoryTypeId igual á 10)

        SELECT p.*
        FROM Posts p INNER JOIN PostHistory ph p.Id = ph.PostId
        WHERE PostHistoryTypeId = 10
        --10: Post Closed - A post was voted to be closed.

* Q4 - Selecionar total de votos positivos e negativos de todos as postagends de um determinado usuario - Complexa

        SELECT p.UserId, count(UpMod), count(DownMod)
        FROM Votes v, Posts p
        WHERE p.Id = v.PostId
        AND UserId = 1
        GROUP BY UserId

* Q4.1 - Selecionar total de votos positivos e negativos de todos os usuarios s- Complexa

        SELECT p.UserId, count(UpMod), count(DownMod)
        FROM Votes v, Posts p
        WHERE p.Id = v.PostId
        GROUP BY UserId

## Tarefas

1. Obter base de dados de teste, dump stack overflow.
2. Slecionar base menos para teste
3. Criar codigo de parse do xml.
4. para insert em base relacional com postgresql.


Command Line to parce xml


workload put -Ddb=Cassandra -DfileDir=beer.stackchange.com -Dhost=""

workload put -Dall=true -Ddb=Cassandra -DfileDir=beer.stackchange.com -Dhost=""
p
o acesso ao banco de dados ttem um tempo e tempo de processamento posterior

mesmo favorencendo o armanazemanento tem casos em qu é necessario processamento pela aplicaçãos

tem que rodar 3 vezes e tirar uma media?

para tudo e roda cada constil

Rodar todos os teste


gol dia 08

## Projeto

* apps - Aplicações
* build-tools - Ferramentas de build e scripts de desenvolvimento
* doc - Documentação do projeto
* etc - Arquivos de configuração do projeto
* tmp - Provas de conceito e experimentos
* tools - Ferramentas do projeto
* var - Diretorio com dados



Corrigir exception da Carga.
Aplicar retrição da chvaes na carga de tabelas normais.
Verificação dos resultados das consulta, gerar evidência.
