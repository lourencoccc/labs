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

* Q1 - Selecionar PostHistory por UserId - Simples

        SELECT *
        FROM PostHistory
        WHERE UserId = 1

* Q2 - Selecionar total de Scores por ID do usuario - Media

        SELECT UserID, sum(Scores)
        FROM Posts
        GROUP BY UserID

* Q3 - Selecionar Posts fechados por motivo de off-topic - Media

        SELECT p.PostId
        FROM Posts p INNER JOIN PostHistory ph p.Id = ph.PostId
        WHERE CloseReasonId =  2 --2: off-topic


* Q4 - Selecionar total de votos UpMod e DownMod por UserId - Complexa

        SELECT p.UserId, count(UpMod), count(DownMod)
        FROM Votes v, Posts p
        WHERE p.Id = v.PostId
        AND UserId = 1
        GROUP BY UserId

## Tarefas

1. Obter base de dados de teste, dump stack overflow.
2. Slecionar base menos para teste
3. Criar codigo de parse do xml.
4. para insert em base relacional com postgresql.




Command Line to parce xml


workload put -Ddb=Cassandra -DfileDir=beer.stackchange.com -Dhost=""

workload put -Dall=true -Ddb=Cassandra -DfileDir=beer.stackchange.com -Dhost=""
