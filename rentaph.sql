CREATE USER rentaph IDENTIFIED BY rentaph;
ALTER SESSION SET CURRENT_SCHEMA = rentaph;
GRANT ALL PRIVILEGES TO rentaph;

DROP TABLE landlord;

CREATE TABLE landlord (
    id NUMBER(19) PRIMARY KEY,
    name varchar(50) DEFAULT NULL,
    mobile_number NUMBER(19)DEFAULT NULL,
    email varchar(50) DEFAULT NULL
);

drop sequence landlord_seq;

  
INSERT INTO landlord 
 SELECT 1,'Mark Bryan', 09701547100, 'mark@gmail.com' FROM dual
 UNION ALL
 SELECT 2,'Moises', 09701547101, 'moises@gmail.com' FROM dual
 UNION ALL
 SELECT 3,'Edmark', 09701547102, 'edmark@gmail.com' FROM dual;


DROP TABLE property;

CREATE TABLE property (

    id NUMBER(19) PRIMARY KEY,
    landlord_id NUMBER(19),
    FOREIGN KEY (landlord_id) REFERENCES rentaph.landlord (id),
    image_url varchar(255) DEFAULT NULL,
    property_name varchar(255) DEFAULT NULL,
    property_address varchar(500) DEFAULT NULL,
    property_type varchar(45) DEFAULT NULL,
    area_in_feet NUMBER(19)DEFAULT NULL,
    bed_capacity  NUMBER(19)DEFAULT NULL,
    price NUMBER(19),
    availability NUMBER(1),
    description varchar(2000)
);


INSERT INTO property 
 SELECT 1, 1, '','Mark Bryan''s Place', 'Brgy. Udia, Cavinti, Laguna', 
        'House',108,10, 5000, 1, 'A very quite place' FROM dual
 UNION ALL
 SELECT 2, 1, '','Alder Residences', 'Acacia Ave, Acacia Estates, Taguig, Metro Manila, Philippines', 
        'Condominium',25,1, 15000, 1, 'A very quite place' FROM dual
 UNION ALL 
 SELECT 3, 2, '','The Fort Condo Rental', 'H23V+6J3, Burgos Cir, Taguig, 1632 Metro Manila, Philippines', 
        'Condominium',100,2, 24000, 1, 'Fort Condo is designed to be your handy resource of properties in Fort Bonifacio. Experience quality service and results through Fort Condo as we dedicate our extensive track record in providing you premier real estate needs. Let our expertise in Real Estate of more than a decade conveniently link you to your dream property.' FROM dual;


drop sequence property_seq;

CREATE SEQUENCE property_seq
  START WITH 4
  INCREMENT BY 1
  CACHE 100;



DROP TABLE inquiry;

CREATE TABLE inquiry (
    id NUMBER(19) PRIMARY KEY,
    landlord_id NUMBER(19), 
    FOREIGN KEY (landlord_id) REFERENCES rentaph.landlord (id) ,
    property_id NUMBER(19), 
    FOREIGN KEY (property_id) REFERENCES rentaph.property (id) ,
    name varchar(50) DEFAULT NULL,
    mobile_number NUMBER(19)DEFAULT NULL,
    email varchar(50) DEFAULT NULL,
    message varchar(255)
);

drop sequence inquiry_seq;


CREATE SEQUENCE inquiry_seq
  START WITH 1
  INCREMENT BY 1
  CACHE 100;

