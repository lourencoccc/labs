/*

Relação de produtos, vendedores, clientes, loja e vendas.
Uma venda tem um ou mais produtos, um vendedor. Uma loja tem um ou mais
vendedores.

Selecionar um cliente
Selecionar os vendedores de uma loja.
Selecionar produtos comprados de um cliente.
Selecionar os produtos mais vendidos.

*/

--Selecionar um cliente
select * from cliente where nome = 'Joana';

--Selecionar os vendedores de uma loja
select l.nome as loja, v.nome, v.cpf
from loja l inner join vendedor v on  l.id = v.loja_id
where l.nome = 'Fortaleza';

--Selecionar produtos comprados de um cliente.
select venda_id, p.nome
from venda v inner join cliente c on v.cliente_id = c.id
inner join venda_produto vp on vp.venda_id = v.id
inner join produto p on p.id = vp.produto_id
where c.nome = 'Ivanilda';

--Selecionar os produtos mais vendidos.
select vp.produto_id, sum(quantidade) as quantidade from venda_produto vp
group by vp.produto_id order by quantidade desc;

select vp.produto_id, p.nome, sum(quantidade) as quantidade from venda_produto vp
inner join produto p on p.id = vp.produto_id
group by vp.produto_id, p.nome
order by quantidade desc;
