package nigglenandu.Student_Management_Crud.Repository;

import nigglenandu.Student_Management_Crud.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing CRUD operations on StudentEntity.
 * It communicates directly with the database.
 */
@Repository // Marks this interface as a Spring Data Repository (helps with dependency injection)
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    // JpaRepository provides all basic CRUD methods:
    // - save()         → insert or update a record
    // - findById()     → find a student by ID
    // - findAll()      → get all students
    // - deleteById()   → delete student by ID
    // No need to write custom SQL — JPA handles it automatically!
}
