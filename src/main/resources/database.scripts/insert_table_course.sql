
delete from tb_courses ;

delete from tb_modules ;

delete from tb_lessons ;

-----------------------------------------------------------

INSERT INTO public.tb_courses
(course_id, user_instructor, course_level, course_status, creation_date, description, image_url, last_update, "name")
VALUES('30a3245e-e2f7-4d55-a324-5ee2f74d5536', '2c08e6da-6b8d-45e9-88e6-da6b8df5e90d', 'BEGINNER', 'INPROGRESS', NOW(),
       'Curso administracao muito legal', 'https://localhost/images/1', NOW(), 'Curso de ADM');

INSERT INTO public.tb_courses
(course_id, user_instructor, course_level, course_status, creation_date, description, image_url, last_update, "name")
VALUES('f8a4b0a0-a2aa-48e2-a4b0-a0a2aa58e2a3', '8dbb0938-ab80-40af-bb09-38ab8090af97', 'INTERMEDIARY', 'INPROGRESS', NOW(),
       'Curso Mecanico muito legal', 'https://localhost/images/2', NOW(), 'Curso de MECANICO');

INSERT INTO public.tb_courses
(course_id, user_instructor, course_level, course_status, creation_date, description, image_url, last_update, "name")
VALUES('3bf98714-4a98-40c0-b987-144a9820c0d4', '960634c9-af43-4b9d-8634-c9af43fb9d57', 'INTERMEDIARY', 'CONCLUDED', NOW(),
       'Curso medicina muito legal', 'https://localhost/images/3', NOW(), 'Curso de MEDICINA');

INSERT INTO public.tb_courses
(course_id, user_instructor, course_level, course_status, creation_date, description, image_url, last_update, "name")
VALUES('9ab1ed25-7d3b-4d93-b1ed-257d3b0d93f1', '2c08e6da-6b8d-45e9-88e6-da6b8df5e90d', 'ADVANCED', 'INPROGRESS', NOW(),
       'Curso administracao muito mais avançado', 'https://localhost/images/4', NOW(), 'Curso de ADM AVANÇADO');

