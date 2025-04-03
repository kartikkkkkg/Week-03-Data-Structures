import java.io.*;

public class FileReading {
    public static void readFileWithFileReader(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        int i;
        while ((i = fr.read()) != -1) {
            System.out.print((char) i);
        }
        fr.close();
    }

    public static void readFileWithInputStreamReader(String filePath) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
        int i;
        while ((i = isr.read()) != -1) {
            System.out.print((char) i);
        }
        isr.close();
    }

    public static void main(String[] args) throws IOException {
        String filePath = "largeFile.txt";
        long start = System.nanoTime();
        readFileWithFileReader(filePath);
        System.out.println("\nFileReader Time: " + (System.nanoTime() - start));
        start = System.nanoTime();
        readFileWithInputStreamReader(filePath);
        System.out.println("\nInputStreamReader Time: " + (System.nanoTime() - start));
    }
}