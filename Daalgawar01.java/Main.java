import java.util.*;

public class Main {
    public static void main(String[] args) {
        Zoo<Animal> zoo = new Zoo<>();

        List<Lion> source = new ArrayList<>();
        source.add(new Lion("Arslan"));
        source.add(new Lion("Erslen"));

        List<Animal> destination = new ArrayList<>();

        zoo.transferAnimals(source, destination);

        for (Animal a : destination) {
            System.out.println(a);
        }
    }
}