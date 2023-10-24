INSERT INTO role (name, permission_create, permission_update, permission_delete) VALUES ('admin', true, true, true);
INSERT INTO role (name, permission_create, permission_update, permission_delete) VALUES ('viewer', false, false, false);
INSERT INTO role (name, permission_create, permission_update, permission_delete) VALUES ('user', false, true, false);

INSERT INTO users (name, user_name, password, age, role_id) VALUES ('Administrator', 'admin', '$2a$10$NRQfwftsX2hHFGmvUeA26.YMGgvDR/kNk660Snwh8G93khvnTwUqG', 0, 1);
INSERT INTO users (name, user_name, password, age, role_id) VALUES ('Viewer', 'viewer', '$2a$10$vEsHp/Z8/ooVaN0xOLb76eXRPIlbZrqg3xvUJR9FufnRTJvuSIqZe', 0, 2);
INSERT INTO users (name, user_name, password, age, role_id) VALUES ('User', 'user', '$2a$10$pA..qv9IpqKIm0.kp0m2Me4YGYeOyjbXGXzyAjZJmBlAiSmi3zaqa', 0, 3);
