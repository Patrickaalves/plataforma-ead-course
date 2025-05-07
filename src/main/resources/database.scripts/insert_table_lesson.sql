delete from tb_courses ;

delete from tb_modules ;

delete from tb_lessons ;

-----------------------------------------------------------

-- Modulo Financas - Curso ADM

INSERT INTO public.tb_lessons (lesson_id, creation_date, description, title, video_url, module_module_id)
VALUES('ba8e08c7-0aa0-4588-8e08-c70aa0f58829', NOW(), 'liçao 1', 'titulo 1', 'http://localhost/video1', '9ab1ed25-7d3b-4d93-b1ed-257d3b0d93f1');

INSERT INTO public.tb_lessons (lesson_id, creation_date, description, title, video_url, module_module_id)
VALUES('2464dc46-109f-4ae2-a4dc-46109f2ae20a', NOW(), 'liçao 2', 'titulo 2', 'http://localhost/video2', '9ab1ed25-7d3b-4d93-b1ed-257d3b0d93f1');

INSERT INTO public.tb_lessons (lesson_id, creation_date, description, title, video_url, module_module_id)
VALUES('17d584e5-cb6f-4a2a-9584-e5cb6f4a2a62', NOW(), 'liçao 3', 'titulo 3', 'http://localhost/video3', '9ab1ed25-7d3b-4d93-b1ed-257d3b0d93f1');

