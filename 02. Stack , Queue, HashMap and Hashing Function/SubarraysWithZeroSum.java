import java.util.HashMap;
import java.util.ArrayList;

public class SubarraysWithZeroSum {
    public static ArrayList<int[]> findSubarraysWithZeroSum(int[] arr) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<int[]> result = new ArrayList<>();
        int sum = 0;
        map.put(0, new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                ArrayList<Integer> indices = map.get(sum);
                for (int index : indices) {
                    result.add(new int[]{index + 1, i});
                }
            }
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 4, -2, -3, 4};
        ArrayList<int[]> subarrays = findSubarraysWithZeroSum(arr);
        for (int[] subarray : subarrays) {
            System.out.println("Subarray: " + subarray[0] + " to " + subarray[1]);
        }
    }
}