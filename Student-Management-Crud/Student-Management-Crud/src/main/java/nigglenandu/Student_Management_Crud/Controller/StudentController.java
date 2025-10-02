package nigglenandu.Student_Management_Crud.Controller;

import nigglenandu.Student_Management_Crud.Entity.StudentEntity;
import nigglenandu.Student_Management_Crud.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Marks this class as a REST controller → it handles HTTP requests and responses
@RestController
@RequestMapping("/api/students")  // Base URL for all student-related endpoints
public class StudentController {

    // Injects service layer dependency (for business logic)
    @Autowired
    private IStudentService studentService;

    // GET → Fetch all students
    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        // returns list of students with HTTP 200 OK
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    // GET → Fetch a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id) {
        // returns student by ID with HTTP 200 OK
        return new ResponseEntity<>(studentService.getStudentById(id), HttpStatus.OK);
    }

    // POST → Create new student
    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentEntity student) {
        // saves student in DB
        studentService.saveStudent(student);
        return new ResponseEntity<>("Student created successfully!", HttpStatus.CREATED);
    }

    // PUT → Update student by ID
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateStudent(@PathVariable Long id, @RequestBody StudentEntity student) {
        // updates student info and returns true/false
        return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);
    }

    // DELETE → Remove student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Long id) {
        // deletes student by ID and returns true/false
        return new ResponseEntity<>(studentService.deleteStudentById(id), HttpStatus.OK);
    }
}
