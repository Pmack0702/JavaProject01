import java.time.LocalDate;

public class Book {
    // Attributes of Book
    private String title;
    private String author;
    private String ISBN;
    private boolean isBorrowed;
    private LocalDate borrowDate;

    // Constructor to initialize book properties
    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.borrowDate = null;
    }

    // Getters for ISBN, borrow status, and borrow date
    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getISBN() {
        return ISBN;
    }

    // Method to mark the book as borrowed and set the borrow date
    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            borrowDate = LocalDate.now(); // Set the borrow date
        }
    }

    // Method to mark the book as returned and reset the borrow date
    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            borrowDate = null; // Reset borrow date
        }
    }

    // Method to check if the book is available
    public boolean isAvailable() {
        return !isBorrowed;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + ISBN);
        System.out.println("Status: " + (isBorrowed ? "Borrowed" : "Available"));
        if (isBorrowed) {
            System.out.println("Borrowed Date: " + borrowDate);
        }
    }

    // Method to display book information
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", isBorrowed=" + isBorrowed +
                ", borrowDate=" + borrowDate +
                '}';
    }
}
