insert into users (username,password,enabled)
VALUES
  ('admin','admin',true),
  ('user','user',true);

insert into user_roles (username,role)
VALUES
  ('admin','ROLE_ADMIN'),
  ('admin','ROLE_ACTUATOR'),
  ('user','ROLE_USER');

insert into products
VALUES
  ('s1','One plus','5 64Gb',14000,'no description yet',100,10,'smartphone'),
  ('s2','Honor','8 Lite 32Gb',17000,'no description yet',200,10,'smartphone'),
  ('s3','Meizu','MX6 32Gb',22000,'no description yet',300,10,'smartphone'),
  ('s4','Lg','G6+',34000,'no description yet',50,10,'smartphone'),
  ('s5','Xiaomi','Redmi Note 4X 64Gb',9000,'no description yet',1000,10,'smartphone'),

  ('l1','MSI','GE62MVR 7RG',137000,'no description yet',700,10,'laptop'),
  ('l2','Lenovo','Legion Y520',167000,'no description yet',700,10,'laptop'),
  ('l3','Apple','MacBook Mid 2017',107000,'no description yet',700,10,'laptop'),

  ('sw1','Xiaomi','Mi Band 2',2700,'no description yet',700,10,'smartwatch'),
  ('sw2','Apple','Watch Series 2',24000,'no description yet',700,10,'smartwatch'),
  ('sw3','Motorola','Moto 360',67000,'no description yet',700,10,'smartwatch'),

  ('t1','Sony','43LEX-5024',77000,'no description yet',700,10,'tv'),
  ('t2','SHARP','43UH610V',55000,'no description yet',700,10,'tv'),
  ('t3','LG','LC-48CFE4042E',89000,'no description yet',700,10,'tv');