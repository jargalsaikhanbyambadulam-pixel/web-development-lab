abstract class Livestock {
    String name;
    int age;

    public Livestock(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();

    public void graze() {
        System.out.println(name + "Talbaid belchine.");
    }

    public void graze(String food) {
        System.out.println(name + "" + food + " idej baina. ");
    }
}