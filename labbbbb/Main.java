class PurchaseRequest {
    private String itemName;
    private double price;

    public PurchaseRequest(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
}


abstract class Approver {
    protected String name;
    protected double allowableLimit;
    protected boolean isBusy; // Завгүй эсэх төлөв
    protected Approver nextApprover; // Хэлхээний дараагийн хүн

    public Approver(String name, double allowableLimit) {
        this.name = name;
        this.allowableLimit = allowableLimit;
        this.isBusy = false; // Анхны төлөв: Завтай
    }

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }

    
    public void setAllowableLimit(double allowableLimit) {
        this.allowableLimit = allowableLimit;
    }

    
    public void setBusy(boolean isBusy) {
        this.isBusy = isBusy;
    }

   
    public void processRequest(PurchaseRequest request) {
        
        if (request.getPrice() <= this.allowableLimit && !this.isBusy) {
            System.out.println(name + " '" + request.getItemName() + "' baraanii hudaldan awaltiig (" + 
                               request.getPrice() + " ₮) BATALGAA.");
        } else {
            
            if (nextApprover != null) {
                if (this.isBusy && request.getPrice() <= this.allowableLimit) {
                    System.out.println(name + " zawgvi baigaa tul daraagiin shat ruu shiljlee.");
                }
                nextApprover.processRequest(request);
            } else {
                System.out.println("'" + request.getItemName() + "' baraanii hvseltiig (" + 
                                   request.getPrice() + " ₮) batlah erhtei esvel zawgvi udirdlaga oldsongvi!");
            }
        }
    }
}


class Manager extends Approver {
    public Manager(String name, double limit) { super(name, limit); }
}

class HeadOfDepartment extends Approver {
    public HeadOfDepartment(String name, double limit) { super(name, limit); }
}

class Director extends Approver {
    public Director(String name, double limit) { super(name, limit); }
}

class Chairman extends Approver {
    public Chairman(String name, double limit) { super(name, limit); }
}


public class Main {
    public static void main(String[] args) {
        
        Approver manager = new Manager("Heltsiin meneger", 100000);
        Approver head = new HeadOfDepartment("Gazriin darga", 1000000);
        Approver director = new Director("Zahiral", 3000000);
        Approver chairman = new Chairman("TUZ-iin darga (Chairman)", Double.MAX_VALUE);

        
        manager.setNextApprover(head);
        head.setNextApprover(director);
        director.setNextApprover(chairman);

        System.out.println("--- TEST 1: Hewiin vyiin turshilt ---");
        PurchaseRequest req1 = new PurchaseRequest("Gar utas", 85000);      
        PurchaseRequest req2 = new PurchaseRequest("Zuuwriin kompiyuter", 850000); 
        PurchaseRequest req3 = new PurchaseRequest("Server tuhuurumj", 2500000); 
        PurchaseRequest req4 = new PurchaseRequest("Alban tasalgaani zaswar", 5000000); 
        manager.processRequest(req1);
        manager.processRequest(req2);
        manager.processRequest(req3);
        manager.processRequest(req4);

        System.out.println("\n--- TEST 2: Ajillah ywtsad tuluw uurvhlugduh (Gazriin darga zawgvi boloh) ---");
        head.setBusy(true); 
        System.out.println("[Medeldel] Gazriin darga zawgvi tuluwt shiljlee.");
        
        manager.processRequest(req2);

        System.out.println("\n--- TEST 3: Ajillah ywtsad vniin lemit uurchlugdluu ---");
        
        manager.setAllowableLimit(900000);
        head.setBusy(false); 
        System.out.println("[Medegdel] Menegeriin batlah limitiig 900,000 ₮ bolgoj uurchluw.");
        
        
        manager.processRequest(req2);
    }
}