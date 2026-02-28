-- Add employee_id column to Employee_Task table for foreign key relationship
ALTER TABLE employee_task 
ADD COLUMN employee_id INTEGER;

-- Add foreign key constraint
ALTER TABLE employee_task 
ADD CONSTRAINT fk_employee_task 
FOREIGN KEY (employee_id) 
REFERENCES eth_ma_employee_details(employee_id);

-- Create index for better performance
CREATE INDEX idx_employee_task_employee_id ON employee_task(employee_id);
