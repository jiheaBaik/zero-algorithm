import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Stack<Character> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();

        boolean isValid = true;
        int result = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '[') {
                stack.push(c);
                sumStack.push(0); // 초기값으로 0을 푸시
            } else {
                if (stack.isEmpty()) {
                    isValid = false;
                    break;
                }

                char openBracket = stack.pop();
                int innerSum = sumStack.pop();

                if ((c == ')' && openBracket != '(') || (c == ']' && openBracket != '[')) {
                    isValid = false;
                    break;
                }

                int value = (c == ')') ? 2 : 3;
                int calculatedValue = value * (innerSum != 0 ? innerSum : 1);

                if (!sumStack.isEmpty())
                    sumStack.push(sumStack.pop() + calculatedValue);
                else
                    result += calculatedValue;

            }
        }

        if (!isValid || !stack.isEmpty())
            System.out.println(0);
        else
            System.out.println(result);

    }
}
