package Employee.example.Employeedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Employee.example.Employeedemo.entity.Employee;
import Employee.example.Employeedemo.repository.EmployeeRepository;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        return employee;
    }

    public Employee createdEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employees) {
        Employee existingEmployee = findById(id);
        if (existingEmployee != null) {
            existingEmployee.setName(employees.getName());
            existingEmployee.setDepartment(employees.getDepartment());
            existingEmployee.setEmail(employees.getEmail());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    public Employee deleteById(Long id) {
        Employee employee = findById(id);
        if (employee != null) {
            employeeRepository.delete(employee);
            return employee;
        }
        return null;
    }

    
}
