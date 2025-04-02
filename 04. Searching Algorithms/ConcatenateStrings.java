public class ConcatenateStrings {
    public static void main(String[] args) {
        String[] input = {"Hello", " ", "World", "!", " ", "How", " ", "are", " ", "you?"};
        String result = concatenateStrings(input);
        System.out.println("Concatenated String: " + result);
    }

    public static String concatenateStrings(String[] strArray) {
        StringBuffer sb = new StringBuffer();
        for (String str : strArray) {
            sb.append(str);
        }
        return sb.toString();
    }
}