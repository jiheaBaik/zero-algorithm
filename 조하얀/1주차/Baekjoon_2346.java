import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalBalloon = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<Balloon> balloons = new ArrayDeque<>();
        int index = 1;
        while (st.hasMoreTokens()) {
            balloons.offer(new Balloon(index++, Integer.parseInt(st.nextToken())));
        }

        StringBuilder answer = new StringBuilder();
        Balloon current = balloons.pollFirst();
        answer.append(current.index).append(" ");
        while (balloons.size() > 1) {
            int move = current.number;
            if (move > 0) {
                for (int i = 1; i < move; i++) {
                    balloons.offerLast(balloons.pollFirst());
                }
                current = balloons.pollFirst();
            } else {
                for (int i = -1; i > move; i--) {
                    balloons.offerFirst(balloons.pollLast());
                }
                current = balloons.pollLast();
            }
            answer.append(current.index).append(" ");
        }
        answer.append(balloons.poll().index);
        System.out.println(answer.toString());
    }
}

class Balloon {
    int index;
    int number;

    public Balloon(int index, int number) {
        this.index = index;
        this.number = number;
    }
}