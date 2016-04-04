create table T_ACCOUNT
(
	`PROFILEID`		varchar(20)	NOT NULL,
	`MONEY`			DOUBLE		DEFAULT NULL,
	PRIMARY KEY (`PROFILEID`)
)default charset=utf8;