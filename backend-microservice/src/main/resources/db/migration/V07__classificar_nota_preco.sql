CREATE OR REPLACE FUNCTION sortPropostasTipoNotaPreco()
	RETURNS TRIGGER AS $$
DECLARE
	r RECORD;
	count INTEGER := 0;
BEGIN
	FOR r IN SELECT *
						FROM proposta prop
						LEFT JOIN licitacao lic ON lic.licitacao_id = prop.licitacao_id
						WHERE lic.tipo_classificacao = 'NOTA_PRECO'
						ORDER BY
								prop.nota DESC,
								prop.preco ASC,
								prop.data_cadastro ASC
	LOOP
		count := count + 1;
		UPDATE PROPOSTA
			SET classificacao = count WHERE proposta_id = r.proposta_id;
	END LOOP;
RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER trigger_sortPropostasTipoNotaPreco
AFTER INSERT ON proposta
FOR EACH ROW
EXECUTE PROCEDURE sortPropostasTipoNotaPreco();