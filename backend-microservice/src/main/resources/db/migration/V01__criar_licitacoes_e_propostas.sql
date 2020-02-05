CREATE TYPE tipo_classificacao AS ENUM('MENOR_PRECO', 'NOTA_PRECO');

CREATE SEQUENCE public.licitacao_licitacao_id_seq;

CREATE TABLE public.licitacao (
                licitacao_id BIGINT NOT NULL DEFAULT nextval('public.licitacao_licitacao_id_seq'),
                descricao VARCHAR(100) NOT NULL,
                tipo_classificacao tipo_classificacao NOT NULL,
                data_cadastro DATE NOT NULL,
                data_ultima_edicao DATE,
                CONSTRAINT licitacao_pk PRIMARY KEY (licitacao_id)
);


ALTER SEQUENCE public.licitacao_licitacao_id_seq OWNED BY public.licitacao.licitacao_id;

CREATE SEQUENCE public.proposta_proposta_id_seq;

CREATE TABLE public.proposta (
                proposta_id BIGINT NOT NULL DEFAULT nextval('public.proposta_proposta_id_seq'),
                nota NUMERIC,
                preco NUMERIC NOT NULL,
                data_cadastro DATE NOT NULL,
                classificacao INTEGER,
                licitacao_id BIGINT NOT NULL,
                data_ultima_edicao DATE,
                CONSTRAINT proposta_pk PRIMARY KEY (proposta_id)
);


ALTER SEQUENCE public.proposta_proposta_id_seq OWNED BY public.proposta.proposta_id;

ALTER TABLE public.proposta ADD CONSTRAINT licitacao_proposta_fk
FOREIGN KEY (licitacao_id)
REFERENCES public.licitacao (licitacao_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;