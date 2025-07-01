package Employee.example.Employeedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Employee.example.Employeedemo.entity.Employee;
import Employee.example.Employeedemo.service.EmployeeService;

@RestController
@RequestMapping("/employeeDemo")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allEmployees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAllEmployees();
    }

    @GetMapping("getemployee/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            return ResponseEntity.ok("Employee doesn't exist");
        }
        return ResponseEntity.ok(employee);
    }

    @PostMapping("createEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.createdEmployee(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @PutMapping("employees/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable Long id, @RequestBody Employee employees) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employees);
        if (updatedEmployee == null) {
            return ResponseEntity.ok("Employee doesn't exist");
        }
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("deleteEmployee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        Employee deletedEmployee = employeeService.deleteById(id);
        if (deletedEmployee == null) {
            return ResponseEntity.ok("Employee doesn't exist");
        }
        return ResponseEntity.ok("Employee Deleted successfully");
    }
    
    
    
}

