import java.util.Scanner;

class ProcessNode {
    int processID;
    int burstTime;
    int priority;
    ProcessNode next;

    public ProcessNode(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}

public class RoundRobinScheduling {
    private ProcessNode head = null;
    private int totalProcesses = 0;

    public void addProcess(int processID, int burstTime, int priority) {
        ProcessNode newProcess = new ProcessNode(processID, burstTime, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }
        totalProcesses++;
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the scheduler.");
            return;
        }
        ProcessNode temp = head;
        do {
            System.out.println("Process ID: " + temp.processID + ", Burst Time: " + temp.burstTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }

    public void roundRobinScheduling(int quantumTime) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }
        ProcessNode temp = head;
        int time = 0;
        int completedProcesses = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        while (completedProcesses < totalProcesses) {
            if (temp.burstTime > 0) {
                int waitTime = time;
                if (temp.burstTime > quantumTime) {
                    time += quantumTime;
                    temp.burstTime -= quantumTime;
                } else {
                    time += temp.burstTime;
                    temp.burstTime = 0;
                    completedProcesses++;
                    totalWaitingTime += (time - waitTime - temp.burstTime);
                    totalTurnaroundTime += (time - waitTime);
                    System.out.println("Process " + temp.processID + " executed.");
                }
            }
            temp = temp.next;
        }
        System.out.println("Average Waiting Time: " + (totalWaitingTime / totalProcesses));
        System.out.println("Average Turnaround Time: " + (totalTurnaroundTime / totalProcesses));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RoundRobinScheduling scheduler = new RoundRobinScheduling();
        System.out.print("Enter number of processes: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Enter Process ID: ");
            int id = scanner.nextInt();
            System.out.print("Enter Burst Time: ");
            int burstTime = scanner.nextInt();
            System.out.print("Enter Priority: ");
            int priority = scanner.nextInt();
            scheduler.addProcess(id, burstTime, priority);
        }
        System.out.print("Enter Time Quantum: ");
        int quantumTime = scanner.nextInt();
        scheduler.roundRobinScheduling(quantumTime);
    }
}