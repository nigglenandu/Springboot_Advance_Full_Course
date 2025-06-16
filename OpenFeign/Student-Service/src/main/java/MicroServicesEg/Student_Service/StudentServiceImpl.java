package MicroServicesEg.Student_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements IStudentService{
    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findStudentById(id)
                .map(student -> student)
                .orElseGet(null);
    }

    @Override
    public void saveStudent(Student student) {
        studentRepo.save(student);
    }

}
