package nigglenandu.Student_Management_Crud.Service;
import nigglenandu.Student_Management_Crud.Entity.StudentEntity;
import nigglenandu.Student_Management_Crud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void saveStudent(StudentEntity student) {
        studentRepository.save(student);
    }

    @Override
    public boolean updateStudent(Long id, StudentEntity student) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            StudentEntity studentToUpdate = optional.get();
            studentToUpdate.setStudentName(student.getStudentName());
            studentToUpdate.setGrade(student.getGrade());
            studentToUpdate.setGender(student.getGender());
            studentRepository.save(studentToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteStudentById(Long id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
