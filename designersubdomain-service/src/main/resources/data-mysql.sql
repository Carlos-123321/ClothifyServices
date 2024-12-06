
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('c3540a89-cb47-4c96-888e-ff96708db4d8', 'Alick', 'Ucceli', 'aucceli0@dot.gov', '73 Shoshone Road', 'Barraute', 'Québec', 'Canada', 'P0M 2T6');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('dd1ab8b0-ab17-4e03-b70a-84caa3871606', 'Ricky', 'Presslie', 'rpresslie1@domainmarket.com', '24 Dorton Circle', 'Notre-Dame-des-Prairies', 'Québec', 'Canada', 'K6V 3J2');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('ba6c3e76-366e-44bb-8279-b41dc32dc456', 'Allx', 'Cholmondeley', 'acholmondeley2@weibo.com', '61 Farragut Street', 'Senneterre', 'Québec', 'Canada', 'L0P 1J8');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('45772446-62f4-4ccb-b3f4-9393c186fa43', 'Gaspar', 'Russi', 'grussi3@un.org', '3612 Del Mar Terrace', 'Sainte-Marthe-sur-le-Lac', 'Québec', 'Canada', 'H9K 0W3');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('30a4e2e3-fe9d-4903-bd23-b0a72b6c4ced', 'Hillard', 'Heamus', 'hheamus4@va.gov', '809 Blue Bill Park Park', 'Cowansville', 'Québec', 'Canada', 'J2K P4X');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('2bec7ec2-fe40-474f-a8cd-612f7790d24f', 'Darrin', 'Cadd', 'dcadd5@ning.com', '9 Cambridge Road', 'Havre-Saint-Pierre', 'Québec', 'Canada', 'H4R 1R9');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('6b2214d8-8d17-42f3-82bd-1b9264f19c64', 'Susana', 'Maxfield', 'smaxfield6@themeforest.net', '4509 Mifflin Road', 'Acton Vale', 'Québec', 'Canada', 'G0E N6E');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('a11014c8-85bc-4f8a-b627-7dfd645764ce', 'Elias', 'Plaxton', 'eplaxton7@house.gov', '382 Dorton Terrace', 'London', 'Ontario', 'Canada', 'N6C 2E4');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('13526a90-506f-4981-a9da-06ba21fc610b', 'Ralina', 'Sussex', 'rsussex8@nymag.com', '624 Gale Alley', 'Waterloo', 'Ontario', 'Canada', 'N2L 7K8');
insert into customers (customer_id, first_name, last_name, email_address, street_address, city, province, country, postal_code) values ('cc9c2c7f-afc9-46fb-8119-17158e54d02f', 'Pen', 'Carruthers', 'pcarruthers9@gov.uk', '3 4th Terrace', 'Hearst', 'Ontario', 'Canada', 'S4A 8Y2');


insert into customer_phonenumbers(customer_id, type, number) values(1, 'WORK', '515-555-1234');
insert into customer_phonenumbers(customer_id, type, number) values(1, 'MOBILE', '416-555-1234');
insert into customer_phonenumbers(customer_id, type, number) values(2, 'WORK', '515-555-9999');
insert into customer_phonenumbers(customer_id, type, number) values(3, 'MOBILE', '416-555-3333');


insert into departments(department_id, name, head_count) values('1', 'assistants', 2);
insert into departments(department_id, name, head_count) values('2', 'customer relations', 3);


insert into department_positions(department_id, title, code) values(1, 'assistant', 'samm1');
insert into department_positions(department_id, title, code) values(2, 'associate', 'sama1');


insert into employees (employee_id, first_name, last_name, email_address, street_address, city, province, country, postal_code, department_id, position_title)
values ('1001', 'Joe', 'Biden', 'joebiden@gmail.com', 'street_address_value', 'Washington', '', 'USA', 'J32 54T', '1', 'assistant');
insert into employees (employee_id, first_name, last_name, email_address, street_address, city, province, country, postal_code, department_id, position_title)
values ('1002', 'Moe', 'Bi1den', 'joebiden@gmail.com', 'street_address_value', 'Washington', '', 'USA', 'J32 54T', '1', 'assistant');
insert into employees (employee_id, first_name, last_name, email_address, street_address, city, province, country, postal_code, department_id, position_title)
values ('1003', 'Soe', 'Riden', 'joebiden@gmail.com', 'street_address_value', 'Washington', '', 'USA', 'J32 54T', '1', 'assistant');
insert into employees (employee_id, first_name, last_name, email_address, street_address, city, province, country, postal_code, department_id, position_title)
values ('1004', 'Roe', 'Biden', 'joebiden@gmail.com', 'street_address_value', 'Washington', '', 'USA', 'J32 54T', '1', 'assistant');
insert into employees (employee_id, first_name, last_name, email_address, street_address, city, province, country, postal_code, department_id, position_title)
values ('1005', 'jEE', 'Biden', 'joebiden@gmail.com', 'street_address_value', 'Washington', '', 'USA', 'J32 54T', '1', 'assistant');
insert into employees (employee_id, first_name, last_name, email_address, street_address, city, province, country, postal_code, department_id, position_title)
values ('1006', 'toe', 'Biden', 'joebiden@gmail.com', 'street_address_value', 'Washington', '', 'USA', 'J32 54T', '1', 'assistant');
insert into employees (employee_id, first_name, last_name, email_address, street_address, city, province, country, postal_code, department_id, position_title)
values ('1007', 'Koe', 'Biden', 'joebiden@gmail.com', 'street_address_value', 'Washington', '', 'USA', 'J32 54T', '1', 'assistant');
insert into employees (employee_id, first_name, last_name, email_address, street_address, city, province, country, postal_code, department_id, position_title)
values ('1008', 'POKE', 'Biden', 'joebiden@gmail.com', 'street_address_value', 'Washington', '', 'USA', 'J32 54T', '1', 'assistant');
insert into employees (employee_id, first_name, last_name, email_address, street_address, city, province, country, postal_code, department_id, position_title)
values ('1009', 'MOKE', 'Biden', 'joebiden@gmail.com', 'street_address_value', 'Washington', '', 'USA', 'J32 54T', '1', 'assistant');
insert into employees (employee_id, first_name, last_name, email_address, street_address, city, province, country, postal_code, department_id, position_title)
values ('1010', 'Momo', 'Biden', 'joebiden@gmail.com', 'street_address_value', 'Washington', '', 'USA', 'J32 54T', '1', 'assistant');


