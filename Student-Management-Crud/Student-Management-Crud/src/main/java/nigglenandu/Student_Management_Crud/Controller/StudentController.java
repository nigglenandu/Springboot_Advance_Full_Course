package nigglenandu.Student_Management_Crud.Controller;

import nigglenandu.Student_Management_Crud.Entity.StudentEntity;
import nigglenandu.Student_Management_Crud.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentEntity student) {
        studentService.saveStudent(student);
        return new ResponseEntity<>("Student created successfully!", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateStudent(@PathVariable Long id, @RequestBody StudentEntity student) {
        return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.deleteStudentById(id), HttpStatus.OK);
    }
}
