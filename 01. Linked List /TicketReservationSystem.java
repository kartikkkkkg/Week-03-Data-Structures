import java.util.Scanner;

class TicketNode {
    int ticketID;
    String customerName;
    String movieName;
    int seatNumber;
    String bookingTime;
    TicketNode next;

    public TicketNode(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        this.ticketID = ticketID;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
    }
}

public class TicketReservationSystem {
    private TicketNode head = null;

    public void addTicket(int ticketID, String customerName, String movieName, int seatNumber, String bookingTime) {
        TicketNode newTicket = new TicketNode(ticketID, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = newTicket;
            head.next = head;
        } else {
            TicketNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTicket;
            newTicket.next = head;
        }
    }

    public void removeTicket(int ticketID) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }
        TicketNode temp = head;
        TicketNode prev = null;
        do {
            if (temp.ticketID == ticketID) {
                if (prev != null) {
                    prev.next = temp.next;
                } else {
                    if (temp.next == head) {
                        head = null;
                    } else {
                        TicketNode last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = temp.next;
                        last.next = head;
                    }
                }
                System.out.println("Ticket " + ticketID + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Ticket not found.");
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets in the system.");
            return;
        }
        TicketNode temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketID + ", Customer: " + temp.customerName + ", Movie: " + temp.movieName +
                    ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchTicket(String customerName) {
        TicketNode temp = head;
        do {
            if (temp.customerName.equals(customerName)) {
                System.out.println("Ticket found: " + temp.ticketID);
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Ticket not found.");
    }

    public int countTickets() {
        int count = 0;
        if (head != null) {
            TicketNode temp = head;
            do {
                count++;
                temp = temp.next;
            } while (temp != head);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();
        system.addTicket(1, "John", "Inception", 10, "12:00 PM");
        system.addTicket(2, "Alice", "Avatar", 5, "2:00 PM");
        system.addTicket(3, "Bob", "Titanic", 7, "4:00 PM");
        system.displayTickets();
        system.searchTicket("Alice");
        system.removeTicket(2);
        system.displayTickets();
        System.out.println("Total Tickets: " + system.countTickets());
    }
}