import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String input = "aabccba";
        String result = removeDuplicates(input);
        System.out.println("String without duplicates: " + result);
    }

    public static String removeDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!seen.contains(ch)) {
                sb.append(ch);
                seen.add(ch);
            }
        }
        return sb.toString();
    }
}