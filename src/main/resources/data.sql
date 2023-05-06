/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  1513003
 * Created: 2 de mai. de 2023
 */

INSERT INTO professor (id, nome, email) VALUES
(1, 'Nicholas', 'nicholas.santos@ifms.edu.br'),
(2, 'Laurentino', 'laurentino.dantas@ifms.edu.br');

ALTER SEQUENCE professor_seq RESTART WITH 3;

INSERT INTO campus (id, nome, created_at) VALUES
(1, 'Campus Navira�', now()),
(2, 'Reitoria', now());

ALTER SEQUENCE campus_sequence RESTART WITH 3;