import java.util.Scanner;

class TaskNode {
    int taskID;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskID, String taskName, int priority, String dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
    }
}

public class TaskScheduler {
    private TaskNode head = null;

    public void addTaskAtBeginning(int taskID, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
            head = newTask;
        }
    }

    public void addTaskAtEnd(int taskID, String taskName, int priority, String dueDate) {
        TaskNode newTask = new TaskNode(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            head.next = head;
        } else {
            TaskNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head;
        }
    }

    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks in the scheduler.");
            return;
        }
        TaskNode temp = head;
        do {
            System.out.println("Task ID: " + temp.taskID + ", Task Name: " + temp.taskName + ", Priority: " + temp.priority + ", Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void removeTaskByID(int taskID) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }
        TaskNode temp = head;
        TaskNode prev = null;
        do {
            if (temp.taskID == taskID) {
                if (prev != null) {
                    prev.next = temp.next;
                } else {
                    if (head.next == head) {
                        head = null;
                    } else {
                        TaskNode last = head;
                        while (last.next != head) {
                            last = last.next;
                        }
                        head = temp.next;
                        last.next = head;
                    }
                }
                System.out.println("Task " + taskID + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Task ID " + taskID + " not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();
        System.out.println("Enter task details to add at the beginning:");
        System.out.print("Task ID: ");
        int taskID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Task Name: ");
        String taskName = scanner.nextLine();
        System.out.print("Priority: ");
        int priority = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Due Date: ");
        String dueDate = scanner.nextLine();
        scheduler.addTaskAtBeginning(taskID, taskName, priority, dueDate);
        System.out.println("Enter task details to add at the end:");
        System.out.print("Task ID: ");
        taskID = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Task Name: ");
        taskName = scanner.nextLine();
        System.out.print("Priority: ");
        priority = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Due Date: ");
        dueDate = scanner.nextLine();
        scheduler.addTaskAtEnd(taskID, taskName, priority, dueDate);
        scheduler.displayTasks();
        System.out.print("Enter Task ID to remove: ");
        taskID = scanner.nextInt();
        scheduler.removeTaskByID(taskID);
        scheduler.displayTasks();
    }
}