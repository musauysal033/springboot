##  libraries and other things 

 - postgresql
 - spring boot 
 - lombok
 - postgresql

## Endpoints
http://localhost:8080/api
### Company
| Endpoint                | Desc                                                     |
|-------------------------|----------------------------------------------------------|
| POST /api/company/create| Create company                                           |                
| GET /api/company/get-all| Get all company
| GET /api/company/get/uuidv4| Get company by id
| DELETE  /api/company/delete/uuidv4| Delete company  


### Employee
| Endpoint                | Desc                                                     |
|-------------------------|----------------------------------------------------------|
| POST /api/employee/create| Create employee|
| GET /api/employee/get-all| Get all employees
| GET /api/employee/get/uuidv4| get employee by id
| DELETE /api/employee/delete/uuidv4| Delete employee  

### Create postgresql Database ddl
*
### Company
-- public.company definition

-- Drop table

-- DROP TABLE public.company;

CREATE TABLE public.company (
	company_id serial4 NOT NULL,
	company_code varchar(20) NOT NULL,
	company_name varchar(50) NULL,
	employee_id int4 NOT NULL,
	CONSTRAINT company_pkey PRIMARY KEY (company_id),
	CONSTRAINT company_uniqkey UNIQUE (company_code),
	CONSTRAINT company_foreign_key FOREIGN KEY (employee_id) REFERENCES public.employee(employee_id)
);


### Employee
-- public.employee definition

-- Drop table

-- DROP TABLE public.employee;

CREATE TABLE public.employee (
	employee_id serial4 NOT NULL,
	employee_code varchar NOT NULL,
	employee_name varchar(50) NULL,
	city varchar(20) NOT NULL,
	country varchar NOT NULL,
	CONSTRAINT employee_pkey PRIMARY KEY (employee_id),
	CONSTRAINT employee_uniqkey UNIQUE (employee_code)
);
