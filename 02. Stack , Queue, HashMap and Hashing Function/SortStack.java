import java.util.Stack;

public class SortStack {
    public static void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int temp = stack.pop();
        sort(stack);
        insertSorted(stack, temp);
    }

    private static void insertSorted(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertSorted(stack, element);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(30);
        stack.push(10);
        stack.push(50);
        stack.push(20);
        sort(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}