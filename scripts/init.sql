USE database;
CREATE TABLE students(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    email VARCHAR(255),
    active BOOLEAN
);

INSERT INTO students(name, email, active) 
VALUES("SIJAN MALLA", "sijan.malla101@gmail.com", TRUE );
INSERT INTO students(name, email, active) 
VALUES("JOHN DOE", "john.doe@gmail.com", FALSE );
INSERT INTO students(name, email, active) 
VALUES("PRATIK MAHARJAN", "pratik.maharjan@live.com", TRUE );