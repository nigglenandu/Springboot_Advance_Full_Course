package nigglenandu.Student_Management_Crud.Service;

import lombok.RequiredArgsConstructor;
import nigglenandu.Student_Management_Crud.Entity.StudentEntity;
import nigglenandu.Student_Management_Crud.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // Lombok generates constructor for final fields
public class StudentServiceImpl implements IStudentService {

    private final StudentRepository studentRepository; // Inject repository

    // ✅ CREATE: Save a new student to the database
    @Override
    public StudentEntity createStudent(StudentEntity student) {
        // studentRepository.save() persists the entity and returns the saved object
        return studentRepository.save(student);
    }

    // ✅ READ ALL: Fetch all students
    @Override
    public List<StudentEntity> getAllStudents() {
        // findAll() returns a list of all students
        return studentRepository.findAll();
    }

    // ✅ READ BY ID: Fetch a student by ID
    @Override
    public Optional<StudentEntity> getStudentById(Long id) {
        // findById() returns Optional<StudentEntity>, empty if not found
        return studentRepository.findById(id);
    }

    // ✅ UPDATE: Update student details by ID
    @Override
    public Optional<StudentEntity> updateStudent(Long id, StudentEntity updatedStudent) {
        // Find the student first
        return studentRepository.findById(id)
                .map(student -> {
                    // Update fields with new values
                    student.setName(updatedStudent.getName());
                    student.setAddress(updatedStudent.getAddress());
                    student.setEmail(updatedStudent.getEmail());
                    // Save updated student back to DB
                    return studentRepository.save(student);
                });
        // Returns Optional<StudentEntity>, empty if ID not found
    }

    // ✅ DELETE: Delete student by ID
    @Override
    public boolean deleteStudent(Long id) {
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.delete(student); // Remove entity
                    return true; // Successfully deleted
                }).orElse(false); // Return false if not found
    }
}
