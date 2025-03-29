import java.util.Scanner;

class MovieNode {
    String movieTitle;
    String movieDirector;
    int yearofrelease;
    double rating;
    MovieNode next;
    MovieNode prev;

    MovieNode(String movieTitle, String movieDirector, int yearofrelease, double rating) {
        this.movieTitle = movieTitle;
        this.movieDirector = movieDirector;
        this.yearofrelease = yearofrelease;
        this.rating = rating;
    }
}

class MovieList {
    MovieNode head;
    MovieNode tail;

    void addatBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added in the beginning");
    }

    void addatEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added in the end");
    }

    void removebyTitle(String title) {
        MovieNode current = head;
        while (current != null && !current.movieTitle.equalsIgnoreCase(title)) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Movie NOT Found!");
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
        System.out.println("Movie \"" + title + "\" removed.");
    }

    void searchByDirector(String director) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.movieDirector.equalsIgnoreCase(director)) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found by " + director);
    }

    void searchByRating(double rating) {
        MovieNode current = head;
        boolean found = false;
        while (current != null) {
            if (current.rating == rating) {
                printMovie(current);
                found = true;
            }
            current = current.next;
        }
        if (!found) System.out.println("No movies found with rating " + rating);
    }

    void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.movieTitle.equalsIgnoreCase(title)) {
                current.rating = newRating;
                System.out.println("Rating updated for \"" + title + "\"");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    void displayForward() {
        if (head == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies (Forward):");
        MovieNode current = head;
        while (current != null) {
            printMovie(current);
            current = current.next;
        }
    }

    void displayBackward() {
        if (tail == null) {
            System.out.println("No movies in the list.");
            return;
        }
        System.out.println("Movies (Reverse):");
        MovieNode current = tail;
        while (current != null) {
            printMovie(current);
            current = current.prev;
        }
    }

    void printMovie(MovieNode node) {
        System.out.println("Title: " + node.movieTitle + ", Director: " + node.movieDirector + ", Year: " + node.yearofrelease + ", Rating: " + node.rating);
    }
}

public class Movie {
    public static void main(String[] args) {
        MovieList list = new MovieList();
        list.addatBeginning("Inception", "Christopher Nolan", 2010, 8.8);
        list.addatEnd("The Matrix", "Lana Wachowski", 1999, 8.7);
        list.displayForward();
        list.displayBackward();
        list.searchByDirector("Christopher Nolan");
        list.searchByRating(8.7);
        list.updateRating("Inception", 9.0);
        list.removebyTitle("The Matrix");
        list.displayForward();
    }
}