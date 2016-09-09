create schema DERBY;


CREATE TABLE DERBY.t_gk_users (
		userId	INTEGER NOT NULL,
		username VARCHAR(50) NOT NULL,
		password VARCHAR(50),
		firstname VARCHAR(50),
		lastname VARCHAR(50),
		email VARCHAR(50),
		addressid INTEGER NOT NULL,
		accountnumber INTEGER NOT NULL,
		constraint useid_pk PRIMARY KEY (userId),
		constraint addrid_fk FOREIGN KEY (addressid) REFERENCES t_gk_address(addressid),
		constraint accntnum_fk FOREIGN KEY (accountnumber) REFERENCES t_gk_accounts(accountnumber)
	);

	CREATE TABLE DERBY.t_gk_address (
		addressid	INTEGER  NOT NULL,
		housenumber VARCHAR(50),
		streetname VARCHAR(50),
		city VARCHAR(50),
		state VARCHAR(50),
		pincode INTEGER,
		constraint addrid_pk PRIMARY KEY (addressid)
	);
	
	CREATE TABLE DERBY.t_gk_accounts (
		accountnumber	INTEGER  NOT NULL,
		balance DOUBLE,
		constraint accntnum_pk PRIMARY KEY (accountnumber)
	);

	CREATE TABLE DERBY.t_gk_products (
		productId	INTEGER NOT NULL,
		prodname VARCHAR(50) NOT NULL,
		price DOUBLE NOT NULL,
		colour VARCHAR(50),
		categoryid INTEGER NOT NULL,
		constraint prodid_pk PRIMARY KEY (productId),
		constraint categoryid_fk FOREIGN KEY (categoryid) REFERENCES t_gk_product_category(categoryid)
	);
	
		CREATE TABLE DERBY.t_gk_product_category (
		categoryid	INTEGER  NOT NULL,
		catagoryname VARCHAR(50),
		constraint categoryid_pk PRIMARY KEY (categoryid)
	);
	
	
	CREATE TABLE DERBY.t_gk_orders (
		orderId	INTEGER NOT NULL,
		orderStatus VARCHAR(50) ,
		orderDate DATE ,
		modifiedDate DATE,
		userid INTEGER NOT NULL,
		constraint orderid_pk PRIMARY KEY (orderId)
	);
	
	
		CREATE TABLE DERBY.t_gk_product_order (
		orderId			INTEGER  NOT NULL,
		productorderId	INTEGER  NOT NULL,
		orderStatus VARCHAR(50),
		orderDate DATE ,
		modifiedDate DATE,
		productid INTEGER NOT NULL,
		constraint productorderId_pk PRIMARY KEY (productorderId),
		constraint orderid_fk FOREIGN KEY (orderId) REFERENCES t_gk_orders(orderId)
	);
	
	create SEQUENCE orderid_seq
	AS INTEGER
	START WITH 1
	INCREMENT BY 1 ;
	
	create SEQUENCE product_orderid_seq
	AS INTEGER
	START WITH 1
	INCREMENT BY 1 ;
	
	values ( next value for orderid_seq);
	
	alter table t_gk_users add column addressid integer;
	alter table t_gk_users add column accountnumber integer;
	alter table t_gk_accounts drop column accountid; 
	alter table t_gk_accounts add column accountnumber integer;

	alter table t_gk_users add constraint users_userId_nn CHECK (userId IS NOT NULL);
	
alter table t_gk_users add constraint users_userId_pk PRIMARY KEY(userId);
alter table t_gk_users add constraint users_userId_nn not null(userId);
alter table t_gk_users update(userId  VARCHAR(10) not null);	

insert into t_gk_product_category values(5,'electronics');
insert into t_gk_products values(105,'titan',10000,'black',3);