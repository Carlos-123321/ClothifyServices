USE `designer-db`;

create table if not exists customer_phonenumbers (
    customer_id INTEGER,
    type VARCHAR(50),
    number VARCHAR(50)
    );

create table if not exists customers (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_id VARCHAR(36) UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email_address VARCHAR(50),
    street_address VARCHAR (50),
    city VARCHAR (50),
    province VARCHAR (50),
    country VARCHAR (50),
    postal_code VARCHAR (9)
    );


create table if not exists department_positions (
    department_id INTEGER,
    title VARCHAR(50),
    code VARCHAR(50)
);

create table if not exists departments (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    department_id VARCHAR(36) UNIQUE,
    name VARCHAR(50),
    head_count INTEGER
);

create table if not exists employee_phonenumbers (
    employee_id INTEGER,
    type VARCHAR(50),
    number VARCHAR(50)
);

create table if not exists employees (
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id VARCHAR(36) UNIQUE,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email_address VARCHAR(50),
    street_address VARCHAR (50),
    city VARCHAR (50),
    province VARCHAR (50),
    country VARCHAR (50),
    postal_code VARCHAR (9),
    department_id VARCHAR(36),
    position_title VARCHAR(50)
);


create table if not exists designers (
                           id INT NOT NULL AUTO_INCREMENT,
                           designer_id VARCHAR(60) NOT NULL UNIQUE,
                           name VARCHAR(255) NOT NULL,
                           dob DATE NOT NULL,
                           country VARCHAR(255),
                           Kimageurl VARCHAR(255),
                           PRIMARY KEY (id)
);

create table if not exists clothing (
                           id INT NOT NULL AUTO_INCREMENT,
                           clothing_id VARCHAR(36) NOT NULL UNIQUE,
                           name VARCHAR(255) NOT NULL,
                           price DECIMAL(10,2) NOT NULL,
                           material VARCHAR(50),
                           image_url VARCHAR(255),
                           designer_id VARCHAR(60)NOT NULL,
                           PRIMARY KEY (id),
                           FOREIGN KEY (designer_id) REFERENCES designers(designer_id)
);