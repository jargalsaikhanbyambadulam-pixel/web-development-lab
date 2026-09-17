import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//Abstrank class
abstract class Livestock {
    String name;
    int age;

    public Livestock(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract String makeSound();

    void graze() {
        System.out.println(name + "Talbaid belchine.");
    }

    void graze(String food) {
        System.out.println(name + "" + food + "-iig belchine.");
    }
}

//Interface
interface WorkRole {
    String performTask();
}

//mori class
class Hourse extends Livestock implements WorkRole {
    public Hourse(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Yntsgaana!";
    }

    @Override
    public String performTask() {
        return "Mori talbaid unalgad hereglene.";
    }
}

//Temee class
class Camel extends Livestock implements WorkRole {
    public Camel(String name, int age) {
        super(name, age);
    }

    @Override
    String makeSound() {
        return "Builna!";
    }

    @Override 
    public String performTask() {
        return "Temee gowiin teewert hereglene.";
    }
}

//Vher class
class Cow extends Livestock {
    public Cow(String name; int age){
        super(name, age);
    }

    @Override 
    String makeSound() {
        return "Muurunu!";
    }
}

//Svreg class
class Herd {
    ArrayList<Livestock>livestock = new ArrayList<>();

    void addLivestock(Livestock animal) {
        livestock.add(animal);
    }

    void dailyRoutine() {
        for (Livestock animal : livestock) {
            System.out.println(animal.name + ":" +animal.makeSound());
            if (animal instanceof WorkRole) {
                System.out.println(((WprkRole)animal).performTask());
            }
        }
    }
}

//vndsen class 
public class NomadLivestockDemo {
    public static void main(String[] args) {
        Herd herd = new Herd();
        herd.addLivestock(new Hourse("Sharga", 4));
        herd.addLivestock(new Sheep("Halzan", 2));
        herd.addLivestock(new Camel("Hvren", 6));

        gerd.dailyRoutine();
    }
}