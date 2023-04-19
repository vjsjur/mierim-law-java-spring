--Insert inicial
--SIS_COMPANY_GROUP
INSERT INTO public.sis_company_group(
	id_tenant, deletado, dominio, grupo_economico, nome)
	VALUES (10, '2', 'mierim.com.br', 'MIERÍM', 'MIERIM');

--SIS_COMPANY_EMPRESA
INSERT INTO public.sis_company_empresa(
	id_tenant_company, bairro, cep, complemento, cpf_cnpj, deletado, email, logradouro,  nome_emp, nome_fant, numero, telefone, id_tenant, id_pais, id_uf, id_municipio)
	VALUES (10, 'Barra Funda', '03572020', '12º Andar', '0000000', '2', 'contato.mierim.com.br', 'Marquês de São Vicente',  'Mierím Tec', 'Mierím Tec', '12', '20123989', 10, 'Brasil', 'SP', 1);

--SIS_COMPANY_FILIAL
INSERT INTO public.sis_company_filial(
	id_tenant_filial, bairro, cep, complemento, cpf_cnpj, deletado, email, logradouro,  nome_emp, nome_fant, numero, telefone,  id_tenant, id_tenant_company, id_pais, id_uf, id_municipio)
	VALUES (10, 'Barra Funda', '23572020', '12º Andar', '0000000', '2', 'contato@mierim.com.br', 'Marquês de São Vicente', 'Mierím SP','Mierím SP', '12', '20139898',  10,10,  'Brasil', 'SP', 1);

--SIS_USUARIO
INSERT INTO public.sis_usuario(
	id, ativo, bloqueado, celular, e_mail, nivel_visao_campo, palavra_passe, senha, tentativas, usuario, usuario_ad, id_tenant, id_tenant_company, id_tenant_filial)
	VALUES (2, true, 'N', '1198787979', 'vagner.santos@mierim.com.br', '10', 'sãapaulo', 'teste', 1, 'vjdsantos', 'vagner.santos', 10, 10, 10);

--SIS_USUARIO_COMPLEMENTO
INSERT INTO sis_usuario_complemento
(grau_permissao, usuario_ad, id, id_tenant)
VALUES('', '', 1, 10);

INSERT INTO sis_usuario_complemento
(grau_permissao, usuario_ad, id, id_tenant)
VALUES('', '', 2, 10);

/*** AVALIAR/REVISAR PARECEM SER TABELAS ANTIGAS ***/
--usuario, USUARIO_PROFESSOR , cad_pais *** AVALIAR/REVISAR *** 
INSERT INTO usuario
(ativo, email, email_bkp, login, nivel_visao_campo, nome, senha, id_tenant, id_tenant_company, id_tenant_filial)
VALUES(false, '', '', '', 0, '', '', 10, 10, 10);

INSERT INTO usuario_professor
(grau_intrucao, usuario_ad, id, id_tenant)
VALUES('', '', 1, 10);

INSERT INTO cad_pais
(id, codigo, descricao, descricao_formal)
VALUES(1058, '1058 novo', '', '');


