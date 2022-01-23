
create table site_informBoard(
	f_no number(5) primary key,	
	f_writter varchar2(10 char) not null, 
	f_categoryK varchar2(20 char) not null, 
	f_categoryJ varchar2(20 char) not null, 
	f_sortK varchar2(20 char) not null, 
	f_sortJ varchar2(20 char) not null, 
	f_title varchar2(15 char) not null, 
	
	f_story varchar2(400 char) not null,
	f_mapinfo1 varchar2(30 char) not null, 
	f_mapinfo2 varchar2(30 char) not null, 
	f_mapinfo3 varchar2(100 char) not null, 
	f_mapinfoName varchar2(20 char) not null, 
	f_photo varchar2(300 char) not null,
	f_date date not null,

	constraint site_informboardk
	foreign key(f_writter) references site_member(c_id)
	on delete cascade
	
);

drop table site_informBoard cascade constraint purge;
drop sequence site_informBoard_seq;

drop sequence cafe_sns_seq;

create sequence site_informBoard_seq;

select * from site_informBoard;
delete from site_informBoard where f_no > 1;



select count(*)
	from site_informBoard
	where f_title like '%아르%' and f_story like '%%' and f_writter like '%%';
	
	
create table site_infor_reply(

	sir_no number(5) primary key, 
	sir_c_no number(4) not null,
	sir_c_writer varchar2(10 char) not null,
	sir_c_comment varchar2(200 char) not null,
	sir_date date not null,
	
	constraint sns_replyHek
	foreign key(sir_c_no) references site_informBoard(f_no)
	on delete cascade,
	
	constraint sns_writerHek
	foreign key(sir_c_writer) references site_member(c_id)
	on delete cascade
);	

drop table site_infor_reply cascade constraint purge;
drop sequence site_infor_reply_seq;

create sequence site_infor_reply_seq;
select * from site_infor_reply;

select * from site_infor_reply
where sir_c_no = 103
order by sir_date

//////////////////////////20210818

create table User_block(
	c_user varchar2(10 char) primary key, 
	c_blocker varchar2(300 char) not null, 

	constraint user_blockk
	foreign key(c_user) references site_member(c_id)
	on delete cascade 
);

create sequence User_block_seq;
select * from User_block;
delete from User_block where c_user = 'asdf1234';

insert into User_block values ( 'q', 'x!qwe9087');
insert into User_block values ( 'q', 'x!y');
insert into User_block values ( 'asd123', 'x!y');


drop table User_block cascade constraint purge;
drop sequence User_block_seq;
update User_block set c_blocker = 'y!x' where c_user = 'qwe9087';


constraint user_blockk
foreign key(c_user) references site_member(c_id)
on delete cascade 