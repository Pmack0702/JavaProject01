import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library(20);

        while (true) {

            // Menu-Driven Program
            System.out.println("Welcome to Library Management");
            System.out.println("1. Add a Book");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Display All Books");
            System.out.println("5. Display Books Borrowed in the Last 7 Days");
            System.out.println("6. Exit");

            System.out.println("Enter your choice: "); // Prompt user Input
            int choice;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        // Adding the Book
                        System.out.println("--------------------------------------------------");
                        System.out.println("                   Add a Book                     ");
                        System.out.println("--------------------------------------------------");

                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter ISBN: ");
                        String ISBN = scanner.nextLine();

                        Book newBook = new Book(title, author, ISBN);
                        library.addBook(newBook);
                        break;

                    case 2:
                        // Borrowing the Book
                        System.out.println("--------------------------------------------------");
                        System.out.println("                   Borrow Book                     ");
                        System.out.println("--------------------------------------------------");
                        System.out.print("Enter ISBN to borrow: ");
                        String borrowISBN = scanner.nextLine();
                        library.borrowBook(borrowISBN);
                        break;

                    case 3:
                        // Returning the Book
                        System.out.println("--------------------------------------------------");
                        System.out.println("                  Return Book                     ");
                        System.out.println("--------------------------------------------------");
                        System.out.print("Enter ISBN to return: ");
                        String returnISBN = scanner.nextLine();
                        library.returnBook(returnISBN);
                        break;

                    case 4:
                        // Displaying the Book
                        System.out.println("--------------------------------------------------");
                        System.out.println("                  Display All Book                ");
                        System.out.println("--------------------------------------------------");
                        library.displayAllBooks();
                        break;

                    case 5:
                        // Displaying books borrowed in the last 7 days
                        System.out.println("--------------------------------------------------");
                        System.out.println("    Display Books Borrowed in the Last 7 Days    ");
                        System.out.println("--------------------------------------------------");
                        library.displayBooksBorrowedLast7Days();
                        break;

                    case 6:
                        // Exiting the Program
                        System.out.println("Exiting Library Management System. Come Back Soon!!!");
                        scanner.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again broo.");
                        System.out.println(" ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer(1-6) choice.");
                scanner.nextLine();
            }
        }
    }
}
