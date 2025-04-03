import java.util.HashSet;
import java.util.TreeSet;

public class DataStructureComparison {
    public static int arraySearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        long start = System.nanoTime();
        arraySearch(arr, target);
        System.out.println("Array Search Time: " + (System.nanoTime() - start));
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : arr) hashSet.add(i);
        start = System.nanoTime();
        hashSet.contains(target);
        System.out.println("HashSet Search Time: " + (System.nanoTime() - start));
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i : arr) treeSet.add(i);
        start = System.nanoTime();
        treeSet.contains(target);
        System.out.println("TreeSet Search Time: " + (System.nanoTime() - start));
    }
}