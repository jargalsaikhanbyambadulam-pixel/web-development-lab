public class Main {
    public static void main(String[] args) {

        Herd herd = new Herd();

        herd.addLivestock(new Horse("Sharga:", 5));
        herd.addLivestock(new Sheep("Halzan:", 3));
        herd.addLivestock(new Camel("Hvren:", 7));

        herd.dailyRoutine();
    }
}