package MicroServicesEg.School_Service;

// This is a Data Transfer Object (DTO) for Student
// DTOs are used to transfer data between services or layers
public class StudentDto {

    // Unique identifier for the student
    private long id;

    // Name of the student
    private String name;

    // Class/grade of the student
    private String className;

    // Age of the student
    private int age;

    // Getter and Setter for age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getter and Setter for className
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    // Getter and Setter for id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
