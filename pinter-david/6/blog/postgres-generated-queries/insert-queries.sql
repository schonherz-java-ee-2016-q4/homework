--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.1

-- Started on 2017-01-03 23:29:29

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET search_path = blog_app, pg_catalog;

--
-- TOC entry 2183 (class 0 OID 16506)
-- Dependencies: 203
-- Data for Name: users; Type: TABLE DATA; Schema: blog_app; Owner: postgres
--

COPY users (id, gender, title_name, first_name, last_name, date_of_birth, email, small_pic_url, medium_pic_url, large_pic_url, nationality, state_name, city, street, post_code, user_name, pass, register_date) FROM stdin;
1	male	Mr	Test	User	1990-10-03	test@test.com	https://randomuser.me/api/portraits/thumb/men/11.jpg	https://randomuser.me/api/portraits/med/men/11.jpg	https://randomuser.me/api/portraits/men/11.jpg	GB	London	London	32 Rochester road	44231	test1	pass	2017-01-01
2	male	Mr	Test	User	1990-10-03	test@test.com	https://randomuser.me/api/portraits/thumb/men/11.jpg	https://randomuser.me/api/portraits/med/men/11.jpg	https://randomuser.me/api/portraits/men/11.jpg	GB	London	London	32 Rochester road	44231	test2	pass2	2017-01-01
\.


-- Completed on 2017-01-03 23:29:30

--
-- PostgreSQL database dump complete
--

