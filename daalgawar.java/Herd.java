import java.util.ArrayList;

class Herd {
    ArrayList<Livestock> animals = new ArrayList<>();

    public void addLivestock(Livestock animal) {
        animals.add(animal);
    }

    public void dailyRoutine() {
        for (Livestock animal : animals) {
            animal.makeSound();
            animal.graze();

            if (animal instanceof WorkRole) {
                WorkRole worker = (WorkRole) animal;
                System.out.println(worker.performTask());
            }
        }
    }
}