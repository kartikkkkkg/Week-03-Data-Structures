import java.util.Arrays;

public class StudentMarks {
    public static void main(String[] args) {
        int[] marks = {85, 84, 87, 55, 79, 84, 56, 44, 77, 59, 99};
        System.out.println("Original Marks: " + Arrays.toString(marks));
        bubbleSort(marks);
        System.out.println("Sorted Marks: " + Arrays.toString(marks));
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}