package MicroServicesEg.School_Service.clients;

import MicroServicesEg.School_Service.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "student-service", url = "http://localhost:8082")
public interface StudentClient {
    @GetMapping("/student/{id}")
    StudentDto getStudentById(@PathVariable("id") Long id);

    @PostMapping("/student/create")
    ResponseEntity<String> createStudent(@RequestBody StudentDto student);
}
