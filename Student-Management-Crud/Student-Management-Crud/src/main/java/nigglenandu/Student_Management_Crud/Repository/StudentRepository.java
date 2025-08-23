package nigglenandu.Student_Management_Crud.Repository;

import nigglenandu.Student_Management_Crud.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
