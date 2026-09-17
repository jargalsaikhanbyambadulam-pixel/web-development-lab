public class Main {
    public static void main(String[] args) {

        //Aguulah vvsgene
        Warehouse warehouse = new Warehouse();

        //Baraa vvsgene
        Product p1 = new Product(1, "Laptop", 10);
        Product p2 = new Product(2, "Phone", 20);

        //Aguulahad nemne
        warehouse.addProduct(p1);
        warehouse.addProduct(p2);

        //Baraanuudiig hewlene
        for (Product p : warehouse.getProducts()) {
            System.out.println("ID: " + p.getId() + 
                              ", Name: " + p.getName() + 
                              ", Quantity: " + p.getQuantity());
        }

        //Nyraw
        Clerk clerk = new Clerk("Bat");

        //Orlogo vvsgeh
        Receipt receipt = clerk.createReceipt();
        receipt.printReceipt();

        //tailan
        Report report = clerk.viewReport();
        report.generateStoctReport();
    }
}