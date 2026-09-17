class Camel extends Livestock implements WorkRole {

    public Camel(String name, int age) {
        super(name, age);
    }

    public void makeSound() {
        System.out.println("Builna.");
    }

    public String performTask() {
        return "Temee gowiin teewert hereglene.";
    }
}