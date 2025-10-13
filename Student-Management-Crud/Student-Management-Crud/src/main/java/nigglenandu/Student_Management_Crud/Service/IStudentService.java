package nigglenandu.Student_Management_Crud.Service;

import nigglenandu.Student_Management_Crud.Entity.StudentEntity;
import java.util.List;

// This interface defines the methods for student-related operations
public interface IStudentService {

    // Get all student records from the database
    List<StudentEntity> getAllStudents();

    // Get a single student record by its ID
    StudentEntity getStudentById(Long id);

    // Save a new student to the database
    void saveStudent(StudentEntity student);

    // Update an existing student by ID
    boolean updateStudent(Long id, StudentEntity student);

    // Delete a student record by ID
    boolean deleteStudentById(Long id);
}
