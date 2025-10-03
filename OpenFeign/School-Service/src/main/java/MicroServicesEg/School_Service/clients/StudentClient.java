package MicroServicesEg.School_Service.clients;

import MicroServicesEg.School_Service.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

// Feign client → helps one microservice (School-Service) call another (Student-Service)
// 'name' = service identifier, 'url' = base URL of student-service
@FeignClient(name = "student-service", url = "http://localhost:8082")
public interface StudentClient {

    // Call GET API of Student-Service → fetch student by ID
    @GetMapping("/student/{id}")
    StudentDto getStudentById(@PathVariable("id") Long id);

    // Call POST API of Student-Service → create a new student
    @PostMapping("/student/create")
    ResponseEntity<String> createStudent(@RequestBody StudentDto student);
}
