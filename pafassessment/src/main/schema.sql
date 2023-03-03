drop database if exists acme_bank;

create database acme_bank;

use acme_bank;

create table accounts (
	id int not null primary key auto_increment,
	account_id varchar(10) not null,
    first_name varchar(50) not null,
    balance decimal(16,2) not null);
    
-- LOAD DATA LOCAL INFILE 'path/to/your/csv/file.csv' INTO TABLE your_table_name FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n' IGNORE 1 ROWS;

-- COPY accounts(account_id, name, balance)
-- FROM 'data.csv' DELIMITER ',' CSV HEADER;

grant all privileges on acme_bank.* to 'chuk'@'%';

flush privileges;