import java.util.Scanner;

class BookNode {
    String title;
    String author;
    String genre;
    int bookID;
    boolean isAvailable;
    BookNode next;
    BookNode prev;

    public BookNode(String title, String author, String genre, int bookID, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.isAvailable = isAvailable;
    }
}

public class LibrarySystem {
    private BookNode head = null;
    private BookNode tail = null;

    public void addBookAtBeginning(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newBook = new BookNode(title, author, genre, bookID, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    public void addBookAtEnd(String title, String author, String genre, int bookID, boolean isAvailable) {
        BookNode newBook = new BookNode(title, author, genre, bookID, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    public void removeBookByID(int bookID) {
        BookNode current = head;
        while (current != null && current.bookID != bookID) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Book not found.");
            return;
        }
        if (current == head) {
            head = current.next;
        }
        if (current == tail) {
            tail = current.prev;
        }
        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        System.out.println("Book with ID " + bookID + " removed.");
    }

    public void searchByTitle(String title) {
        BookNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                printBook(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No books found with title " + title);
    }

    public void searchByAuthor(String author) {
        BookNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                printBook(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No books found by " + author);
    }

    public void updateAvailability(int bookID, boolean isAvailable) {
        BookNode current = head;
        while (current != null) {
            if (current.bookID == bookID) {
                current.isAvailable = isAvailable;
                System.out.println("Availability updated for book ID " + bookID);
                return;
            }
            current = current.next;
        }
        System.out.println("Book not found.");
    }

    public void displayForward() {
        if (head == null) {
            System.out.println("No books in the library.");
            return;
        }
        BookNode current = head;
        while (current != null) {
            printBook(current);
            current = current.next;
        }
    }

    public void displayBackward() {
        if (tail == null) {
            System.out.println("No books in the library.");
            return;
        }
        BookNode current = tail;
        while (current != null) {
            printBook(current);
            current = current.prev;
        }
    }

    public int countBooks() {
        int count = 0;
        BookNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    private void printBook(BookNode node) {
        System.out.println("Title: " + node.title + ", Author: " + node.author + ", Genre: " + node.genre + ", ID: " + node.bookID + ", Available: " + node.isAvailable);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem library = new LibrarySystem();
        library.addBookAtBeginning("Java Programming", "Author A", "Tech", 101, true);
        library.addBookAtEnd("Python Basics", "Author B", "Tech", 102, true);
        library.displayForward();
        library.searchByAuthor("Author A");
        library.updateAvailability(101, false);
        library.removeBookByID(102);
        library.displayBackward();
        System.out.println("Total Books: " + library.countBooks());
    }
}