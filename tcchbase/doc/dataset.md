#Análise de base de dados

Levantamento de base de dados disponiveis para estudo.

## Opções de base dados

### Opção 1 - Stack Exchange Data Dump

Todo o conteúdo gerado por usuários da rede Stack Exchange dese 2009. Cada local é formatado como um arquivo separado que consiste em arquivos XML compactados via 7-zip usando compressão bzip2. Cada arquivo de site inclui Posts, Usuários, votos, comentários, PostHistory e PostLinks.

* Tamanho: aprox. 40G.
* Formato: arquivos em formato xml.
* Dicionario de dados bem definido.

Fonte: https://archive.org/details/stackexchange


### Opção 2 - Google Books Ngrams

Relação de ocorrecias nos google books digitalizados.

* Tamanho: aprox. 2T
* Formato: texto tabulado por TAB.
    ngram TAB year TAB match_count TAB volume_count NEWLINE

Exemplo de dados extraidos do arquivo  googlebooks-eng-all-5gram-20120701-c_

        C series circuit can be		1950	1	1
        C series circuit can be		1964	5	5
        C series circuit can be		1969	1	1
        C series circuit can be		1970	1	1

Fonte: http://storage.googleapis.com/books/ngrams/books/datasetsv2.html

### Opção 3 - Wiki Database Downaload

Fonte: https://www.wikidata.org/wiki/Wikidata:Database_download
Tamanho: ~ 100G

### Opção 4 - Paginas da Web

Fonte: http://commoncrawl.org/the-data/get-started/

decisão de

tempo de pos processamento -> gravar e atualizar

Tempo de  

## Resultado da analise das opções

A fonte de dados escolhida é a opção 1.  Stack Exchange Data Dump.

Novo tema da monografia: Influência da estratégia de armazenamento de dados no armazenamento e processamento de consultas em banco de dados NoSQL baseado no modelo famílias de colunas.

Fonte de inspiração: http://www.ebaytechblog.com/2012/07/16/cassandra-data-modeling-best-practices-part-1/
