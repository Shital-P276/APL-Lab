import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;

    public Book() {
        this.title = "";
        this.author = "";
        this.isbn = "";
        this.price = 0.0;
    }

    public Book(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isbn = "";
        this.price = 0.0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return title + ", Author: " + author + ", ISBN: " + isbn + ", Price: " + price;
    }
}

class Library {
    private String libraryName;
    private String address;
    private ArrayList<Book> books;

    public Library() {
        this.libraryName = "Unnamed Library";
        this.address = "No Address";
        this.books = new ArrayList<>();
    }

    public Library(String libraryName, String address) {
        this.libraryName = libraryName;
        this.address = address;
        this.books = new ArrayList<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("The library is empty.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public double calculateTotalValue() {
        double total = 0.0;
        for (Book book : books) {
            total += book.getPrice();
        }
        return total;
    }

    public Book searchBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void displayLibraryDetails() {
        System.out.println("Library Name: " + this.libraryName);
        System.out.println("Library Address: " + this.address);
        System.out.println("Books in the Library:");
        displayBooks();
    }
}

public class Pmkexp1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Library Information:");
        System.out.print("Library Name: ");
        String libraryName = scanner.nextLine();
        System.out.print("Library Address: ");
        String libraryAddress = scanner.nextLine();

        Library library = new Library(libraryName, libraryAddress);

        while (true) {
            System.out.println("\nEnter Book Details (or type 'done' to finish):");
            System.out.print("Title: ");
            String title = scanner.nextLine();

            if (title.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Author: ");
            String author = scanner.nextLine();
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            Book book = new Book(title, author, isbn, price);
            library.addBook(book);
            System.out.println("Book added to the library.");
        }

        System.out.println("\nLibrary Details:");
        library.displayLibraryDetails();

        double totalValue = library.calculateTotalValue();
        System.out.println("Total value of books in library: " + String.format("%.2f", totalValue));

        System.out.println("\nEnter ISBN to search for a book (or type 'done' to skip):");
        String searchIsbn = scanner.nextLine();

        if (!searchIsbn.equalsIgnoreCase("done")) {
            Book foundBook = library.searchBookByISBN(searchIsbn);
            if (foundBook != null) {
                System.out.println("Book found: " + foundBook);
            } else {
                System.out.println("Book with ISBN " + searchIsbn + " not found.");
            }
        }

        scanner.close();
    }
}