package MicroServicesEg.School_Service;

import MicroServicesEg.School_Service.clients.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")   // Base path for all school-related APIs
public class SchoolController {

    // Injecting Feign client to communicate with Student-Service
    @Autowired
    public StudentClient studentClient;

    // ✅ API: Get a student by ID
    // This method sends a GET request to Student-Service via Feign client
    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) {
        // Feign client calls Student-Service and returns the StudentDto
        return ResponseEntity.ok(studentClient.getStudentById(id));
    }

    // ✅ API: Create a new student
    // This method sends a POST request to Student-Service via Feign client
    @PostMapping("/student/create")
    public ResponseEntity<String> createStudent(@RequestBody StudentDto studentDto) {
        // Feign client sends data to Student-Service to create student
        studentClient.createStudent(studentDto);

        // Response message from School-Service
        return ResponseEntity.ok("Student created successfully!");
    }
}
