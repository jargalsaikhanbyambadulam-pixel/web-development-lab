import java.util.*;

class Book {
    String title;
    int year;

    Book(String title, int year) {
        this.title = title;
        this.year = year;
    }
}

public class Library {

    private List<Book> books = new ArrayList<>();

    public void addBook(Book b) {
        books.add(b);
    }

    public Iterable<Book> getBooksAfterYear(int minYear) {
        return new BookShelf(minYear);
    }

    private class BookShelf implements Iterable<Book> {
        private int minYear;

        BookShelf(int minYear) {
            this.minYear = minYear;
        }

        public Iterator<Book> iterator() {
            return new Iterator<Book>() {
                private int index = 0;

                public boolean hasNext() {
                    while (index < books.size()) {
                        if (books.get(index).year > minYear) {
                            return true;
                        }
                        index++;
                    }
                    return false;
                }

                public Book next() {
                    return books.get(index++);
                }
            };
        }
    }
}