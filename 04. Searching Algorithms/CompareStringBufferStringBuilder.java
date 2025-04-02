public class CompareStringBufferStringBuilder {
    public static void main(String[] args) {
        int numberOfStrings = 1000000;
        String str = "hello";
        StringBuffer sb = new StringBuffer();
        long startTime = System.nanoTime();
        for (int i = 0; i < numberOfStrings; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) + " nanoseconds");
        StringBuilder sbuilder = new StringBuilder();
        startTime = System.nanoTime();
        for (int i = 0; i < numberOfStrings; i++) {
            sbuilder.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + " nanoseconds");
    }
}