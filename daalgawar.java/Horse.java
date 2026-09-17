class Horse extends Livestock implements WorkRole {

    public Horse(String name, int age) {
        super(name, age);
    }

    public void makeSound() {
        System.out.println("Yntsgaana");
    }

    public String performTask() {
        return "Mori talbaid unalgad hereglene.";
    }
}