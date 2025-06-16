package MicroServicesEg.School_Service;

import MicroServicesEg.School_Service.clients.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    public StudentClient studentClient;

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentClient.getStudentById(id));
    }

    @PostMapping("student/create")
    public ResponseEntity<String> createStudent(@RequestBody StudentDto studentDto) {
        studentClient.createStudent(studentDto);  // Call service method to save student
        return ResponseEntity.ok("Student created successfully!");
    }
}
