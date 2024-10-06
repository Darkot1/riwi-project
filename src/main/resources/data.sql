CREATE DATABASE taskdb;

INSERT INTO users (username, email, password, role, enabled)
VALUES ('admin', 'admin@example.com', '$2a$12$pILmO8FJXZ7H//IRveRC1u9hVai.8.RiASrgmgm86NL3Ar9xlfyyG', 'ADMIN', true);
