import java.util.Scanner;

public class InsertionSortEmployeeIDs {
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void printArray(int[] arr) {
        for (int id : arr) {
            System.out.print(id + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();
        int[] employeeIDs = new int[n];
        System.out.println("Enter the employee IDs:");
        for (int i = 0; i < n; i++) {
            employeeIDs[i] = scanner.nextInt();
        }
        System.out.println("Before Sorting:");
        printArray(employeeIDs);
        insertionSort(employeeIDs);
        System.out.println("After Sorting:");
        printArray(employeeIDs);
        scanner.close();
    }
}