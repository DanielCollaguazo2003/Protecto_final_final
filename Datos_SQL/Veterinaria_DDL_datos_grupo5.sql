CREATE SEQUENCE roles_cod_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;

INSERT INTO vt_roles VALUES(roles_cod_seq.nextval, 'Administrador', 'Encargado de la gesti�n y administraci�n de la cl�nica veterinaria');
INSERT INTO vt_roles VALUES(roles_cod_seq.nextval, 'General', 'Encargado de la facturaci�n, creaci�n y actualizar datos de los clientes');



CREATE SEQUENCE personas_codigo_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;

INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0312628383','Daniel', 'Collaguazo', 'Racar','Camino al cebollar','0936729158','dcollaguazo@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0125257363','Paul', 'Sigua', 'Guangarcucho','Autopista','0956829425','pasigua@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0303128672','Jeison', 'Pa�ora', 'D�leg','Via sigsipamba','0933628482','jpanora@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0167384638','Anthony', 'Moya', 'Totoracocha','Ave Los Andes','0973583581','anmoya@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0183675828','Luis','Aguirre','Sab Blas','Calle Larga','0973827592','lsaguirre@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0185258683','Juan','Alvarado','El sagrario','Calle Pio Bravo','0983683728','jalvarado@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0183628745','Belen','Collaguazo','Racar','Rosendo Lopez D�az','0965274618','lcollaguazo@gmail.com');
INSERT INTO vt_personas VALUES (personas_codigo_seq.nextval,'0173548353','Fernanda','Cordero','El Batan','Av. Gral. Escand�n','0972718349','frcordero@gmail.com');

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


CREATE SEQUENCE citas_codigo_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;

INSERT INTO vt_citas VALUES (citas_codigo_seq.nextval,TO_DATE('2023-07-13', 'YYYY-MM-DD'),'A',2,4,5);
INSERT INTO vt_citas VALUES (citas_codigo_seq.nextval,TO_DATE('2020-05-20', 'YYYY-MM-DD'),'I',4,2,3);
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
INSERT INTO vt_permisos VALUES (permisos_codigo_seq.nextval,'Registrar','Encargado de registrar nuevos clientes',2);
INSERT INTO vt_permisos VALUES (permisos_codigo_seq.nextval,'Actualizar','Encargado de actualizar los datos de los clientes',2);
INSERT INTO vt_permisos VALUES (permisos_codigo_seq.nextval,'Registrar','Encargado de registrar nuevos clientes',2);
INSERT INTO vt_permisos VALUES (permisos_codigo_seq.nextval,'Actualizar','Encargado de actualizar los datos de los clientes',2);
INSERT INTO vt_permisos VALUES (permisos_codigo_seq.nextval,'Registrar','Encargado de registrar nuevos clientes',3);
INSERT INTO vt_permisos VALUES (permisos_codigo_seq.nextval,'Actualizar','Encargado de actualizar los datos de los clientes',3);


SELECT * FROM vt_permisos;


INSERT INTO vt_usuarios_sistema VALUES (1,'Sigua123','Sigua123',3);

SELECT *  FROM vt_usuarios_sistema;

COMMIT;

SELECT * FROM vt_servicios;

CREATE SEQUENCE ser_codigo_seq 
START WITH 1
MAXVALUE 99999
INCREMENT BY 1
NOCACHE;

INSERT INTO vt_servicios VALUES(ser_codigo_seq.nextval, 'Consulta medica general','El servicio ofrece una evaluacion y diagnostico de salud general de la mascota', 25.0, 'S');
INSERT INTO vt_servicios VALUES(ser_codigo_seq.nextval, 'Vacunaci�n de rutina', 'El servicio ofrece la vacunaci�n de administraci�n contra enfermedades comunes en las mascotas, incluye todas las vacunas', 30.50, 'S');
INSERT INTO vt_servicios VALUES(ser_codigo_seq.nextval, 'Ex�menes m�dicos', 'El servicio ofrece la realizaci�n de ex�menes de an�lisis y pruebas para detectar problemas de salud se realiza ex�menes completos, como resonancias.', 60.0, 'S');
INSERT INTO vt_servicios VALUES(ser_codigo_seq.nextval, 'Cirug�a de castraci�n', 'El servicio ofrece un cirug�a de castraci�n completa, adem�s de la cirug�a se le a�adir� sus respectivas medicinas', 150.45, 'N');
 INSERT INTO vt_servicios VALUES(ser_codigo_seq.nextval, 'Cirug�a ortop�dica', 'El servicio ofrece cirug�a ortop�dica adem�s de sus an�lisis y medicamentos correspondientes', 200.65, 'N');
 INSERT INTO vt_servicios VALUES(ser_codigo_seq.nextval, 'Atenci�n de emergencia', 'El servicio ofrece servicio de atenci�n inmediata luego de un accidente con una atenci�n inmediata', 100.15, 'N');
 INSERT INTO vt_servicios VALUES(ser_codigo_seq.nextval, 'Control de par�sitos',  'El servicio ofrece un control de tratamiento y prevenci�n derivadas de los da�os que provocan pulgas, garrapatas, gusanos u otros', 10.0, 'N');
 INSERT INTO vt_servicios VALUES(ser_codigo_seq.nextval, 'Control de peso y nutrici�n', 'El servicio ofrece un asesoramiento para mantener un peso saludable con una alimentaci�n adecuada en la mascota', 15.0, 'N');
 
 SELECT * FROM vt_clientes c, vt_personas p WHERE (c.per_codigo=p.per_codigo) AND (c.cli_estado='A');
 
 select * from vt_empleados e, vt_personas p, vt_roles r WHERE (e.per_codigo=p.per_codigo) AND (r.rol_codigo(+)=e.rol_codigo);
