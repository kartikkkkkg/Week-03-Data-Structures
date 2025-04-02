import java.io.*;

public class InputStreamReaderProblem2 {
    public static void main(String[] args) {
        try (InputStreamReader isr = new InputStreamReader(System.in);
             BufferedReader br = new BufferedReader(isr);
             FileWriter fw = new FileWriter("output.txt", true)) {
            String input;
            while (!(input = br.readLine()).equalsIgnoreCase("exit")) {
                fw.write(input + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}