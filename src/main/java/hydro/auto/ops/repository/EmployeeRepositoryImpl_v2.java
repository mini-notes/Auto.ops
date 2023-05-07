package hydro.auto.ops.repository;

import hydro.auto.ops.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl_v2 implements EmployeeRepository_v2{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMPLOYEE_NAME, CITY) VALUES(?,?,?)",
                new Object[] { employee.getEmployee_id(),employee.getEmployee_name(),employee.getCity() });
    }
}

