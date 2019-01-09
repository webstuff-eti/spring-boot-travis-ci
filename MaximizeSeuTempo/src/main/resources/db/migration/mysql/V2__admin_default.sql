INSERT INTO maximize.empresa (	id, 
                                cnpj, 
								data_atualizacao, 
								data_criacao, 
								razao_social)
VALUES                     (	NULL, 
								"33637290000138", 
								CURRENT_DATE(), 
								CURRENT_DATE(), 
								"Web Stuff"
							);

INSERT INTO funcionario (	id, 
							cpf, 
							data_atualizacao, 
							data_criacao, 
							email, 
							nome, 
							perfil, 
							qtd_horas_almoco, 
							qtd_horas_trabalho_dia, 
							senha, 
							valor_hora, 
							empresa_id) 
VALUES 					(	NULL, 
							"20134865022", 
							CURRENT_DATE(), 
							CURRENT_DATE(), 
							"tibaestiago@gmail.com", 
							"ADMIN", 
							"ROLE_ADMIN", 
							NULL, 
							NULL, 
							"$2a$10$wwilphUbeUJUEDwvAlL.leRnhBFA8jUsmz7rSFYOpIUUQU9Fqlii.", 
							NULL, 
							(SELECT id FROM `empresa` WHERE cnpj = "33637290000138")
						);