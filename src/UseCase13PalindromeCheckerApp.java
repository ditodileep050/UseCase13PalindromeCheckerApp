import java.util.Stack;
import java.util.ArrayDeque;
import java.util.Deque;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "Level";

        System.out.println("Input : " + input);

        // Direct Two-Pointer Approach
        long start1 = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long end1 = System.nanoTime();

        // Stack Approach
        long start2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long end2 = System.nanoTime();

        // Deque Approach
        long start3 = System.nanoTime();
        boolean result3 = dequeCheck(input);
        long end3 = System.nanoTime();

        System.out.println("\nResults:");
        System.out.println("Two Pointer  -> " + result1 +
                " | Time: " + (end1 - start1) + " ns");

        System.out.println("Stack        -> " + result2 +
                " | Time: " + (end2 - start2) + " ns");

        System.out.println("Deque        -> " + result3 +
                " | Time: " + (end3 - start3) + " ns");
    }

    // Two-pointer approach
    public static boolean twoPointerCheck(String input) {
        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (Character.toLowerCase(input.charAt(start)) !=
                    Character.toLowerCase(input.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Stack-based approach
    public static boolean stackCheck(String input) {
        Stack<Character> stack = new Stack<>();

        for (char c : input.toLowerCase().toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toLowerCase().toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // Deque-based approach
    public static boolean dequeCheck(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toLowerCase().toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }
}