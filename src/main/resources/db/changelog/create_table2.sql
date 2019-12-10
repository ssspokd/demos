-- Table: public.poll

- DROP TABLE public.poll;
/
CREATE TABLE public.poll
(
    id numeric NOT NULL,
    namepoll character varying(255) NOT NULL,
    startdate date,
    enddate date,
    isactive boolean,
    CONSTRAINT poll_pkey PRIMARY KEY (id)
)
    WITH (
        OIDS=FALSE
    );
ALTER TABLE public.poll
    OWNER TO postgres;


-- Table: public.pollquestion

-- DROP TABLE public.pollquestion;

CREATE TABLE public.pollquestion
(
    idpoll numeric NOT NULL,
    textpoll text NOT NULL,
    pubmissionorder numeric NOT NULL,
    poll_id numeric,
    id numeric,
    CONSTRAINT "secondKeyIDPoll" FOREIGN KEY (idpoll)
        REFERENCES public.poll (id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
)
    WITH (
        OIDS=FALSE
    );
ALTER TABLE public.pollquestion
    OWNER TO postgres;

-- Index: public."fki_secondKeyIDPoll"

-- DROP INDEX public."fki_secondKeyIDPoll";

CREATE INDEX "fki_secondKeyIDPoll"
    ON public.pollquestion
        USING btree
        (idpoll);

