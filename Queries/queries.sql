Create Table Query: 
CREATE TABLE employee (
    id SERIAL PRIMARY KEY,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    date_of_birth DATE NOT NULL,
    department VARCHAR(255) NOT NULL,
    designation VARCHAR(255) NOT NULL
);

Insert Query : 
INSERT INTO employee (firstname, lastname, date_of_birth, department, designation) 
VALUES ('Anusha', 'R', '1990-05-15', 'Development', 'Senior Software Engineer');

Update Query: 
UPDATE employee SET designation = 'Technical Lead' WHERE id = 1;

Select Query : 
SELECT * FROM employee WHERE department = 'HR';

Delete Data: 
DELETE FROM employee WHERE id = 1;
