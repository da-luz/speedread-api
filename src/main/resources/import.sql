INSERT INTO users (name, email) VALUES ('Damned sinner', 'human@filthy.earth');

INSERT INTO books (user_id, name, state) VALUES (1, 'Solus Christus', 'SHELVED'), (1, 'Sola gratia', 'FINISHED'), (1, 'Sola scriptura', 'FINISHED'), (1, 'Sola fide', 'SHELVED'), (1, 'Soli Deo Gloria', 'SHELVED'), (1, 'The devil', 'FINISHED');

INSERT INTO sprints (id, user_id, book_id, state, starting, finishing, elapsed_time) VALUES (1, 1, 5, 'FINISHED', '2025-07-22 02:05:00.000000+00', '2025-07-22 02:08:00.000000+00', 180), (2, 1, 5, 'FINISHED', '2025-07-22 02:08:00.000000+00', '2025-07-22 02:09:00.000000+00', 60);
