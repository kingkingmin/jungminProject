create table food_infor(

f_no number(4) primary key,
f_name varchar2(10 char) not null,
f_kind varchar2(10 char) not null,
f_address varchar2(40 char) not null,
f_price varchar2(40 char) not null,
f_infor varchar2(350 char) not null,
f_service varchar2(40 char) not null,
f_phone varchar2(20 char) not null,

f_mapinfo1 varchar2(30 char) not null, 
f_mapinfo2 varchar2(30 char) not null, 
f_mapinfo3 varchar2(100 char) not null, 
f_mapinfoName varchar2(10 char) not null,

f_photo1 varchar2(300 char) not null,
f_photo2 varchar2(300 char) not null,
f_photo3 varchar2(300 char) not null

);

drop table food_infor cascade constraint purge;
create sequence food_infor_seq;
delete from food_infor where f_no = 181;
delete from food_infor where f_no = 182;
update food_infor set f_kind = '기타' where f_no = 27;

select * from food_infor;

create table site_food_reply(

	sir_no number(5) primary key, 
	sir_c_no number(4) not null,
	sir_c_star number(5, 2) not null,
	sir_c_writer varchar2(10 char) not null,
	sir_c_comment varchar2(200 char) not null,
	sir_date date not null,
	
	constraint sns_replyHekk2
	foreign key(sir_c_no) references food_infor(f_no)
	on delete cascade,
	
	constraint sns_writerHek2
	foreign key(sir_c_writer) references site_member(c_id)
	on delete cascade
);
		
drop table site_food_reply cascade constraint purge;
drop sequence site_food_reply_seq;
delete from site_food_reply where sir_no = 21;
create sequence site_food_reply_seq;
select * from site_food_reply;

