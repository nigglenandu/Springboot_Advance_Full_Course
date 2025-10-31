package nigglenandu.Student_Management_Crud.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a Student entity that maps to the "students" table in the database.
 */
@Entity // Marks this class as a JPA entity (will be stored in the database)
@Table(name = "students") // Defines the table name as "students"
@Data // Lombok annotation that automatically generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields
public class StudentEntity {

    @Id // Marks 'id' as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Auto-generates the ID value (database auto-increment)
    private Long id;

    // Stores the student's full name
    private String name;

    // Stores the student's address
    private String address;

    // Stores the student's email address
    private String email;
}
