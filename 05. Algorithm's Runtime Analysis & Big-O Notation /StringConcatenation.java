public class StringConcatenation {
    public static void main(String[] args) {
        String str = "";
        StringBuilder sb = new StringBuilder();
        StringBuffer sbf = new StringBuffer();
        long start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            str += "hello";
        }
        System.out.println("String Concatenation Time: " + (System.nanoTime() - start));
        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sb.append("hello");
        }
        System.out.println("StringBuilder Time: " + (System.nanoTime() - start));
        start = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sbf.append("hello");
        }
        System.out.println("StringBuffer Time: " + (System.nanoTime() - start));
    }
}