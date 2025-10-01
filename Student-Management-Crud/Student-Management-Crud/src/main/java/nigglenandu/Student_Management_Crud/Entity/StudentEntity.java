package nigglenandu.Student_Management_Crud.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Marks this class as a JPA Entity (table in DB will be created for this class)
@Entity
public class StudentEntity {

    // Primary key of the table
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Auto-increment ID
    private long id;

    // Other fields/columns of the table
    private String studentName;
    private int grade;
    private String gender;

    // Parameterized constructor (used when we want to create an object with values)
    public StudentEntity(String gender, String studentName, long id, int grade) {
        this.gender = gender;
        this.studentName = studentName;
        this.id = id;
        this.grade = grade;
    }

    // Default constructor (required by JPA)
    public StudentEntity() {
    }

    // Getters and setters → allow access to private fields
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
