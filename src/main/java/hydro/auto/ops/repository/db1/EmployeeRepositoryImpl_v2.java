package hydro.auto.ops.repository.db1;

import hydro.auto.ops.model.db1.Employee;
import hydro.auto.ops.repository.db1.EmployeeRepository_v2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl_v2 implements EmployeeRepository_v2 {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Employee employee) {
        return jdbcTemplate.update("INSERT INTO EMPLOYEES (EMPLOYEE_ID, EMPLOYEE_NAME, CITY) VALUES(?,?,?)",
                new Object[] { employee.getEmployee_id(),employee.getEmployee_name(),employee.getCity() });
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("select * from EMPLOYEES",new BeanPropertyRowMapper(Employee.class));
    }
}

