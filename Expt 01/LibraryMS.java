// Shital M. Patil
// Batch   : B-II
// Roll.No : B-77  
// Program : Expt 01-A (Library Management System) 

import java.util.ArrayList;
import java.util.Scanner;

class Book{
    private String Title;
    private String Author;
    private String ISBN;
    private double price;

    //Default Constructor
    public Book(){
        this.Title = "";
        this.Author = "";
        this.ISBN = "";
        this.price = 0.0;
    }

    //Parameterized Constructor
    public Book(String inTitle,String inAuthor,String inISBN,double inPrice){
        this.Title = inTitle;
        this.Author = inAuthor;
        this.ISBN = inISBN;
        this.price = inPrice;
    }

    //Overloaded Constructor
    public Book(String inTitle,String inAuthor){
        this.Title = inTitle;
        this.Author = inAuthor;
        this.ISBN = "";
        this.price = 0.0;
    }

    public double getPrice() {
        return price;
    }
    
    public String getISBN() {
        return ISBN;
    }

    public void displayBook() {
        System.out.println("Title: " + Title + " | Author: " + Author + " | ISBN: " + ISBN + " | Price: $ " + price);
    }

}

class Library{
    private String libName;
    private String libAddress;
    private ArrayList<Book> books;

    //Default Constructor
    public Library(){
        this.libName = "";
        this.libAddress = "";
        this.books = new ArrayList<>();
    }

    //Parameterized Constructor
    public Library(String libName, String libAddress) {
        this.libName = libName;
        this.libAddress = libAddress;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book Added Succesfully");
    }
    
    public void dispBooks() {
        System.out.println("\nLibrary Details:");
        System.out.println(" Library Name: " + libName);
        System.out.println(" Library Address: " + libAddress);
        System.out.println("Books in the Library:");

        if(books.isEmpty()){
            System.out.println("No books in library.");
        } else {
            int i = 0;
            for (Book bok : books){
                System.out.print((++i) + "]");
                bok.displayBook();
            }
            i = 0;
        }
    }

    public double getTotalPrice() {
        double total = 0;
        for(Book bok : books){
            total += bok.getPrice();
        }
        return total;
    }

    public void searchByISBN(String isbn) {
        for(Book bok : books){
            if((bok.getISBN()).equals(isbn)){
                System.out.println("Book Found:");
                bok.displayBook();
                return;
            }
        }
        System.out.println("Book with ISBN:" + isbn + " not found in library");
    }
}

public class LibraryMS{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("\nEnter Library Info: ");
        System.out.print("Library Name: ");
        String inLibName = scn.nextLine();
        System.out.print("Library Address: ");
        String inLibAdd = scn.nextLine();

        Library library = new Library(inLibName, inLibAdd);
        char choice;

        while (true) {    
            System.out.print("\n\nMenu: \n 1](A)dd Books\n 2](D)isplay Books\n 3](T)otal Cost of books\n 4](S)earch by ISBN\n 5](E)xit\nEnter Choice: ");
            choice = ((scn.next()).toUpperCase()).charAt(0);
            scn.nextLine();
            switch (choice) {
                //Add new book
                case 'A':
                    while (true) {
                        System.out.print("\nEnter Book Details (leave ISBN,Price as 0 if not known)\nTitle: ");
                        String title = scn.nextLine();
                        System.out.print("Author: ");
                        String author = scn.nextLine();
                        System.out.print("ISBN: ");
                        String isbn = scn.nextLine();
                        System.out.print("Price: ");
                        double price = scn.nextDouble();
                        scn.nextLine();
                        
                        Book bok;
                        if(isbn.equals("0") && price == 0){
                            bok = new Book(title, author); // uses overloaded constructor
                        } else {
                            bok = new Book(title,author,isbn,price);// uses full parameterized constructor
                        };
                        library.addBook(bok);

                        System.out.print("\nDo you want to add another book? (Y/N): ");
                        String choice1 = scn.nextLine();
                        if (!choice1.strip().equalsIgnoreCase("y")) {
                            break;
                        }
                    }
                    break;
                 
                //Display all books
                case 'D':
                    library.dispBooks();
                    break;

                //Total Value of books
                case 'T':
                    System.out.println("\nTotal value of books in library: $" + library.getTotalPrice());
                    break;

                //Seach by ISBN
                case 'S':
                    System.out.print("\nEnter ISBN: ");
                    String srchISBN = scn.nextLine().strip();
                    library.searchByISBN(srchISBN);
                    break;

                //Exit
                case 'E':
                    System.out.println("Exiting...\n");
                    scn.close();
                    return;

                default:
                    System.out.println("Invalid Input , please try again");
                    break;
            }
        }
    }
}