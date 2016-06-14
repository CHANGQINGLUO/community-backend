CREATE TABLE Activity 
   (	UUID VARCHAR(100) NOT NULL ,
        Title VARCHAR(1000),
        Datetime timestamp,
		Address VARCHAR(1000),
		initiator VARCHAR(1000) NOT NULL,
		Venue VARCHAR(1000),
		Description BLOB,

		IS_DELETED VARCHAR(1) DEFAULT '0',
		DATE_CREATE timestamp NOT NULL,
		CREATE_BY VARCHAR(50),
		DATE_UPDATE timestamp,
		UPDATE_BY VARCHAR(50)	  )  ;
  
  CREATE UNIQUE INDEX Activity_UUID_PK ON Activity (UUID); 
  
ALTER TABLE Activity ADD CONSTRAINT Activity_UUID_PK PRIMARY KEY (UUID);
ALTER TABLE Activity ADD CONSTRAINT Activity_User_FK FOREIGN KEY (initiator) REFERENCES Users (User_UUID);