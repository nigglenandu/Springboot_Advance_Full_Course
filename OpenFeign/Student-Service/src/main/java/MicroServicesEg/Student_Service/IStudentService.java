package MicroServicesEg.Student_Service;

// This interface defines the methods that the service layer must implement
public interface IStudentService {

    // Method to fetch a student by their ID
    Student getStudentById(Long id);

    // Method to save a new student record to the database
    void saveStudent(Student student);
}
