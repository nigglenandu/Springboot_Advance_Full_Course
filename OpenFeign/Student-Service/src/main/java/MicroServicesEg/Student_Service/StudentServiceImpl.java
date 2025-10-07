package MicroServicesEg.Student_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// @Service: Marks this class as a Service layer component
// It contains business logic and interacts with the repository (database)
@Service
public class StudentServiceImpl implements IStudentService {

    // @Autowired: Automatically injects the repository object
    // So we can use it to perform database operations
    @Autowired
    private StudentRepo studentRepo;

    // This method finds a student by ID
    @Override
    public Student getStudentById(Long id) {
        // findStudentById() returns an Optional<Student>
        // .map(student -> student) simply returns the student if found
        // .orElseGet(null) is incorrect, it should be .orElse(null)
        // (fix: use .orElse(null) instead)
        return studentRepo.findStudentById(id)
                .map(student -> student)
                .orElse(null);
    }

    // This method saves a new student record into the database
    @Override
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }
}
