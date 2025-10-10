package MicroServicesEg.Student_Service;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Marks this class as a JPA entity (maps to a database table)
@Entity
public class Student {

    // Marks 'id' as the primary key
    @Id
    // Auto-generates the ID value (incremented automatically by the database)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    // Student name
    private String name;

    // Class or grade the student belongs to
    private String className;

    // Age of the student
    private int age;

    // Parameterized constructor (used to create Student objects easily)
    public Student(int age, String className, long id, String name) {
        this.age = age;
        this.className = className;
        this.id = id;
        this.name = name;
    }

    // Default constructor (required by JPA)
    public Student() {
    }

    // Getter and Setter methods to access and modify private fields

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
