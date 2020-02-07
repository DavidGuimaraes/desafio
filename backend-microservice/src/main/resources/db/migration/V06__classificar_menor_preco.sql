-- Para que fosse possível efetuar novos testes, alguns scripts de povoação foram rodados diretamente
-- no banco para agilizar. O intuito dessa nova povoação do banco de dados foi ter mais dados de propostas
-- de tipo NOTA_PRECO para que testes pudessem ser feitos. Os scripts abaixo não serão executados novamente,
-- apenas ficaraão registrados aqui para referência

--INSERT INTO proposta (nota, preco, data_cadastro, classificacao, licitacao_id, data_ultima_edicao)
--VALUES (6.5, 250, CURRENT_DATE, NULL, 9, NULL);

--INSERT INTO proposta (nota, preco, data_cadastro, classificacao, licitacao_id, data_ultima_edicao)
--VALUES (7.0, 200, CURRENT_DATE, NULL, 9, NULL);

--INSERT INTO proposta (nota, preco, data_cadastro, classificacao, licitacao_id, data_ultima_edicao)
--VALUES (7.5, 150, CURRENT_DATE, NULL, 9, NULL);

--INSERT INTO proposta (nota, preco, data_cadastro, classificacao, licitacao_id, data_ultima_edicao)
--VALUES (8.5, 100, CURRENT_DATE, NULL, 9, NULL);

CREATE OR REPLACE FUNCTION sortPropostasTipoMenorPreco()
	RETURNS TRIGGER AS $$
DECLARE
	--r PROPOSTA%ROWTYPE;
	r RECORD;
	count INTEGER := 0;
BEGIN
	--SELECT INTO class1 *
	FOR r IN SELECT *
						FROM proposta prop
						LEFT JOIN licitacao lic ON lic.licitacao_id = prop.licitacao_id
						WHERE lic.tipo_classificacao = 'MENOR_PRECO'
						ORDER BY
								prop.preco ASC,
								prop.data_cadastro ASC
	LOOP
		count := count + 1;
		UPDATE PROPOSTA
			SET classificacao = count WHERE proposta_id = r.proposta_id;
	END LOOP;
	--RETURN NEXT class1;
RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER trigger_sortPropostasTipoMenorPreco
AFTER INSERT ON proposta
FOR EACH ROW
EXECUTE PROCEDURE sortPropostasTipoMenorPreco();