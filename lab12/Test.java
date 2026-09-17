import java.util.Collections;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {

        LinkedList<Teacher> list = new LinkedList<>();

        Teacher t1 = new Teacher("Bat", "IT");
        t1.addStudent(new Student("Anu", "S01", 3.5));
        t1.addStudent(new Student("Bold", "S02", 3.8));

        Teacher t2 = new Teacher("Dulguun", "Math");
        t2.addStudent(new Student("Sara", "S03", 3.9));

        Teacher t3 = new Teacher("Anar", "Physics");

        list.add(t1);
        list.add(t2);
        list.add(t3);

        // эрэмбэлэх
        Collections.sort(list);

        // хэвлэх
        for (Teacher t : list) {
            System.out.println(t);
            System.out.println("------------------");
        }
    }
}