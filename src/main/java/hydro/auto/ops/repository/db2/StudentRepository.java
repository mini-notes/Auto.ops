package hydro.auto.ops.repository.db2;

import hydro.auto.ops.model.db2.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public boolean existsByEmail(String email);

    public List<Student> findByEmail(String email);

    @Query("select max(s.id) from Student s")
    public Integer findMaxId();
}