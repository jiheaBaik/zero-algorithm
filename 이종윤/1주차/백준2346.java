import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class 백준2346 {
    public static class balloon{
        int num;
        int val;
        public balloon(int num, int val){
            this.num = num;
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        //파일 읽어올때
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt((br.readLine()));
        Deque<balloon> q = new ArrayDeque<balloon>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 1;
        while(st.hasMoreTokens()){
            q.add(new balloon(idx++, Integer.parseInt(st.nextToken())));
        }

        StringBuffer res = new StringBuffer();

        while(!q.isEmpty()){
            balloon b = q.removeFirst();
            res.append(b.num+" ");
            if(q.isEmpty()){
                break;
            }
            if (b.val>0){
                //풍선을 이미 하나 터트려서 위치가 오른쪽을 이동했기 때문에 1보다 커야함
                while (b.val-- > 1) {
                    q.addLast(q.removeFirst());
                }
            }else{
                while (b.val++ < 0) {
                    q.addFirst(q.removeLast());
                }
            }
        }
        System.out.println(res);
    }
}
