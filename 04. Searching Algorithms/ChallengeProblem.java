import java.io.*;

public class ChallengeProblem {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        StringBuffer sf = new StringBuffer();
        String str = "hello";
        long startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sb.append(str);
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken for StringBuilder: " + (endTime - startTime) + " nanoseconds");
        startTime = System.nanoTime();
        for (int i = 0; i < 1000000; i++) {
            sf.append(str);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken for StringBuffer: " + (endTime - startTime) + " nanoseconds");
        try {
            FileReader fileReader = new FileReader("largefile.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("largefile.txt"));
            BufferedReader bufferedReader2 = new BufferedReader(inputStreamReader);
            startTime = System.nanoTime();
            String line;
            int wordCount = 0;
            while ((line = bufferedReader.readLine()) != null) {
                wordCount += line.split("\\s+").length;
            }
            endTime = System.nanoTime();
            System.out.println("Time taken with FileReader: " + (endTime - startTime) + " nanoseconds");
            System.out.println("Word count using FileReader: " + wordCount);
            startTime = System.nanoTime();
            int wordCount2 = 0;
            while ((line = bufferedReader2.readLine()) != null) {
                wordCount2 += line.split("\\s+").length;
            }
            endTime = System.nanoTime();
            System.out.println("Time taken with InputStreamReader: " + (endTime - startTime) + " nanoseconds");
            System.out.println("Word count using InputStreamReader: " + wordCount2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}