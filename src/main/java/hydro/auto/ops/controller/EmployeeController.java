package hydro.auto.ops.controller;

import hydro.auto.ops.model.Employee;
import hydro.auto.ops.repository.EmployeeRepository;
import hydro.auto.ops.repository.EmployeeRepository_v2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeRepository_v2 employeeRepository_v2;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        try {
            return new ResponseEntity<>(employeeRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) {
        try {
            Employee employee = employeeRepository.findById(employeeId).orElse(null);
            return new ResponseEntity<>(employee, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        try {
//            employeeRepository.save(employee);
            employeeRepository_v2.save(employee);
            return new ResponseEntity<>("created successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("created failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable(value = "id") Long employeeId,

                                                 @RequestBody Employee employeeDetails) {
        try {
            Employee employee = employeeRepository.findById(employeeId).orElse(null);
            if (employee != null) {
                employee.setEmployee_name(employeeDetails.getEmployee_name());
                employee.setCity(employeeDetails.getCity());
                employeeRepository.save(employee);
                return new ResponseEntity<>("updated successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cannot find Employee with id= " + employeeId, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("updated failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable(value = "id") Long employeeId) {
        try {
            Employee employee = employeeRepository.findById(employeeId).orElse(null);
            if (employee != null) {
                employeeRepository.delete(employee);
                return new ResponseEntity<>("deleted successfully.", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cannot find Employee with id=" + employeeId, HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("deleted failed", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
