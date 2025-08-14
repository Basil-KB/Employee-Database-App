# Employee-Database-App
A simple Java console application that demonstrates **CRUD** (Create, Read, Update, Delete) operations on a MySQL database using **JDBC**.  
Built in **Eclipse** with **MySQL Connector**..
## 📌 Features
- Connect to MySQL using JDBC
- Add new employee records
- View all employees
- Update employee details
- Delete employees by ID
- Uses **PreparedStatement** for security and efficiency
  ## 🛠 Tools & Technologies
- Java (JDK 8+)
- MySQL (9.x recommended)
- JDBC (MySQL Connector)
- Eclipse IDE

 ## ⚙ Database Setup
Run the following SQL commands in MySQL:
```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    position VARCHAR(50),
    salary DECIMAL(10,2)
); 
