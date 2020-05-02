#Modelo de dados em NoSQL

Prova de conceito para determinar a influência da estratégia de modelagem dos
dados no armazenamento e processamento de consultas em banco de dados NoSQL
baseado no modelo famílias de colunas.

##O experimento

Com objetivo de validar as tecnicas de armazenamento em NoSQl foi criado uma
base de dados relacional e um conjunto de consultas, esta base de dados e
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

* **Simples**: Consulto em apenas uma tabela com filtros simples.
* **Media**: Consulta com dois relacionamentos ou com agregação em uma única tabela.
* **Complexa**: Consultas com dois relacionamentos e agregação.
* **Muito Complexa**: Consultas com mais de dois relacionamentos com agregação.

## Modelagem de dados


### Conceito

* Normalização
* Desnormalização
* Agragados


### Derivação do conceito

* Atomic aggregates
* Dimensionality reduction
* Index table
* Composite key index
* Aggregation with composite key index
* Inverted Search – direct aggregation

Fonte:

##Notas

* O uso do relacional é orientado principalmente a "Quais respostas você tem?"
* Em NoSQL seu uso é guiado  por: "Quais perguntas você tem?"

## Desnormalização

Desnormalização pode ser definida como copiar o mesmo dado em mutiplas tabelas
ou documentos com objetivo de simplificar/otimizar o processamento de consultas.

###Vantagens

* Em geral todos os dados necessario para uma query estão no mesmo local
* Diminui a complexidade dos joins

###Desvantagens

* A duplicidade dos dados aumenta expresivamente o volume total de dados.
* Necessidade de atualização dos dados redundantes.

##Agregados

###Vantagens

* Minimização de relacionamentos  one-to-many por meio de entidades aninhadas e,
conseqüentemente, redução de junções.
* Esconde as diferenças entre a modelagem dos dados e modelagem das entidades de negócio de uma aplicação.

###Desvantagens

* Aumento da complexidade e tempo de processamento para fazer ataulizalções dos agragados.


##Application-side Joins

Permite emular parcialemte uma base de dados relacional, implementando os joins.

###Vantagens

* Mantem a normalização

###Desvantagens

* É necessario executar consultas extras para conseguir joins.


##Agredados atômicos

Armazenar os dados de acrodo com entidades do negócio.

Vantagens: Suporte parcial a transações, MVCC
Desvantagens:


##Tabela de Indice

Criar e manter uma tabela chaves que permitem acesso a um conjunto de dados.


iantagens: redução do numero de querys em joins
Desvantagens: Tabela de indice deve ser atualizada junto com a tabela master.
Isso implica perda de performance e consistência.


# Prova de Conceito

Exemplo conceitual de um sistema de controle de vendas.

Um Empresa tem um conjunto de lojas a qual cada uma possui um gerente e
um conjunto de vendedores e produtos.

Selecionar clientes por loja
Selecionar vendedores de uma loja
Selecionar produtos comprados e

Selecionar quais os produtos mais vendidos
