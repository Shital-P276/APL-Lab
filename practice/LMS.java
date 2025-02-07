
import java.util.Scanner;

class Book{
private String Title;
private String Author;
private String ISBN;
private double Price;

public Book() {  // default Constructor
    Title="";
    Author="";
    ISBN="";
    Price=0.0;
}

public Book(String title,String author,String isbn,double price){   //paremeterized constructor
    this.Title=title;
    this.Author=author;
    this.ISBN=isbn;
    this.Price=price;
}
public void displaybooks() {
    System.out.println("Title: "+ Title +"Author: "+ Author +"ISBN: "+ ISBN +"Price: "+ Price );
}
public double  getprice() {
    return  Price;
}
public  String getisbn() {
    return ISBN;
}


}
class Library{
private String Name;
private String Address;
private Book[] books;
private int bcount;


 public Library() {   //default constructor
    Name="";
    Address="";
    books = new Book[100];
    bcount=0;
}

public Library(String Name, String Address) {
        this.Name = Name;
        this.Address = Address;
        this.books = new Book[100];
        this.bcount = 0;
    }
public void addbook(Book book){
    if (bcount < books.length) {
        books[bcount++]=book;
    }else {
        System.out.println("Library is you can't add books");
    }
}
public void displayditails() {
    System.out.println("Library name: "+Name);
    System.out.println("Library Address: "+Address);
    System.out.println("Books in the Library: ");
    for (int i = 0; i < books.length; i++) {
        System.out.println((i+1)+ ".");
        books[i].displaybooks();
    }
    System.out.println("Total price of book: " + calculateTotalValue());
}

public double calculateTotalValue() {
    double total=0;
    for (int i = 0; i < books.length; i++) {
        total += books[i].getprice();
    }
    return total;
}
public void SBISBN(String isbn) {
    for (int i = 0; i < bcount; i++) {
        if (books[i].getisbn().equals(isbn)) {
            System.out.println("Book Found:");
            books[i].displaybooks();
            return;
        }
    }
    System.out.println("Book with ISBN : " + isbn + " not found.");
}
}
public class LMS {
    public static void main(String[] args) {
        System.out.println("heyy");
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter details: ");
        System.out.println("Enter library name : ");
        String libname=scn.nextLine();
        System.out.println("enter Lib address: ");
        String libadd=scn.nextLine();

        Library lib = new Library(libname,libadd);

        while (true) { 
        System.out.println("Enter Book Title (or exit)");
        String title=scn.nextLine();

        if (title.equalsIgnoreCase("exit")) {
            break;
        }

        System.out.println("Enter Book Author:");
        String bookau=scn.nextLine();

        System.out.println("Enter Book ISBN:");
        String bisbn=scn.nextLine();

        System.out.println("Enter Book Price: ");
        double bprice=scn.nextDouble();

        Book b = new Book(title,bookau,bisbn,bprice);
        lib.addbook(b);

        System.out.println("Book added to the library.");
        }
        Book b1 = new Book();
         b1.displaybooks();

        System.out.println("Enter ISBN to search Book: ");
        String bookisbn=scn.nextLine();

        lib.SBISBN(bookisbn);

        scn.close();
    }

}
