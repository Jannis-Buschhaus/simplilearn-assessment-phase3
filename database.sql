create database travel_app;
use travel_app;
/* Tables will be created by the JPA @Entity annotations */

show tables;

describe booking;
select * from booking;
truncate table booking;

describe type_of_cab;
insert into type_of_cab values(0, "Small", 0.8);
insert into type_of_cab values(1, "Standard", 1.0);
insert into type_of_cab values(2, "Premium", 1.2);
select * from type_of_cab;

describe cab_fares;
insert into cab_fares values(0, "Airport", "Train Station", 49.0);
insert into cab_fares values(1, "Train Station", "Airport", 49.0);
insert into cab_fares values(2, "City Center", "Train Station", 69.0);
insert into cab_fares values(3, "Train Station", "City Center", 69.0);
insert into cab_fares values(4, "City Center", "Airport", 79.0);
insert into cab_fares values(5, "Airport", "City Center", 79.0);
select * from cab_fares;
