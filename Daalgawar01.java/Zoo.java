import java.util.*;

class Animal {
    String name;

    Animal(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Lion extends Animal {
    Lion(String name) {
        super(name);
    }
}

class Tiger extends Animal {
    Tiger(String name) {
        super(name);
    }
}

public class Zoo<T extends Animal> {

    public void transferAnimals(List<? extends T> source, List<? super T> destination) {
        for (T animal : source) {
            destination.add(animal);
        }
        source.clear();
    }
}