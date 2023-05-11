package hydro.auto.ops.repository.db1;

import hydro.auto.ops.model.db1.Employee;

import java.util.List;

public interface EmployeeRepository_v2 {
    int save(Employee employee);
    List<Employee> getAllEmployees();
}
