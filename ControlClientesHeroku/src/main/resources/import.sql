INSERT INTO personas (nombre, apellido, email, telefono,saldo) VALUES('Alejandro', 'Muñoz', 'aleja@mail.com',5552123123,5000);
INSERT INTO personas (nombre, apellido, email, telefono,saldo) VALUES('Mario', 'Díaz', 'mariod@gmail.com',55512345678,5000);
INSERT INTO personas (nombre, apellido, email, telefono,saldo) VALUES('Fernando', 'Hernandez', 'fernandoh@mail.com',552434331231,5000);



/* tabla usuarios */
INSERT INTO usuarios (username,password) VALUES('admin','$2a$10$y/2CuURPg70./d0OnOmwkehQzPrrGhpBdi4jZf4e17olNolFmS4Lu');
INSERT INTO usuarios(username,password) VALUES('user','$2a$10$ehH22NbxXpuYrsmF/KXtCugLIsuF7DC8sqVXloGsVRqfOwQX/gC0O');

/*Roles*/
INSERT INTO roles(id_usuario,nombre) VALUES(1,'ROLE_USER');
INSERT INTO roles(id_usuario,nombre) VALUES(1,'ROLE_ADMIN');
INSERT INTO roles(id_usuario,nombre) VALUES(2,'ROLE_USER');