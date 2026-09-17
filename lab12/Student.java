public class Student {
    private String name;
    private String code;
    private double gpa;

    public Student(String name, String code, double gpa) {
        this.name = name;
        this.code = code;
        this.gpa = gpa;
    }

    public String toString() {
        return name + " (" + code + "), GPA: " + gpa;
    }
}