insert into employee_phonenumbers(employee_id, type, number) values(1, 'WORK', '515-555-5555');
insert into employee_phonenumbers(employee_id, type, number) values(1, 'MOBILE', '514-555-4444');
insert into employee_phonenumbers(employee_id, type, number) values(2, 'WORK', '515-555-5555');
insert into employee_phonenumbers(employee_id, type, number) values(2, 'MOBILE', '514-555-1234');


insert into designers(designer_id,name,dob,country,KimageURL) values ('1001','Maximilian Beauregard','1973-02-04','Luxembourg','https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Fendi_store_opening_-_Karl_Lagerfeld_%2814091153382%29.jpg/800px-Fendi_store_opening_-_Karl_Lagerfeld_%2814091153382%29.jpg');
insert into designers(designer_id,name,dob,country, KimageURL) values ('1010','Aurelia Van Der Woodsen','1970-05-15','Netherlands', 'https://news.artnet.com/app/news-upload/2021/04/Hella-Jongerius-Portrait-2020-courtesy-Maharam-photo-Nick-Ballo%CC%81n-1024x768.jpeg');
insert into designers(designer_id,name,dob,country, KimageURL) values ('1020','Reginald Fontaine','1965-09-28','France', 'https://ichef.bbci.co.uk/news/976/cpsprodpb/856B/production/_102755143_ecc09386-1dc9-49ef-95d4-b823cde4bd3a.jpg.webp');
insert into designers(designer_id,name,dob,country, KimageURL) values ('1030','Seraphina Montague','1967-03-12','Monaco', 'https://inspirfashion.files.wordpress.com/2016/05/anna-wintour.jpg?w=1200');
insert into designers(designer_id,name,dob,country,KimageURL) values ('1040','Maximilian Beauregard','1973-02-04','Luxembourg','https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Fendi_store_opening_-_Karl_Lagerfeld_%2814091153382%29.jpg/800px-Fendi_store_opening_-_Karl_Lagerfeld_%2814091153382%29.jpg');
insert into designers(designer_id,name,dob,country, KimageURL) values ('1050','Aurelia Van Der Woodsen','1970-05-15','Netherlands', 'https://news.artnet.com/app/news-upload/2021/04/Hella-Jongerius-Portrait-2020-courtesy-Maharam-photo-Nick-Ballo%CC%81n-1024x768.jpeg');
insert into designers(designer_id,name,dob,country, KimageURL) values ('1060','Reginald Fontaine','1965-09-28','France', 'https://ichef.bbci.co.uk/news/976/cpsprodpb/856B/production/_102755143_ecc09386-1dc9-49ef-95d4-b823cde4bd3a.jpg.webp');
insert into designers(designer_id,name,dob,country, KimageURL) values ('1070','Seraphina Montague','1967-03-12','Monaco', 'https://inspirfashion.files.wordpress.com/2016/05/anna-wintour.jpg?w=1200');
insert into designers(designer_id,name,dob,country, KimageURL) values ('1080','Reginald Fontaine','1965-09-28','France', 'https://ichef.bbci.co.uk/news/976/cpsprodpb/856B/production/_102755143_ecc09386-1dc9-49ef-95d4-b823cde4bd3a.jpg.webp');
insert into designers(designer_id,name,dob,country, KimageURL) values ('1090','Seraphina Montague','1967-03-12','Monaco', 'https://inspirfashion.files.wordpress.com/2016/05/anna-wintour.jpg?w=1200');

insert into clothing(clothing_id, name, price, material, image_url, designer_id) values ('F101', 'Regal Velvet Blazer', 1200.00, 'Wool', '', '1020');
insert into clothing(clothing_id, name, price, material, image_url, designer_id) values ('F102', 'Opulent Gown', 2500.00, 'Wool', '', '1001');
insert into clothing(clothing_id, name, price, material, image_url, designer_id) values ('F103', 'Luxe Robe', 800.00, 'Cotton', '', '1030');
insert into clothing(clothing_id, name, price, material, image_url, designer_id) values ('F104', 'Prestige Jacket', 1800.00, 'Cotton', '', '1010');
insert into clothing(clothing_id, name, price, material, image_url, designer_id) values ('F105', 'Majestic Coat', 1000.00, 'Polyester', '', '1010');
insert into clothing(clothing_id, name, price, material, image_url, designer_id) values ('F106', 'Lavish Pantsuit', 600.00, 'Polyester', '', '1020');
insert into clothing(clothing_id, name, price, material, image_url, designer_id) values ('F107', 'Supreme Alpaca Poncho', 120.00, 'Cotton', '', '1001');
insert into clothing(clothing_id, name, price, material, image_url, designer_id) values ('F108', 'Premier Scarf', 350.00, 'Cotton', '', '1030');
insert into clothing(clothing_id, name, price, material, image_url, designer_id) values ('F109', 'Luxurious Blazer', 120.00, 'Wool', '', '1001');
insert into clothing(clothing_id, name, price, material, image_url, designer_id) values ('F110', 'Elite Kimono', 350.00, 'Wool', '', '1030');