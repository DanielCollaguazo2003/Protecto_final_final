CREATE SEQUENCE roles_codigo_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;

INSERT INTO vt_roles VALUES(roles_codigo_seq.nextval, 'Administrador', 'Encargado de la gestión y administración de la clínica veterinaria');
INSERT INTO vt_roles VALUES(roles_codigo_seq.nextval, 'General', 'Encargado de la facturación, creación y actualizar datos de los clientes');



CREATE SEQUENCE personas_codigo_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;

INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0312628383','Daniel', 'Collaguazo', 'Racar','Camino al cebollar','0936729158','dcollaguazo@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0125257363','Paul', 'Sigua', 'Guangarcucho','Autopista','0956829425','pasigua@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0303128672','Jeison', 'Pañora', 'Déleg','Via sigsipamba','0933628482','jpanora@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0167384638','Anthony', 'Moya', 'Totoracocha','Ave Los Andes','0973583581','anmoya@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0183675828','Luis','Aguirre','Sab Blas','Calle Larga','0973827592','lsaguirre@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0185258683','Juan','Alvarado','El sagrario','Calle Pio Bravo','0983683728','jalvarado@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0183628745','Belen','Collaguazo','Racar','Rosendo Lopez Díaz','0965274618','lcollaguazo@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0173548353','Fernanda','Cordero','El Batan','Av. Gral. Escandón','0972718349','frcordero@gmail.com');

SELECT * FROM VT_PERSONAS;

CREATE SEQUENCE empleados_codigo_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;


INSERT INTO vt_empleados VALUES (empleados_codigo_seq.nextval,'C',1,1);
INSERT INTO vt_empleados VALUES (empleados_codigo_seq.nextval,'V',4,null);
INSERT INTO vt_empleados VALUES (empleados_codigo_seq.nextval,'C',2,2);
INSERT INTO vt_empleados VALUES (empleados_codigo_seq.nextval,'V',3,null);

SELECT * FROM VT_EMPLEADOS;


CREATE SEQUENCE clientes_codigo_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;

INSERT INTO vt_clientes VALUES (clientes_codigo_seq.nextval,'A',7);
INSERT INTO vt_clientes VALUES (clientes_codigo_seq.nextval,'I',5);
INSERT INTO vt_clientes VALUES (clientes_codigo_seq.nextval,'A',8);
INSERT INTO vt_clientes VALUES (clientes_codigo_seq.nextval,'A',6);




CREATE SEQUENCE tipos_mascotas_codigo_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;

INSERT INTO vt_tipos_mascotas VALUES (tipos_mascotas_codigo_seq.nextval,'Perro');
INSERT INTO vt_tipos_mascotas VALUES (tipos_mascotas_codigo_seq.nextval,'Gato');
INSERT INTO vt_tipos_mascotas VALUES (tipos_mascotas_codigo_seq.nextval,'Roedor');
INSERT INTO vt_tipos_mascotas VALUES (tipos_mascotas_codigo_seq.nextval,'Ave');
INSERT INTO vt_tipos_mascotas VALUES (tipos_mascotas_codigo_seq.nextval,'Reptil');
INSERT INTO vt_tipos_mascotas VALUES (tipos_mascotas_codigo_seq.nextval,'Pez');

CREATE SEQUENCE mascotas_codigo_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;

INSERT INTO vt_mascotas VALUES (mascotas_codigo_seq.nextval,'Max',1); 
INSERT INTO vt_mascotas VALUES (mascotas_codigo_seq.nextval,'Luna',3);
INSERT INTO vt_mascotas VALUES (mascotas_codigo_seq.nextval,'Jack',2);
INSERT INTO vt_mascotas VALUES (mascotas_codigo_seq.nextval,'Duke',5);
INSERT INTO vt_mascotas VALUES (mascotas_codigo_seq.nextval,'Milo',4);
INSERT INTO vt_mascotas VALUES (mascotas_codigo_seq.nextval,'Rocky',4);
INSERT INTO vt_mascotas VALUES (mascotas_codigo_seq.nextval,'Lily',6);
INSERT INTO vt_mascotas VALUES (mascotas_codigo_seq.nextval,'Coco',1);

SELECT * FROM vt_clientes;



CREATE SEQUENCE citas_codigo_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;

INSERT INTO vt_citas VALUES (citas_codigo_seq.nextval,TO_DATE('2023-07-13', 'YYYY-MM-DD'),'A',2,4,5);
INSERT INTO vt_citas VALUES (citas_codigo_seq.nextval,TO_DATE('2020-05-20', 'YYYY-MM-DD'),'I',4,2,8);
INSERT INTO vt_citas VALUES (citas_codigo_seq.nextval,TO_DATE('2023-06-25', 'YYYY-MM-DD'),'A',2,2,3);
INSERT INTO vt_citas VALUES (citas_codigo_seq.nextval,TO_DATE('2023-08-13', 'YYYY-MM-DD'),'A',4,3,6);
INSERT INTO vt_citas VALUES (citas_codigo_seq.nextval,TO_DATE('2023-07-25', 'YYYY-MM-DD'),'I',2,1,4);
INSERT INTO vt_citas VALUES (citas_codigo_seq.nextval,TO_DATE('2023-08-01', 'YYYY-MM-DD'),'A',2,3,2);




CREATE SEQUENCE permisos_codigo_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;

INSERT INTO vt_permisos VALUES (permisos_codigo_seq.nextval,'Facturar','Encargado de la Facturacion de la veterinaria',1);
<<<<<<< HEAD
INSERT INTO vt_permisos VALUES (permisos_codigo_seq.nextval,'Registrar','Encargado de registrar nuevos clientes',2);
INSERT INTO vt_permisos VALUES (permisos_codigo_seq.nextval,'Actualizar','Encargado de actualizar los datos de los clientes',2);
=======
INSERT INTO vt_permisos VALUES (permisos_codigo_seq.nextval,'Registrar','Encargado de registrar nuevos clientes',3);
INSERT INTO vt_permisos VALUES (permisos_codigo_seq.nextval,'Actualizar','Encargado de actualizar los datos de los clientes',3);

<<<<<<< HEAD
SELECT * FROM vt_usu
>>>>>>> 332b233ecc7a6601a982dd059cff17ef98e70a2d

INSERT INTO vt_usuarios_sistema VALUES (1,'Sigua123','Sigua123',3);
=======
SELECT * FROM vt_personas;
SELECT * FROM vt_empleados;
SELECT * FROM vt_usuarios_sistema;

SELECT * FROM vt_usuarios_sistema;

INSERT INTO vt_usuarios_sistema VALUES(2, 'DanielCollaguazo','Collaguazo123',1);

COMMIT;
>>>>>>> c8b8d198eda2d97335e5ae35f6d861b1a2429509
