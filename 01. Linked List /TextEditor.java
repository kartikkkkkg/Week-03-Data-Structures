import java.util.Scanner;

class TextState {
    String content;
    TextState next;
    TextState prev;

    public TextState(String content) {
        this.content = content;
    }
}

public class TextEditor {
    private TextState head = null;
    private TextState tail = null;
    private TextState currentState = null;
    private int maxHistorySize = 10;

    public void addState(String content) {
        TextState newState = new TextState(content);
        if (head == null) {
            head = tail = newState;
            currentState = newState;
        } else {
            if (currentState != tail) {
                currentState.next = null;
                tail = currentState;
            }
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            currentState = tail;
            trimHistory();
        }
    }

    public void undo() {
        if (currentState != null && currentState.prev != null) {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.content);
        } else {
            System.out.println("No more undo steps available.");
        }
    }

    public void redo() {
        if (currentState != null && currentState.next != null) {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.content);
        } else {
            System.out.println("No more redo steps available.");
        }
    }

    public void trimHistory() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (count > maxHistorySize) {
            head = head.next;
            head.prev = null;
        }
    }

    public void displayCurrentState() {
        if (currentState != null) {
            System.out.println("Current State: " + currentState.content);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TextEditor editor = new TextEditor();
        editor.addState("Hello");
        editor.addState("Hello World");
        editor.addState("Hello World!");
        editor.displayCurrentState();
        editor.undo();
        editor.redo();
        editor.undo();
        editor.undo();
        editor.redo();
    }
}