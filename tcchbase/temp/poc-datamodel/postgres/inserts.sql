--Modelo relacional

/*
Sistema de Vendas

Relação de produtos, vendedores, clientes, loja e vendas.
Uma venda tem um ou mais produtos, um vendedor. Uma loja tem um ou mais
vendedores.

Quais os produtos de uma venda?
Quais o vendedores de uma loja?
Quis os nomes dos clientes?
Quais o produtos mais vendidos?

*/

delete from venda_produto;
delete from venda;
delete from cliente;
delete from produto;
delete from vendedor;
delete from loja;

--lojas
insert into loja values (1, 'Fortaleza');
insert into loja values (2, 'Iguatu');

--vendedores
insert into vendedor values (1, 'João', '03215237849', 1);
insert into vendedor values (2, 'Jully', '34745135670', 1);
insert into vendedor values (3, 'Heitor', '62641425572', 2);
insert into vendedor values (4, 'Rose', '28476291493', 2);

--clientes
insert into cliente values (1, '33660454427','Moises', 'moises@email.com');
insert into cliente values (2, '18737341740','Cicero', 'cicero@email.com');
insert into cliente values (3, '23174124280','Ivanilda', 'ivanilda@email.com');
insert into cliente values (4, '25965562276', 'Joana',  'joana@email.com');
insert into cliente values (5, '30741376652', 'Silvana', 'silvana@email.com');
insert into cliente values (6, '90376573112', 'Alexandre', 'alexandre@email.com');
insert into cliente values (7, '77577730084', 'Luan', 'luan@email.com');
insert into cliente values (8, '35308654867', 'Alice', 'alice@email.com');
insert into cliente values (9, '61097686264', 'Eduardo', 'eduardo@email.com');
insert into cliente values (10, '27750542183', 'Junior', 'junior@email.com');

--vendas
--loja 1, vendedor 1
insert into venda values (1, 1, 3, '2015-11-10 10:00');
insert into venda values (2, 1, 4, '2015-11-10 13:00');
insert into venda values (3, 1, 3, '2015-11-11 17:00');
--loja 1, vendedor 2
insert into venda values (4, 2, 5, '2015-11-10 09:00');
--loja 2, vendedor 3
insert into venda values (5, 3, 8, '2015-11-10 14:00');
insert into venda values (6, 3, 9, '2015-11-10 16:00');
--loja 2, vendedor 4
insert into venda values (7, 4, 7, '2015-11-10 10:00');
insert into venda values (8, 4, 3, '2015-11-10 12:00');
insert into venda values (9, 4, 6, '2015-11-10 14:00');
insert into venda values (10, 4, 2, '2015-11-10 17:00');

--produtos
insert into produto values (1, 'monitor');
insert into produto values (2, 'desktop');
insert into produto values (3, 'notebook');
insert into produto values (4, 'impressora');
insert into produto values (5, 'mouse');
insert into produto values (6, 'pendrive');
insert into produto values (7, 'sdcard');
insert into produto values (8, 'teclado');
insert into produto values (9, 'smartphone');
insert into produto values (10, 'webcam');

--produtos da venda
--loja 1, vendedor 1, venda 1,2,3
insert into venda_produto values (1, 1, 2, 395.99);
insert into venda_produto values (2, 5, 1, 59.00);
insert into venda_produto values (3, 7, 3, 35.50);
insert into venda_produto values (3, 9, 1, 600.00);
--loja 1, vendedor 2, venda 4
insert into venda_produto values (4, 6, 2, 35.50);
insert into venda_produto values (4, 10, 1, 88.00);
insert into venda_produto values (4, 8, 1, 120.00);
--loja 2, vendedor 3, venda 5,6
insert into venda_produto values (5, 6, 1, 35.50);
insert into venda_produto values (5, 3, 1, 1250.90);
insert into venda_produto values (6, 4, 2, 346.00);
insert into venda_produto values (6, 9, 1, 600.00);
--loja 2, vendedor 4, venda 7,8,9,10
insert into venda_produto values (7, 2, 1, 900.90);
insert into venda_produto values (7, 1, 1, 350.90);
insert into venda_produto values (7, 5, 1, 50.00);
insert into venda_produto values (8, 6, 1, 600.00);
insert into venda_produto values (8, 4, 2, 28.00);
insert into venda_produto values (9, 7, 3, 35.50);
insert into venda_produto values (9, 8, 2, 112.00);
insert into venda_produto values (10, 4, 1, 346.00);
