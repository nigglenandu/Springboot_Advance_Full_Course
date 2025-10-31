package nigglenandu.Student_Management_Crud.Service;

import nigglenandu.Student_Management_Crud.Entity.StudentEntity;

import java.util.List;
import java.util.Optional;

/**
 * IStudentService (Interface)
 * ---------------------------
 * This interface defines all the methods (operations)
 * that can be performed on the StudentEntity.
 *
 * Think of it like a *contract* — it only declares
 * what should be done, not how it is done.
 */
public interface IStudentService {

    /**
     * Create a new student and save it to the database.
     * @param student - student object to be created
     * @return the saved student
     */
    StudentEntity createStudent(StudentEntity student);

    /**
     * Get a list of all students.
     * @return list of students
     */
    List<StudentEntity> getAllStudents();

    /**
     * Find a student by ID.
     * @param id - student ID
     * @return Optional containing student if found, or empty if not
     */
    Optional<StudentEntity> getStudentById(Long id);

    /**
     * Update student details using ID.
     * @param id - student ID
     * @param student - student object with updated info
     * @return Optional containing updated student if found
     */
    Optional<StudentEntity> updateStudent(Long id, StudentEntity student);

    /**
     * Delete a student using ID.
     * @param id - student ID
     * @return true if deleted successfully, false otherwise
     */
    boolean deleteStudent(Long id);
}
