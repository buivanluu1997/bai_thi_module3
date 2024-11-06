create database bai_thi_module_3;
use bai_thi_module_3;

CREATE TABLE PaymentMethods (
    payment_method_id INT AUTO_INCREMENT PRIMARY KEY, 
    payment_method_name VARCHAR(50)
);

create table RentalRooms(
room_id int auto_increment primary key,
tenant_name VARCHAR(100),
phone_number varchar(45),
star_date date,
notes TEXT,
payment_method_id int,
FOREIGN KEY (payment_method_id) REFERENCES PaymentMethods(payment_method_id)
);

insert into PaymentMethods(payment_method_name) values ('Tháng'),('Quý'),('Năm');

insert into RentalRooms(tenant_name,phone_number,star_date,notes,payment_method_id) values ('Nguyen Van Hung','012345652','2024-10-24','Phòng 205',1),
('Tran Hong Son','0888888888','2024-10-25','Phòng 207',2),('Hoang Huy','05874512','2024-11-24','Phòng 205',3);
