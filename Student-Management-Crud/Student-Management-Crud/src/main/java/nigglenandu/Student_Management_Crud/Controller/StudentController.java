package nigglenandu.Student_Management_Crud.Controller;

import lombok.RequiredArgsConstructor;
import nigglenandu.Student_Management_Crud.Entity.StudentEntity;
import nigglenandu.Student_Management_Crud.Service.IStudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this class as a REST controller (JSON responses)
@RequestMapping("/api/students") // Base URL for all student endpoints
@RequiredArgsConstructor // Lombok generates constructor for final fields
public class StudentController {

    private final IStudentService studentService; // Inject service layer

    // ✅ CREATE: Add a new student
    @PostMapping
    public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity student) {
        // Request body is automatically converted to StudentEntity
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.createStudent(student)); // Returns created student with 201 status
    }

    // ✅ READ ALL: Get list of all students
    @GetMapping
    public ResponseEntity<List<StudentEntity>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents()); // 200 OK with list
    }

    // ✅ READ BY ID: Get a student by ID
    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(ResponseEntity::ok) // If student found, return 200 OK with student
                .orElse(ResponseEntity.notFound().build()); // Else 404 Not Found
    }

    // ✅ UPDATE: Update student details by ID
    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Long id, @RequestBody StudentEntity student) {
        return studentService.updateStudent(id, student)
                .map(ResponseEntity::ok) // Return updated student if found
                .orElse(ResponseEntity.notFound().build()); // Else 404 Not Found
    }

    // ✅ DELETE: Delete a student by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id)
                ? ResponseEntity.noContent().build() // 204 No Content if deleted
                : ResponseEntity.notFound().build(); // 404 if student not found
    }
}
