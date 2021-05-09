--
-- PostgreSQL database dump
--

-- Dumped from database version 11.6
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- Name: kullanici; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.kullanici (
    "kullaniciID" integer NOT NULL,
    "kullaniciAdi" character varying(2044) NOT NULL,
    "kullaniciSifre" character varying(2044) NOT NULL
);


ALTER TABLE public.kullanici OWNER TO postgres;

--
-- Data for Name: kullanici; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.kullanici VALUES (1, 'admin', '1234');
INSERT INTO public.kullanici VALUES (2, 'kullanci', 'kullanici');


--
-- Name: kullanici kullanici_kullaniciID_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanici
    ADD CONSTRAINT "kullanici_kullaniciID_key" UNIQUE ("kullaniciID");


--
-- Name: index_kullaniciID; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX "index_kullaniciID" ON public.kullanici USING btree ("kullaniciID");


--
-- PostgreSQL database dump complete
--

