import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char target = input.charAt(i);

            if (target >= 'A' && target <= 'Z') answer.append(target);
            else if (target != '(' && target != ')') {
                while (!stack.isEmpty() && priority(stack.peek()) >= priority(target)) {
                    answer.append(stack.pop());
                }
                stack.push(target);
            }
            else if (target == '(') stack.push(target);
            else {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    answer.append(stack.pop());
                }
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }

        System.out.println(answer);
    }

    static int priority(char target) {
        if (target == '*' || target == '/') return 2;
        else if (target == '+' || target == '-') return 1;
        else return 0;
    }
}
