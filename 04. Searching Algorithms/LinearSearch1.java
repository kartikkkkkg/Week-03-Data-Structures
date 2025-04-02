public class LinearSearch1 {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, 4, 5};
        System.out.println("First negative number at index: " + findFirstNegative(arr));
    }
}