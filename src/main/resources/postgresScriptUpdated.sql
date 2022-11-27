DROP TABLE employee CASCADE;

CREATE TABLE employee(
	employee_username   varchar(255) PRIMARY KEY,
	employee_email varchar(255) NOT NULL UNIQUE,
	employee_password varchar(255),
	employee_name varchar(255),
	employee_role int DEFAULT 0
);

--employee_role DEFAULT 0 for employee and 1 for manager -- 

DROP TABLE requests;

-- switch id with username for both areas -- 
-- add constraints NOT NULL UNIQUE -- 
-- change employee role to a boolean -- 
-- add DEFAULT variables -- 

--change the ID types to serial-- 
-- see where to add enums -- 

--CREATE TYPE myStatus AS ENUM ('pending','denied','aproved');--  -- might be good to do a varchar here and enum in java code--
                                                                  -- or typecast with ::'enumname' --
CREATE TABLE requests(
	requests_id serial PRIMARY KEY, -- make this serial ask if needs to be in model --
	employee_username varchar(255) NOT NULL,
	description varchar(255),
	amount numeric,
	status varchar(255) DEFAULT 'pending',
	approvedBy varchar(255) DEFAULT '',
	FOREIGN KEY (approvedBy) REFERENCES employee(employee_username), -- set as a foreign key to username -- 
	FOREIGN KEY (employee_username)  REFERENCES employee(employee_username)  -- change this to username -- 
);

INSERT INTO employee (employee_username, employee_email, employee_password, employee_name) VALUES ('sksk', 'sanchit@revature.net','1223','Sanchit');
INSERT INTO employee (employee_username, employee_email, employee_password, employee_name, employee_role) VALUES ('managerguy', 'manager@revature.net','1223','Manager Dude',1);

SELECT * FROM employee;

INSERT INTO requests (employee_username,description,amount,approvedBy) VALUES ('sksk','DUBAI',5000.15,NULL);
INSERT INTO requests (employee_username,description,amount,status,approvedBy) VALUES ('sksk','Qatar',ROUND(5000.86,2),'pending',null);
INSERT INTO requests (employee_username,description,amount,status,approvedBy) VALUES ('sksk','Qatar',5000.86::NUMERIC,'pending',NULL);

SELECT * FROM requests;
truncate table requests;

update requests set status = 'pending', approvedBy = 'ZeldaManagerrrr'  where requests_id = '1' and status ='pending'

SELECT e.*, r.* FROM employee e
INNER JOIN requests r
ON e.employee_username = r.employee_username; 

SELECT e.*, r.* FROM requests r
INNER JOIN employee e 
ON r.employee_username = e.employee_username; 


