package MicroServicesEg.Student_Service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository  // Marks this interface as a Spring Data JPA repository
public interface StudentRepo extends JpaRepository<Student, Long> {

    // Custom method to find a student by ID
    // Returns an Optional, which may contain the student or be empty if not found
    Optional<Student> findStudentById(long id);
}
