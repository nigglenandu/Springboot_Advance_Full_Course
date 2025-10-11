package nigglenandu.Student_Management_Crud.Service;

import nigglenandu.Student_Management_Crud.Entity.StudentEntity;
import nigglenandu.Student_Management_Crud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Marks this class as a Spring Service component
@Service
public class StudentServiceImpl implements IStudentService {

    // Automatically injects the StudentRepository dependency
    @Autowired
    private StudentRepository studentRepository;

    // Get all student records from the database
    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get a single student record by ID
    @Override
    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    // Save a new student or update existing one
    @Override
    public void saveStudent(StudentEntity student) {
        studentRepository.save(student);
    }

    // Update student details by ID
    @Override
    public boolean updateStudent(Long id, StudentEntity student) {
        Optional<StudentEntity> optional = studentRepository.findById(id);

        if (optional.isPresent()) {
            // Get existing student and update fields
            StudentEntity studentToUpdate = optional.get();
            studentToUpdate.setStudentName(student.getStudentName());
            studentToUpdate.setGrade(student.getGrade());
            studentToUpdate.setGender(student.getGender());

            // Save updated student
            studentRepository.save(studentToUpdate);
            return true;
        } else {
            // If student not found, return false
            return false;
        }
    }

    // Delete student record by ID
    @Override
    public boolean deleteStudentById(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
