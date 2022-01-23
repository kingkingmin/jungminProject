
create table site_member(

c_id varchar2(10 char) primary key,
c_pw varchar2(10 char) not null,
c_name varchar2(10 char) not null,
c_languageJ varchar2(50 char) not null,
c_languageK varchar2(50 char) not null,
c_pwqJ varchar2(30 char) not null,
c_pwqK varchar2(30 char) not null,
c_pwans varchar2(30 char) not null,
c_email varchar2(30 char) not null,
c_genderJ char (5 char) not null,
c_genderK char (5 char) not null,
c_countryJ varchar2(10 char) not null,
c_countryK varchar2(10 char) not null,
c_comment varchar2(400 char) not null,
c_photo varchar2(200 char) not null

);
drop table site_member cascade constraint purge;

delete from site_member where c_id = 'asdf1234';


select * from site_member where c_gender = '여' and c_country = '일본'
select * from site_member where c_gender = '여' 
select * from site_member where c_country = '한국' 
SELECT * FROM site_member ;


--select * from site_member;


select *
		from (
			select rownum as rn, c_id, c_pw, c_name, c_language, c_pwq, c_pwans, c_email , c_gender, c_country, c_comment, c_photo
			from(                                                                                                       
				select * from site_member
				where c_name like '%정민%'
		     )
		)
		where rn >= 0 and rn <= 4;


		
		
create table site_mail(
	c_no number(4) primary key,	
	c_getter varchar2(10 char) not null, 
	c_sender varchar2(10 char) not null, 
	c_comment varchar2(400 char) not null,
	c_date date not null,
	
	constraint site_writerk
	foreign key(c_getter) references site_member(c_id)
	on delete cascade 
	
);

drop table site_mail cascade constraint purge;
drop sequence site_mail_seq;


select *
		from (
			select rownum as rn, c_no, c_sender, c_comment, c_date 
			from(
				select * from site_mail
				where c_getter = 'q' 
				order by c_date desc
		     )
		)
		where rn >= 0 and rn <= 5;

select * from site_mail where c_getter = 'q4';
select count(*)
	from site_mail
	where c_getter  = 'q';

create sequence site_mail_seq;

delete from site_mail where c_getter = 'qwer9087';


select * from site_mail;





