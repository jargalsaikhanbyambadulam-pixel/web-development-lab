import java.util.ArrayList;

public class Teacher implements Comparable<Teacher> {
    private String name;
    private String department;
    private ArrayList<Student> students = new ArrayList<>();

    public Teacher(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public String getName() {
        return name;
    }

    // Comparable → нэрээр эрэмбэлнэ
    @Override
    public int compareTo(Teacher o) {
        return this.name.compareTo(o.name);
    }

    public String toString() {
        return "Teacher: " + name + " (" + department + ")\nStudents: " + students;
    }
}