--CAD_AREA_JURIDICA
INSERT INTO public.cad_area_juridica(
	id, codigo, data_alteracao, data_inclusao, deletado, descricao,  status, tecnico, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (1, 'TRAB', '2023-02-26',  '2023-02-26', '2', 'Trabalhista', 'A', 'N', 10, 10 , 10, 1,1);

INSERT INTO public.cad_area_juridica(
	id, codigo, data_alteracao, data_inclusao, deletado, descricao,  status, tecnico, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (2, 'TRIB', '2023-02-26',  '2023-02-26', '2', 'Tributária', 'A', 'N', 10, 10 , 10, 1,1);

INSERT INTO public.cad_area_juridica(
	id, codigo, data_alteracao, data_inclusao, deletado, descricao,  status, tecnico, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (3, 'CIV', '2023-02-26',  '2023-02-26', '2', 'Cível', 'A', 'N', 10, 10 , 10, 1,1);
	
INSERT INTO public.cad_area_juridica(
	id, codigo, data_alteracao, data_inclusao, deletado, descricao,  status, tecnico, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (4, 'CONST', '2023-02-26',  '2023-02-26', '2', 'Contitucional', 'A', 'N', 10, 10 , 10, 1,1);
	
INSERT INTO public.cad_area_juridica(
	id, codigo, data_alteracao, data_inclusao, deletado, descricao,  status, tecnico, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (5, 'PREV', '2023-02-26',  '2023-02-26', '2', 'Previdenciário', 'A', 'N', 10, 10 , 10, 1,1);	

--cad_profissional_cargo
INSERT INTO public.cad_profissional_cargo(
	id, deletado, descricao, status, tecnico, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (1, '2', 'Advogado JR I', 'A', 'S', '2021-12-21', '2021-12-21', 10, 10, 10, 1, 1);

INSERT INTO public.cad_profissional_cargo(
	id, deletado, descricao, status, tecnico, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (2, '2', 'Advogado JR II', 'A', 'S', '2021-12-21', '2021-12-21', 10, 10, 10, 1, 1);

INSERT INTO public.cad_profissional_cargo(
	id, deletado, descricao, status, tecnico, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (3, '2', 'Advogado JR III', 'A', 'S', '2021-12-21', '2021-12-21', 10, 10, 10, 1, 1);

INSERT INTO public.cad_profissional_cargo(
	id, deletado, descricao, status, tecnico, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (4, '2', 'Advogado PL I', 'A', 'S', '2021-12-21', '2021-12-21', 10, 10, 10, 1, 1);

INSERT INTO public.cad_profissional_cargo(
	id, deletado, descricao, status, tecnico, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (5, '2', 'Advogado PL II', 'A', 'S', '2021-12-21', '2021-12-21', 10, 10, 10, 1, 1);

INSERT INTO public.cad_profissional_cargo(
	id, deletado, descricao, status, tecnico, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (6, '2', 'Advogado PL III', 'A', 'S', '2021-12-21', '2021-12-21', 10, 10, 10, 1, 1);

--CAtegoria
INSERT INTO public.cad_categoria(
	id, assina_fat, data_alteracao, data_inclusao, deletado, descricao, meta_horas_dia, status, tecnico, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao)
	VALUES (1, 'S', '2023-02-21', '2023-02-21', '2', 'Advogado JR I', 8, 'A', 'S', 10, 10, 10, 1);

INSERT INTO public.cad_categoria(
	id, assina_fat, data_alteracao, data_inclusao, deletado, descricao, meta_horas_dia, status, tecnico, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao)
	VALUES (2, 'S', '2023-02-21', '2023-02-21', '2', 'Advogado JR II', 8, 'A', 'S', 10, 10, 10, 1);


INSERT INTO public.cad_categoria(
	id, assina_fat, data_alteracao, data_inclusao, deletado, descricao, meta_horas_dia, status, tecnico, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao)
	VALUES (3, 'S', '2023-02-21', '2023-02-21', '2', 'Advogado JR III', 8, 'A', 'S', 10, 10, 10, 1);

INSERT INTO public.cad_categoria(
	id, assina_fat, data_alteracao, data_inclusao, deletado, descricao, meta_horas_dia, status, tecnico, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao)
	VALUES (4, 'S', '2023-02-21', '2023-02-21', '2', 'Advogado PL I', 8, 'A', 'S', 10, 10, 10, 1);

INSERT INTO public.cad_categoria(
	id, assina_fat, data_alteracao, data_inclusao, deletado, descricao, meta_horas_dia, status, tecnico, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao)
	VALUES (5, 'S', '2023-02-21', '2023-02-21', '2', 'Advogado PL II', 8, 'A', 'S', 10, 10, 10, 1);

INSERT INTO public.cad_categoria(
	id, assina_fat, data_alteracao, data_inclusao, deletado, descricao, meta_horas_dia, status, tecnico, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao)
	VALUES (6, 'S', '2023-02-21', '2023-02-21', '2', 'Advogado PL III', 8, 'A', 'S', 10, 10, 10, 1);


--ESCRITÓRIO
INSERT INTO public.cad_escritorio(
	id, bairro, cep, cnpj, codigo, complemento, data_alteracao, data_inclusao, deletado, dt_cadastro, emite_fat, emite_nfe, emite_nfse, logradouro, nome,  razao, status,id_municipio, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusao)
	VALUES (1, 'Jardim São Paulo', '03929010', '0000000', 'SP', 'Andar', '2011-08-01', '2011-08-01', '2', '2011-08-01', 'S', 'N', 'S', 'AV Oratório', 'Mierím',  'Mierím', 'A', 1, 10, 10, 10, 1, 1);


/*** AVALIAR/REVISAR SE REALMENTE PRECISA, TEM RERÊNCIA PARA ESTA TABELA ***/
-- Centro de Custo *** AVALIAR/REVISAR ***
INSERT INTO cad_centro_custo
(id, classe, codigo, condicao, deletado, descricao, saldo, status, id_escritorio, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, id_usuario_inclusão)
VALUES(3,'', '3', '', '', '', 0, '', 1, '2022-01-01', '2022-01-01', 10, 10, 10, 1, 1);


--Departamento
INSERT INTO public.cad_departamento(
	id, deletado, descricao, status, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, "id_usuario_inclusão")
	VALUES (1, '2', 'Jurídico', 'A', '2021-10-01', '2021-10-01', 10, 10, 10, 1, 1);

INSERT INTO public.cad_departamento(
	id, deletado, descricao, status, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, "id_usuario_inclusão")
	VALUES (2, '2', 'Financeiro', 'A', '2021-10-01', '2021-10-01', 10, 10, 10, 1, 1);

INSERT INTO public.cad_departamento(
	id, deletado, descricao, status, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, "id_usuario_inclusão")
	VALUES (3, '2', 'Faturamento', 'A', '2021-10-01', '2021-10-01', 10, 10, 10, 1, 1);

INSERT INTO public.cad_departamento(
	id, deletado, descricao, status, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, "id_usuario_inclusão")
	VALUES (4, '2', 'Tecnologia', 'A', '2021-10-01', '2021-10-01', 10, 10, 10, 1, 1);

INSERT INTO public.cad_departamento(
	id, deletado, descricao, status, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, "id_usuario_inclusão")
	VALUES (5, '2', 'Recursos Humanos', 'A', '2021-10-01', '2021-10-01', 10, 10, 10, 1, 1);

INSERT INTO public.cad_departamento(
	id, deletado, descricao, status, data_alteracao, data_inclusao, id_tenant, id_tenant_company, id_tenant_filial, id_usuario_alteracao, "id_usuario_inclusão")
	VALUES (6, '1', 'RH', 'A', '2021-10-01', '2021-10-01', 10, 10, 10, 1, 1);
	

--Profissional
INSERT INTO public.cad_profissional(
	id, 	altera_caso_encerrado, 	altera_lanc_prefatura, 	altera_pos_corte, apelido, bairro,carteira_trabalho, 	celular, cep, complemento, cpf, data_admissao, 
	data_demissao, data_nascimento, deletado, Email, endereco, excluir_pos_corte, id_pais, id_uf,inclui_pos_corte, juiz, nome, nome_social, numero, part_distribuicao, 
	participa_rateio_despesa, pis, revisor_faturamento, rg, sexo, sigla, socio, status, tecnico,telefone, tempo_disponivel, tipo, id_cargo, id_categoria, 
	id_centro_custo, id_departamento, id_escritorio, id_municipio, id_tenant, id_tenant_company,id_tenant_filial,  data_alteracao, data_inclusao, id_usuario, 
	id_usuario_alteracao, id_usuario_inclusão)
	VALUES 
	(22,'S','S','S','DSS','Centro','36478','11978789887','03220030','04039020','28367394877','2000-05-28','2000-05-28','2000-05-28','2','meuemail@teste.com.br',
'Av Limeira Grande','S','1058','SP','S','N','Joaquin Bento','Joaquin Bento','67','S','S','287987','S','7674687267','M','JBE','S','A','S','119878755',8,
2,4,3,3,1,1,1,10,10,10,'2000-01-21', '2000-01-21',1, 1, 1	);


/*** AVALIAR/REVISAR NÃO CONSEGUI INSERIR ***/
/*
INSERT INTO public.cad_profissional(
	id, 	altera_caso_encerrado, 	altera_lanc_prefatura, 	altera_pos_corte, apelido, bairro,carteira_trabalho, 	celular, cep, complemento, cpf, data_admissao, 
	data_demissao, data_nascimento, deletado, Email, endereco, excluir_pos_corte, id_pais, id_uf,inclui_pos_corte, juiz, nome, nome_social, numero, part_distribuicao, 
	participa_rateio_despesa, pis, revisor_faturamento, rg, sexo, sigla, socio, status, tecnico,telefone, tempo_disponivel, tipo, id_cargo, id_categoria, 
	id_centro_custo, id_departamento, id_escritorio, id_municipio, id_tenant, id_tenant_company,id_tenant_filial,  data_alteracao, data_inclusao, id_usuario, 
	id_usuario_alteracao, id_usuario_inclusão)
	VALUES 
	(24,'S','S','S','MCL','Centro','36478','11978789887','03220030','04039020','28367394877','2000-05-28','2000-05-28','2000-05-28','2','meuemail@teste.com.br',
'Av Limeira Grande','S',1058,'SP','S','N','Maria Clara','Maria Clara','67','S','S','287987','S','7674687267','M','ABC','S','A','S','119878755',8,
2,4,3,3,1,1,1,10,10,10,'2000-01-21', '2000-01-21',1, 1, 1	);
*/