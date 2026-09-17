public class Main {
    public static void main(String[] args) {
        Library lib = new Library();

        lib.addBook(new Book("Svvn zam", 2020));
        lib.addBook(new Book("Huuchin dewter", 1995));

        for (Book b : lib.getBooksAfterYear(2000)) {
            System.out.println(b.title + ": " + b.year);
        }
    }
}