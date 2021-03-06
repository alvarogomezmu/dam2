1.Crear un metodo (proc o func) que muestre a las empleadas que ganen un sueldo superior a 1.000€ y 
que hayan (o no) realizado repartos del articulo pasado por parametro.

2.Crear un metodo (proc o func) que muestre el nombre de las categorias que no tengan ningun articulo asociado.

CREATE TABLE CATEGORIAS (	
       COD_CAT        INTEGER      	NOT NULL PRIMARY KEY,
       NOMBRE         CHAR(15)   	NOT NULL
);


CREATE TABLE ARTICULOS (
       COD_ART        CHAR(8)        NOT NULL PRIMARY KEY,
       DESCRIPCION    CHAR(20)   	NOT NULL,
       CANTIDAD       INTEGER      CHECK (CANTIDAD>0),
       PRECIO         INTEGER      CHECK (PRECIO>0),
      COD_CAT         INTEGER      REFERENCES CATEGORIAS(COD_CAT)
);


CREATE TABLE EMPLEADOS (
       COD_EMP        INTEGER      NOT NULL PRIMARY KEY,
       NOMBRE         CHAR(20)        NOT NULL,
       APELLIDOS      CHAR(30)        NOT NULL,
       SEXO           CHAR(1)         CHECK (SEXO IN('H','M')),
       SUELDO         INTEGER      CHECK (SUELDO>0)
);  


CREATE TABLE CLIENTES (
       COD_CLI        INTEGER      	NOT NULL PRIMARY KEY,
       LOCAL          CHAR(25)   	NOT NULL,
       NOMBRE         CHAR(25)   	NOT NULL,
       DOMICILIO      CHAR(30)	 	NOT NULL,
       LOCALIDAD      CHAR(30)
);


CREATE TABLE REPARTO(
COD_CLI INTEGER NOT NULL,
COD_ART CHAR(8) NOT NULL,
COD_EMP INTEGER NOT NULL,
CANTIDAD INTEGER CHECK(CANTIDAD>0),
PRIMARY KEY (COD_CLI,COD_ART,COD_EMP),
FOREIGN KEY (COD_EMP) REFERENCES EMPLEADOS(COD_EMP) on delete cascade,
FOREIGN KEY (COD_CLI) REFERENCES CLIENTES(COD_CLI) on delete cascade,
FOREIGN KEY (COD_ART) REFERENCES ARTICULOS(COD_ART) on delete cascade
);





INSERT INTO CATEGORIAS VALUES ( 1,'BEBIDAS');
INSERT INTO CATEGORIAS VALUES ( 2,'DULCES');
INSERT INTO CATEGORIAS VALUES ( 3,'LACTEOS');
INSERT INTO CATEGORIAS VALUES ( 4,'CONSERVAS');
INSERT INTO CATEGORIAS VALUES ( 5,'CHARCU');
INSERT INTO CATEGORIAS VALUES ( 6,'PESCADERIA');

INSERT INTO ARTICULOS VALUES ( 'B-LIC-01','RON BACARDI', 20,50,1);
INSERT INTO ARTICULOS VALUES ( 'B-LIC-02','GINEBRA LARIOS', 15,30,1);
INSERT INTO ARTICULOS VALUES ( 'B-LIC-03','WHISKY', 30,40,1);
INSERT INTO ARTICULOS VALUES ( 'D-GLL-01','GALLETAS CHOC', 50,5,null);
INSERT INTO ARTICULOS VALUES ( 'D-GLL-02','GALLETAS NATAS', 30,4,2);
INSERT INTO ARTICULOS VALUES ( 'D-GLL-03','GALLETAS LIMON', 10,2,2);
INSERT INTO ARTICULOS VALUES ( 'L-LEC-01','LECHE CLOSA', 30,1,3);
INSERT INTO ARTICULOS VALUES ( 'L-LEC-02','LECHE POLSA', 20,1,3);
INSERT INTO ARTICULOS VALUES ( 'C-PES-01','SARDINAS', 20,6,null);
INSERT INTO ARTICULOS VALUES ( 'C-PES-02','MEJILLONES', 20,2,null);


INSERT INTO EMPLEADOS VALUES (1,'JULIO','IGLESIAS SANCHEZ','H',30000);
INSERT INTO EMPLEADOS VALUES (2,'ALFONSO','LOPEZ ABRIL','H',40000);
INSERT INTO EMPLEADOS VALUES (3,'MONICA','GUANTERS MAS','M',35000);
INSERT INTO EMPLEADOS VALUES (4,'ANA MARIA','SALINERO PEREZ','M',20000);
INSERT INTO EMPLEADOS VALUES (5,'HERMINIA','GOMEZ MAESO','M',50000);
INSERT INTO EMPLEADOS VALUES (6,'JAIME','WALKER LOPEZ','H',19000);
INSERT INTO EMPLEADOS VALUES (7,'SARA','WALKER LOPEZ','M',19000);
INSERT INTO EMPLEADOS VALUES (8,'SONIA','WALKER LOPEZ','M',19000);


INSERT INTO CLIENTES VALUES (1,'BAR SARCUS','SEVERINO SEMOS','RITMO MUSICAL 23','PELAYOS DE LA PRESA');
INSERT INTO CLIENTES VALUES (2,'BODEGA POZO','MANUEL CABEZON','DIONISIO PINILLO 3','PELAYOS DE LA PRESA');
INSERT INTO CLIENTES VALUES (3,'CLUB FAROLES','ENRIQUETA PON','VEREDA DEL RIO','NAVAS DEL REY');
INSERT INTO CLIENTES VALUES (4,'BAR PACO','PACO OKUPA','COOPERATIVA 2','VILLA DEL PRADO');
INSERT INTO CLIENTES VALUES (5,'PUB STUDIO','JUAN SUPER LOPEZ','LAS CASAS 3','PANTANO DE SAN JUAN');

INSERT INTO REPARTO VALUES (1,'B-LIC-01',2,3);
INSERT INTO REPARTO VALUES (2,'B-LIC-02',3,40);
INSERT INTO REPARTO VALUES (1,'L-LEC-01',1,100);
INSERT INTO REPARTO VALUES (3,'C-PES-02',5,30);


