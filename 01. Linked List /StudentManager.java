import java.util.Scanner;

class StudentNode {
    int rollNumber;
    String name;
    int age;
    String grade;
    StudentNode next;

    StudentNode(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

class StudentLinkedList {
    StudentNode head;

    void addAtBeginning(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
        System.out.println("Student added at beginning.");
    }

    void addAtEnd(int rollNumber, String name, int age, String grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (head == null) {
            head = newNode;
        } else {
            StudentNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Student added at end.");
    }

    void addAtPosition(int position, int rollNumber, String name, int age, String grade) {
        if (position < 1) {
            System.out.println("Position should be 1 or greater.");
            return;
        }
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
            System.out.println("Student added at position 1.");
            return;
        }
        StudentNode current = head;
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of range.");
        } else {
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Student added at position " + position);
        }
    }

    void deleteByRollNumber(int rollNumber) {
        StudentNode current = head, prev = null;
        while (current != null && current.rollNumber != rollNumber) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("Student not found.");
            return;
        }
        if (prev == null) {
            head = head.next;
        } else {
            prev.next = current.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " deleted.");
    }

    void searchByRollNumber(int rollNumber) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                System.out.println("Student Found: " + current.rollNumber + ", " + current.name + ", " + current.age + ", " + current.grade);
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }

    void updateGrade(int rollNumber, String newGrade) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNumber == rollNumber) {
                current.grade = newGrade;
                System.out.println("Grade updated for Roll Number " + rollNumber);
                return;
            }
            current = current.next;
        }
        System.out.println("Student not found.");
    }

    void displayAll() {
        if (head == null) {
            System.out.println("No student records.");
            return;
        }
        StudentNode current = head;
        System.out.println("Student Records:");
        while (current != null) {
            System.out.println("Roll: " + current.rollNumber + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
}

public class StudentManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentLinkedList list = new StudentLinkedList();
        int choice;
        do {
            System.out.println("\n--- Student Record Management ---");
            System.out.println("1. Add Student at Beginning");
            System.out.println("2. Add Student at End");
            System.out.println("3. Add Student at Specific Position");
            System.out.println("4. Delete Student by Roll Number");
            System.out.println("5. Search Student by Roll Number");
            System.out.println("6. Update Student Grade");
            System.out.println("7. Display All Students");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Roll Number: ");
                    int roll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Grade: ");
                    String grade = scanner.nextLine();
                    if (choice == 1) {
                        list.addAtBeginning(roll, name, age, grade);
                    } else if (choice == 2) {
                        list.addAtEnd(roll, name, age, grade);
                    } else {
                        System.out.print("Enter Position: ");
                        int pos = scanner.nextInt();
                        list.addAtPosition(pos, roll, name, age, grade);
                    }
                    break;
                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    int delRoll = scanner.nextInt();
                    list.deleteByRollNumber(delRoll);
                    break;
                case 5:
                    System.out.print("Enter Roll Number to Search: ");
                    int searchRoll = scanner.nextInt();
                    list.searchByRollNumber(searchRoll);
                    break;
                case 6:
                    System.out.print("Enter Roll Number to Update Grade: ");
                    int updateRoll = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Grade: ");
                    String newGrade = scanner.nextLine();
                    list.updateGrade(updateRoll, newGrade);
                    break;
                case 7:
                    list.displayAll();
                    break;
                case 8:
                    System.out.println("Exiting Program.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 8);
        scanner.close();
    }
}