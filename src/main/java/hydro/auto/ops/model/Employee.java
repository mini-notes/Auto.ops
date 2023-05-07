package hydro.auto.ops.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employee_id;

    @Column(name = "employee_name")
    private String employee_name;

    @Column(name = "city")
    private String city;

    public Employee() {
    }

    public Employee(long employee_id, String employee_name, String city) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.city = city;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }


}
