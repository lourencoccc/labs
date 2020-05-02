--Modelo relacional

/*
Sistema de Vendas

Relação de produtos, vendedores, clientes, loja e vendas.
Uma venda tem um ou mais produtos, um vendedor. Uma loja tem um ou mais
vendedores.
*/

--create database vendas;

DROP TABLE IF EXISTS venda_produto;
DROP TABLE IF EXISTS venda;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS produto;
DROP TABLE IF EXISTS vendedor;
DROP TABLE IF EXISTS loja;

create table loja(
    id integer,
    nome varchar(255)
);

create table vendedor(
    id integer,
    nome varchar(255),
    cpf varchar(11),
    loja_id integer
);

create table produto(
    id integer,
    nome varchar(255)
);

create table cliente(
    id integer,
    cpf varchar(11),
    nome varchar(255),
    email varchar(255)
);

create table venda(
    id integer,
    vendedor_id integer,
    cliente_id integer,
    data timestamp
);

create table venda_produto(
    venda_id integer,
    produto_id integer,
    quantidade integer,
    valor_unidade numeric(19,2)
);

--primary keys
alter table loja add constraint pk_loja primary key (id);
alter table vendedor add constraint pk_vendedor primary key (id);
alter table produto add constraint pk_produto primary key (id);
alter table cliente add constraint pk_cliente primary key (id);
alter table venda add constraint pk_venda primary key (id);
alter table venda_produto add constraint pk_venda_produto primary key (venda_id, produto_id);

--foreign key
alter table vendedor add constraint fk_vendedor_loja foreign key (loja_id) references loja (id);
alter table venda add constraint fk_venda_vendedor foreign key (vendedor_id) references vendedor (id);
alter table venda add constraint fk_venda_cliente foreign key (cliente_id) references cliente (id);
alter table venda_produto add constraint fk_venda_produto_venda foreign key (venda_id) references venda (id);
alter table venda_produto add constraint fk_venda_produto_produto foreign key (produto_id) references produto (id);

--unique
alter table vendedor add constraint uq_venedor_cpf unique (cpf);
alter table cliente add constraint uq_cliente_cpf unique (cpf);
alter table loja add constraint uq_loja_nome unique (nome);
alter table produto add constraint uq_produto_nome unique (nome);
