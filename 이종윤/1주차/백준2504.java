import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준2504 {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int res = 0;
        int tmp = 1;
        boolean flag = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c=='('){
                stack.add(c);
                tmp *= 2;
            }else if(c==')'){
                if (stack.isEmpty()||stack.peek()!='('){
                    flag = false;
                    break;
                }else if(i>0&&str.charAt(i-1)=='('){
                    res += tmp;
                }
                stack.pop();
                tmp /= 2;
            }else if(c=='['){
                stack.add(c);
                tmp *= 3;
            }else{
                if (stack.isEmpty()||stack.peek()!='['){
                    flag = false;
                    break;
                }else if(i>0&&str.charAt(i-1)=='['){
                    res += tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }
        if (!flag||!stack.isEmpty()){
            System.out.println(0);
        }else{
            System.out.println(res);
        }
    }
}