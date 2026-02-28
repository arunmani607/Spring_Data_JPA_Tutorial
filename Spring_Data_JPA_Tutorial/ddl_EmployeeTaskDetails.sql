CREATE TABLE eth_ma_employee_details
(
    employee_id     INTEGER NOT NULL,
    employee_name   VARCHAR(255),
    employee_design VARCHAR(255),
    employee_mob_no VARCHAR(255),
    employee_age    INTEGER,
    employee_gmail  VARCHAR(255),
    CONSTRAINT pk_eth_ma_employee_details PRIMARY KEY (employee_id)
);