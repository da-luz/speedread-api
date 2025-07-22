INSERT INTO users (name, email) VALUES ('Damned sinner', 'human@filthy.earth');

INSERT INTO books (user_id, name, state) VALUES (1, 'Solus Christus', 'SHELVED'), (1, 'Sola gratia', 'FINISHED'), (1, 'Sola scriptura', 'FINISHED'), (1, 'Sola fide', 'SHELVED'), (1, 'Soli Deo Gloria', 'SHELVED'), (1, 'The devil', 'FINISHED');

INSERT INTO sprints (id, user_id, book_id, state, starting, finishing) VALUES (1, 1, 5, 'FINISHED', '2025-07-22 02:05:07.717459+00', '2025-07-22 02:08:23.424228+00'), (2, 1, 5, 'FINISHED', '2025-07-22 02:08:28.162926+00', '2025-07-22 02:09:13.47252+00');
