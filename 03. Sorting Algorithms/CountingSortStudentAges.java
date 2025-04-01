import java.util.Scanner;

public class CountingSortStudentAges {
    public static void countingSort(int[] ages, int min, int max) {
        int[] count = new int[max - min + 1];
        for (int age : ages) {
            count[age - min]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                ages[index++] = i + min;
                count[i]--;
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int age : arr) {
            System.out.print(age + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] ages = new int[n];
        System.out.println("Enter the student ages (10 to 18):");
        for (int i = 0; i < n; i++) {
            ages[i] = scanner.nextInt();
        }
        System.out.println("Before Sorting:");
        printArray(ages);
        countingSort(ages, 10, 18);
        System.out.println("After Sorting:");
        printArray(ages);
        scanner.close();
    }
}