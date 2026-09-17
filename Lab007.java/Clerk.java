public class Clerk {
    private String name;

    public Clerk(String name) {
        this.name = name;
    }

    public Receipt createReceipt() {
        return new Receipt();
    }

    public Report viewReport() {
        return new Report();
    }
}