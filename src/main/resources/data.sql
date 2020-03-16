INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('AR','ARGENTINA', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('BR','BRASIL', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('UY','URUGUAY', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);

INSERT INTO country (iso_code, name, creation_timestamp, modification_timestamp, version_number) 
VALUES ('CH','CHILE', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1);


INSERT INTO ACCOUNT_TYPE (creation_timestamp, modification_timestamp, version_number, account_type_currency, account_type_description, account_type_discovered) 
VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1, 'USD', 'Dollars', 300);

INSERT INTO ACCOUNT_TYPE (creation_timestamp, modification_timestamp, version_number, account_type_currency, account_type_description, account_type_discovered) 
VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1, '€', 'Euros', 150);

INSERT INTO ACCOUNT_TYPE (creation_timestamp, modification_timestamp, version_number, account_type_currency, account_type_description, account_type_discovered) 
VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1, '$', 'Pesos', 1000);



INSERT INTO ACCOUNT (creation_timestamp, modification_timestamp, version_number, account_balance, account_number, account_type_id) 
VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1,100, 130444 , 1);

INSERT INTO ACCOUNT (creation_timestamp, modification_timestamp, version_number, account_balance, account_number, account_type_id) 
VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1,250, 240159 , 2);

INSERT INTO ACCOUNT (creation_timestamp, modification_timestamp, version_number, account_balance, account_number, account_type_id) 
VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1,555, 480129 , 3);



INSERT INTO MOVEMENT (creation_timestamp, modification_timestamp, version_number, movement_amount, movement_date, movement_description, movement_type, account_id) 
VALUES (CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(), 1,300,CURRENT_TIMESTAMP() ,'Varios', 'Debit', 1);