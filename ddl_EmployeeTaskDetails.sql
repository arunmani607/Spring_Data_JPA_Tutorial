CREATE TABLE employee_task
(
    employee_seqid      BIGINT       NOT NULL,
    emp_taskid          VARCHAR(7)   NOT NULL,
    emp_task_desciption VARCHAR(200) NOT NULL,
    emp_task_priority   VARCHAR(10)  NOT NULL,
    emp_task_status     VARCHAR(12)  NOT NULL,
    CONSTRAINT pk_employee_task PRIMARY KEY (employee_seqid)
);