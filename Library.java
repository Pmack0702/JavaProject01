import java.time.LocalDate;
import java.util.Arrays;

public class Library {
    // Attributes of Library
    private Book[] books; // Array to store Books
    private int maxBooks; // Maximum number of Books
    private int currentCount; // Current number of Books

    // Constructor to initialize the library
    public Library(int maxBooks) {
        this.maxBooks = maxBooks;
        this.books = new Book[maxBooks];
        this.currentCount = 0;
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        if (currentCount < maxBooks) {
            books[currentCount] = book;
            currentCount++;
            System.out.println("Book added Successfully. Yah\n");
        } else {
            System.out.println("Library is full. Sorry, cannot add more books.");
        }
    }


    // Method to borrow a book by ISBN
    public void borrowBook(String ISBN) {
        boolean bookFound = false;
        boolean bookBorrowed = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getISBN().equals(ISBN)) {
                bookFound = true;

                if (books[i].isAvailable()) {
                    books[i].borrowBook();
                    System.out.println("Book borrowed successfully. Yahh\n");
                    bookBorrowed = true;
                    break;
                }
            }
        }

        if (!bookFound) {
            System.out.println("Oops, book not found.\n");
        } else if (!bookBorrowed) {
            System.out.println("Bro, book is already borrowed.\n");
        }
    }

    // Method to return a borrowed book by ISBN
    public void returnBook(String ISBN) {
        boolean bookFound = false;
        boolean bookReturned = false;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && books[i].getISBN().equals(ISBN)) {
                bookFound = true;

                if (!books[i].isAvailable()) {
                    books[i].returnBook();
                    System.out.println("Book returned successfully. Thank you :)\n");
                    bookReturned = true;
                    break;
                }
            }
        }

        if (!bookFound) {
            System.out.println("Book not found.\n");
        } else if (!bookReturned) {
            System.out.println("Book is not currently borrowed.\n");
        }
    }

    // Method to display books borrowed in the last 7 days
    public void displayBooksBorrowedLast7Days() {
        LocalDate currentDate = LocalDate.now();
        LocalDate oneWeekAgo = currentDate.minusDays(7);

        System.out.println("Books borrowed in the last 7 days:");

        for (int i = 0; i < currentCount; i++) {
            Book book = books[i];

            if (book != null && book.isBorrowed() && book.getBorrowDate() != null
                    && book.getBorrowDate().isAfter(oneWeekAgo)) {
                book.displayInfo();
                System.out.println();
            }
        }
    }

    // Method to display details of all books in the library
    public void displayAllBooks() {
        System.out.println("-->Books in the library:");

        for (int i = 0; i < currentCount; i++) {
            if (books[i] != null) {
                books[i].displayInfo();
                System.out.println();
            }
        }
    }


    @Override
    public String toString() {
        return "Library{" +
                "books=" + Arrays.toString(books) +
                ", maxBooks=" + maxBooks +
                ", currentCount=" + currentCount +
                '}';
    }
}
