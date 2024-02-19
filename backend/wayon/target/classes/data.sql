CREATE TABLE Users (
    id  UUID DEFAULT RANDOM_UUID() NOT NULL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    account BIGINT,
    amount BIGINT,
    userkey SMALLINT
);

CREATE TABLE Transactions (
    id  INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    sender_id UUID NOT NULL,
    receiver_id UUID NOT NULL,
    amount BIGINT,
    fee FLOAT NOT NULL,
    actual_date datetime DEFAULT  CURRENT_TIMESTAMP,
    desired_date datetime not null,
    text VARCHAR(50),
    aproved BOOLEAN

);

INSERT INTO Users ( id,name,account,amount,userkey) VALUES ( 'fa8dbb11-8635-4a33-8957-cb7e0e30eeb7','CARLOS',123456789012,111111111111,1234);
INSERT INTO Users ( id,name,account,amount,userkey) VALUES ( '7ec92ada-9080-4958-af54-33b07edc3db1','PEDRO',123456789013,111111111111,1235);
INSERT INTO Users ( name,account,amount,userkey) VALUES ( 'ANTONIO',123456789014,111111111111,1236);
INSERT INTO Users ( name,account,amount,userkey) VALUES ( 'MARIA',123456789015,111111111111,1237);
INSERT INTO Users ( name,account,amount,userkey) VALUES ( 'JUAN',123456789016,111111111111,1238);
INSERT INTO Users ( name,account,amount,userkey) VALUES ( 'SOFIA',123456789017,111111111111,1239);



INSERT INTO Transactions ( sender_id,receiver_id,amount,fee,desired_date,text,aproved)
VALUES (
'fa8dbb11-8635-4a33-8957-cb7e0e30eeb7',
'7ec92ada-9080-4958-af54-33b07edc3db1',
'123123',
'15',
'2020-12-04',
'regular text',
true
);

INSERT INTO Transactions ( sender_id,receiver_id,amount,fee,desired_date,text,aproved)
VALUES (
'fa8dbb11-8635-4a33-8957-cb7e0e30eeb7',
'7ec92ada-9080-4958-af54-33b07edc3db1',
'123123',
14,
'2020-12-05',
'regular text',
true
);

INSERT INTO Transactions ( sender_id,receiver_id,amount,fee,desired_date,text,aproved)
VALUES (
'fa8dbb11-8635-4a33-8957-cb7e0e30eeb7',
'7ec92ada-9080-4958-af54-33b07edc3db1',
'123123',
23,
'2020-12-06',
'regular text',
true
);

