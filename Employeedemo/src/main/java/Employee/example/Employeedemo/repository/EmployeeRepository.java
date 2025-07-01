package Employee.example.Employeedemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import Employee.example.Employeedemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>  {

}


