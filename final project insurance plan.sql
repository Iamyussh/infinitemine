create database finalproject;
use finalproject;


CREATE TABLE Insurance_Details (
    Insurance_id varchar(5) PRIMARY KEy,
    Insurance_Name VARCHAR(255),
    Type VARCHAR(255),
    PremiumStart DATE,
    PremiumEnd DATE,
    MinPeriod INT,
    MaxPeriod INT,
    LaunchDate DATE,
    Status VARCHAR(10)
);
CREATE TABLE Insurance_Plans (
    Plan_id INT AUTO_INCREMENT PRIMARY KEY,
    Insurance_id  varchar(5),
    Premium_Amount DECIMAL(10, 2),
    Coverage_Amount DECIMAL(10, 2),
    Benefits varchar(369),
    FOREIGN KEY (Insurance_id) REFERENCES Insurance_Details(Insurance_id)
    );
    
    INSERT INTO Insurance_Details (Insurance_id, Insurance_Name, Type, PremiumStart, PremiumEnd, MinPeriod, MaxPeriod, LaunchDate, Status)
VALUES
    ('I001', 'Aditya Birla Activ Health Platinum Plan', 'Private', '2023-01-01', '2023-12-31', 1, 10, '2023-01-01', 'Active'),
    ('I002', 'Bharti AXA Smart Super Health Insurance Policy

	', 'Government', '2023-03-15', '2024-03-15', 1, 5, '2023-03-15', 'Active'),
    ('I003', 'Niva Bupa Heartbeat Health Insurance Plan', 'Private', '2023-02-01', '2033-02-01', 5, 30, '2023-02-01', 'Active');
    
    INSERT INTO Insurance_Details (Insurance_id, Insurance_Name, Type, PremiumStart, PremiumEnd, MinPeriod, MaxPeriod, LaunchDate, Status)
VALUES
    ('I004', 'HDFC Ergo Health Suraksha', 'Private', '2023-04-01', '2024-04-01', 1, 10, '2023-04-01', 'Active'),
    ('I005', 'LIC Jeevan Arogya', 'Government', '2023-05-15', '2024-05-15', 1, 5, '2023-05-15', 'Active'),
    ('I006', 'Tata AIG Wellsurance Family', 'Private', '2023-06-01', '2033-06-01', 5, 30, '2023-06-01', 'Active');
    INSERT INTO Insurance_Details (Insurance_id, Insurance_Name, Type, PremiumStart, PremiumEnd, MinPeriod, MaxPeriod, LaunchDate, Status)
VALUES
    ('I007', 'Reliance HealthGain', 'Private', '2023-07-01', '2024-07-01', 1, 10, '2023-07-01', 'Active'),
    ('I008', 'SBI General Arogya Premier Policy', 'Government', '2023-08-15', '2024-08-15', 1, 5, '2023-08-15', 'Active'),
    ('I009', 'ICICI Lombard Complete Health Insurance', 'Private', '2023-09-01', '2033-09-01', 5, 30, '2023-09-01', 'Active');


    
    
    -- Claim and provider---
    
    
    INSERT INTO Insurance_Plans (Insurance_id, Premium_Amount, Coverage_Amount, Benefits)
VALUES
    ('I001', 100, 10000, 'Dental Care'),
    ('I001',989, 30000, 'Maternity Care'),
     ('I001', 300, 200000, 'Surgery'),
     
       ('I002', 1000.00, 100000.00, 'Hospitalization'),
    ('I002', 200, 7500.00, 'Prescription Drugs'),
     ('I002', 800, 150000.00, 'Emergency Room'),
     
       ('I003', 600, 20000.00, 'Mental Health Services'),
    ('I003', 1200, 300000, 'Home Healthcare'),
     ('I003', 800, 20000, 'Chiropractic Care');
     
     
     
        
    CREATE TABLE patient_enrollment (
    UHID varchar(50) PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    DOB DATE,
    Gender ENUM('MALE', 'FEMALE', 'OTHER'),
    userName VARCHAR(50),
    Phone_no VARCHAR(50),
    email VARCHAR(200),
    status VARCHAR(50),
    cause VARCHAR(500),
    Address varchar(1000),
    medHistory Varchar(1000)
);

CREATE TABLE Provider_Details(
providerid varchar(50) PRIMARY KEY,
name varchar(50) ,
email varchar(50),
DoB Date,
username varchar(50),
phoneno varchar(50),
gender ENUM ('MALE','FEMALE') ,
speciality varchar(255),
type ENUM('DOCTOR', 'OWNER'),
address varchar(200)
);
    
     create table insurance_Claim(
    Claim_Id int Auto_Increment Primary Key,
	providerid varchar(50),
    Plan_id int,
    UHID varchar(100),
    foreign key(UHID) references patient_enrollment(UHID),
     foreign key(Plan_id) references Insurance_Plans(Plan_id),
     foreign key(providerid) references Provider_Details(providerid),
    Admit_date date,
    disc_date date,
    Bill_Amount numeric(11,2),
    Mis_Amount numeric(9,2),
    Disease varchar(100),
    Comments varchar(100)
    );
    
    
    Create table claim_history(
   ClaimHistoryId int auto_increment primary key,
   Claim_Id int,
   providerid varchar(50),
   Plan_id INT,
    UHID varchar(100),
    fromDate Date,
    toDate date,
    claimAmount decimal(9,2),
	foreign key(Claim_Id) references insurance_Claim(Claim_Id),
	foreign key(providerid) references Provider_Details(providerid),
	foreign key(Plan_id) references Insurance_Plans(Plan_id),
	foreign key(UHID) references patient_enrollment(UHID),
    status enum('ACCEPTED','REJECTED','PENDING') default 'PENDING',
    Comments varchar(20)
    );
    
    
    alter table claim_history
add column reimbursement_amount numeric(10,2) , add patient_responsibility varchar(255);
    