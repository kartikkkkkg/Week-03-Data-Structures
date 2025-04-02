public class LinearSearch2 {
    public static String findSentenceWithWord(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {"This is a test.", "Search for a word.", "Another test sentence."};
        System.out.println("Sentence containing the word: " + findSentenceWithWord(sentences, "word"));
    }
}