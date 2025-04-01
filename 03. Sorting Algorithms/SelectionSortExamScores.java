import java.util.Scanner;

public class SelectionSortExamScores {
    public static void selectionSort(int[] scores) {
        int n = scores.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;
        }
    }

    public static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int[] examScores = new int[n];
        System.out.println("Enter the exam scores:");
        for (int i = 0; i < n; i++) {
            examScores[i] = scanner.nextInt();
        }
        System.out.println("Before Sorting:");
        printArray(examScores);
        selectionSort(examScores);
        System.out.println("After Sorting:");
        printArray(examScores);
        scanner.close();
    }
}