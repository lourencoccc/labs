# HBase - Anotações

## Objetivo

1. Introdução ao HBase
2. Arquitetura do HBase
3. API nativa de comunicação
4. Tutorial de como iniciar com o HBase

## Inrodução ao HBase

HBase é um banco de dados do Hadoop, frequentemente descrito como um Map
ordenado e persisitente, multidimensionado, destribuido e esparço.

## Tutorial basico

### 1. Download HBase

Obter \ ultima versão estavel, no caso a 1.2.5 disponivel em 22/02/2017.

      wget http://ftp.unicamp.br/pub/apache/hbase/1.2.6/hbase-1.2.6-bin.tar.gz
      taz -zxvf [arquivo].tar.gz       

### 2. Configurar varaivel de ambiente JAVA_HOME com JDK 1.8

### 3. Editar arquivo /hbase-1.2.6/conf/hbase-site.xml

Este é o arquivo de configuração principal, para versão standalone, é necessario
apenas apontar o diretorio onde o HBase e ZooKeeper devem escrever os dados. Por
default um novo diretorio é criado em /tmp.

Exemplo:

    <configuration>
      <property>
         <name>hbase.rootdir</name>
         <value>file:///home/lourenco/hbase</value>
      </property>
      <property>
        <name>hbase.zookeeper.property.dataDir</name>
        <value>/home/lourenco/zookeeper</value>
      </property>
    </configuration>

### 4. Iniciando HBase

O arquivo bin/start-hbase.sh prove uma forma conveniente de iniciar o serviço

    bin/start-hbase.sh

Veja estado do servidor em http://localhost:16010/

### 5. Primeiros comandos

O Apache Hbase Shell é um ferramante para execução de comandos sobre o HBase,
sendo uma abastração da API de comunicação naitva.

Para acesso rapido e processos sem necessidade performatica o HBase Shell
é muito util.

* Iniciar HBase Shell 

    bin/hbase shell

* Criar tabela

    create 'usuario', 'sistema1'

Adicionar nova colunm familly

        alter 'usuario', 'sistema2'

* Inserir dados


        put 'usuario', 'joao', 'sistema1:nome', 'João Lourenço'
        put 'usuario', 'joao', 'sistema1:email', 'joao@mail.com'

        put 'usuario', 'joao', 'sistema2:nome', 'João Souza'
        put 'usuario', 'joao', 'sistema2:email', 'souza@mail.com'

        put 'usuario', 'rose', 'sistema1:nome', 'Roselena'
        put 'usuario', 'rose', 'sistema1:email', 'rose@mail.com'


* Ler dados

        scan 'usuario'
        get 'usuario', 'joao'

* Atualizar dados


* Ativar/Desativar tabela

        disable 'usuario'
        enable 'usuario'

* Apagar tabela

        drop 'usuario'

## Filtros

import org.apache.hadoop.hbase.filter.CompareFilter
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter
import org.apache.hadoop.hbase.filter.SubstringComparator
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.filter.BinaryComparator

scan 'test2', { FILTER => SingleColumnValueFilter.new(Bytes.toBytes('ls'), 
Bytes.toBytes('a'), CompareFilter::CompareOp.valueOf('EQUAL'), 
BinaryComparator.new(Bytes.toBytes('Joao')))}

scan 'post', { FILTER => SingleColumnValueFilter.new(Bytes.toBytes('ph'), 
Bytes.toBytes('type'), CompareFilter::CompareOp.valueOf('EQUAL'), 
BinaryComparator.new(Bytes.toBytes('close')))}


# Under the hood

'

# Instalação totalmente destribuida

Fully-distributed só funciona com HDFS

# Instalação hadoop

http://archive.apache.org/dist/hadoop/common/hadoop-2.5.1/

http://archive.apache.org/dist/hadoop/common/hadoop-2.5.1/hadoop-2.5.1.tar.gz
