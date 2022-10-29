use db_agenciaViagens;

insert into tblDestinos(destinos_nome, destinos_estado, destinos_pais, destinos_dataIda, destinos_dataVolta, destinos_valor) values ("Fulana","PE","Brasil", "03/11/22", "13/11/22", "130,00");
select * from tblDestinos;

										
insert into Cliente(cliente_nome,cliente_CPF,cliente_dataNascimento, cliente_telefone, cliente_email) values ("ppppp","ppppppppp", "pppppppp", "aaaaaaa", "aaaaaa");
select * from tblCliente;

select c.cliente_nome, c.cliente_cpf, c.cliente_dataNascimento, cliente_telefone, cliente_email, c.id, d.destinos_estado, d.destinos_pais, d.destinos_dataIda, d.destinos_dataVolta
from Destinos as d
inner join Cliente as  c
on c.id = d.id;
 

	