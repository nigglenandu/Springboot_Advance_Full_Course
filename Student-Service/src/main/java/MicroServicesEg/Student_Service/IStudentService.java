package MicroServicesEg.Student_Service;

public interface IStudentService {
    Student getStudentById(Long id);
    void saveStudent(Student student);

}
