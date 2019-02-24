create table films (
	name varchar(100) primary key,
	director varchar(100),
	dateOfStart date,
	country varchar(50),
	duration numeric
) 

insert into films values('Film1', 'Director1', to_date('11-03-2000', 'DD-MM-yyyy'), 'USA', 125);
insert into films values('Film2', 'Director2', to_date('11-03-2005', 'DD-MM-yyyy'), 'Russia', 200);
insert into films values('Film3', 'Director3', to_date('11-03-2018', 'DD-MM-yyyy'), 'USA', 167);
insert into films values('Film4', 'Director3', to_date('11-03-2018', 'DD-MM-yyyy'), 'USA', 167);
