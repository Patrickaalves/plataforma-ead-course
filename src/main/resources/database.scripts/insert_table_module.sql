delete from tb_courses ;

delete from tb_modules ;

delete from tb_lessons ;

-----------------------------------------------------------

-- Curos ADM

INSERT INTO public.tb_modules (module_id, creation_date, description, title, course_course_id)
VALUES('9ab1ed25-7d3b-4d93-b1ed-257d3b0d93f1', NOW(), 'Modulo de finanças onde voce vai...', 'Modulo de FINANÇAS' ,'30a3245e-e2f7-4d55-a324-5ee2f74d5536');

INSERT INTO public.tb_modules (module_id, creation_date, description, title, course_course_id)
VALUES('5d3e6d2f-dcb8-497b-be6d-2fdcb8d97ba6', NOW(), 'Modulo de contabilidade onde voce vai...', 'Modulo de CONTABILIDADE' ,'30a3245e-e2f7-4d55-a324-5ee2f74d5536');

INSERT INTO public.tb_modules (module_id, creation_date, description, title, course_course_id)
VALUES('ee0ca396-b6d6-4b0f-8ca3-96b6d62b0f57', NOW(), 'Modulo de valores onde voce vai...', 'Modulo de VALORES' ,'30a3245e-e2f7-4d55-a324-5ee2f74d5536');

INSERT INTO public.tb_modules (module_id, creation_date, description, title, course_course_id)
VALUES('17761f9a-2019-4dd2-b61f-9a20199dd2f1', NOW(), 'Modulo de RH onde voce vai...', 'Modulo de RH' ,'30a3245e-e2f7-4d55-a324-5ee2f74d5536');

INSERT INTO public.tb_modules (module_id, creation_date, description, title, course_course_id)
VALUES('031273cd-8a6a-47eb-9273-cd8a6a97ebd7', NOW(), 'Modulo de tesouraria onde voce vai...', 'Modulo de TESOURARIA' ,'30a3245e-e2f7-4d55-a324-5ee2f74d5536');

-- Curos Mecanico

INSERT INTO public.tb_modules (module_id, creation_date, description, title, course_course_id)
VALUES('4557a8db-2116-4109-97a8-db2116f10974', NOW(), 'Modulo de peças onde voce vai...', 'Modulo de PEÇAS' ,'f8a4b0a0-a2aa-48e2-a4b0-a0a2aa58e2a3');

INSERT INTO public.tb_modules (module_id, creation_date, description, title, course_course_id)
VALUES('122eb955-48a6-4548-aeb9-5548a6f54828', NOW(), 'Modulo de tinta onde voce vai...', 'Modulo de TINTA' ,'f8a4b0a0-a2aa-48e2-a4b0-a0a2aa58e2a3');

-- Curos Medicina

INSERT INTO public.tb_modules (module_id, creation_date, description, title, course_course_id)
VALUES('7b986239-0f01-4413-9862-390f0194135c', NOW(), 'Modulo de corpo humano onde voce vai...', 'Modulo de PEÇAS' ,'3bf98714-4a98-40c0-b987-144a9820c0d4');

INSERT INTO public.tb_modules (module_id, creation_date, description, title, course_course_id)
VALUES('cd042d30-5f82-4fd0-842d-305f82dfd012', NOW(), 'Modulo de vasos onde voce vai...', 'Modulo de TINTA' ,'3bf98714-4a98-40c0-b987-144a9820c0d4');

-- Curos ADM avançado

INSERT INTO public.tb_modules (module_id, creation_date, description, title, course_course_id)
VALUES('6a82fdc6-2bea-4dac-82fd-c62beacdac91', NOW(), 'Modulo de contabilidade avançado onde voce vai...', 'Modulo de CONTABILIDADE AVAN' ,'9ab1ed25-7d3b-4d93-b1ed-257d3b0d93f1');

INSERT INTO public.tb_modules (module_id, creation_date, description, title, course_course_id)
VALUES('c1d6eb78-de9c-482e-96eb-78de9cd82e9d', NOW(), 'Modulo de contas avançado demais voce vai...', 'Modulo de CONTAS AVAN' ,'9ab1ed25-7d3b-4d93-b1ed-257d3b0d93f1');
