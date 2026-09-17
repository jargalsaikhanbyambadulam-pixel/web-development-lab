class OrderLogger {
    private static OrderLogger instance;
    private OrderLogger() {}

    public static OrderLogger getInstance() {
        if (instance == null) {
            instance = new OrderLogger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}