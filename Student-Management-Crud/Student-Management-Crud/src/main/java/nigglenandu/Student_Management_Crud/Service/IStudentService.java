package nigglenandu.Student_Management_Crud.Service;

import nigglenandu.Student_Management_Crud.Entity.StudentEntity;

import java.util.List;

public interface IStudentService {
    List<StudentEntity> getAllStudents();
    StudentEntity getStudentById(Long id);
    void saveStudent(StudentEntity student);
    boolean updateStudent(Long id, StudentEntity student);
    boolean deleteStudentById(Long id);
}
