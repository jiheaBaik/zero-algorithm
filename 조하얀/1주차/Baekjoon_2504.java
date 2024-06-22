import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int answer = 0;
        int value = 1;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);
            if (target == '(') {
                stack.push(target);
                value *= 2;
            } else if (target == '[') {
                stack.push(target);
                value *= 3;
            } else if (target == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = 0;
                    break;
                }
                if (input.charAt(i - 1) == '(') answer += value;
                stack.pop();
                value /= 2;
            } else if (target == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    answer = 0;
                    break;
                }
                if (input.charAt(i - 1) == '[') answer += value;
                stack.pop();
                value /= 3;
            }
        }

        if (!stack.isEmpty()) answer = 0;
        System.out.println(answer);
    }
}
