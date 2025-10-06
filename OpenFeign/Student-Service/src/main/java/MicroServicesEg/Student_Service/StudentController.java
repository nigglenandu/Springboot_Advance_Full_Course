package MicroServicesEg.Student_Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// @RestController: Marks this class as a REST API controller
// It handles HTTP requests (GET, POST, etc.) and returns responses (usually JSON)
@RestController

// @RequestMapping: Defines the base URL for all endpoints inside this controller
@RequestMapping("/student")
public class StudentController {

    // @Autowired: Automatically injects the service layer object
    // Helps to call service methods without creating an object manually
    @Autowired
    private IStudentService studentService;

    // @GetMapping: Handles GET request to fetch data
    // Example: /student/1 → fetch student with id 1
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        // Call service method to get student by id
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // @PostMapping: Handles POST request to create new data
    // Example: /student/create → create new student
    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody Student student) {
        // Call service method to save student in database
        studentService.saveStudent(student);
        return ResponseEntity.ok("Student created successfully!");
    }
}
