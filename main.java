import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;

    public Book(String title, String author, String isbn, int year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Year: " + year;
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to the library: " + book.getTitle());
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found in the library.");
    }

    public void removeBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                books.remove(book);
                System.out.println("Book removed from the library: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book with ISBN '" + isbn + "' not found in the library.");
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565", 1925));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084", 1960));
        library.addBook(new Book("1984", "George Orwell", "978-0451524935", 1949));

        library.showBooks();

        library.searchBookByTitle("To Kill a Mockingbird");

        library.removeBookByIsbn("978-0743273565");

        library.showBooks();
    }
}