package algo230203;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class softeer_성적평가 {
    static int N, sum[], scores[][];
    static PriorityQueue<Score> pq;

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        sum = new int[N];
        scores = new int[N][4];
        pq = new PriorityQueue<>();

        read(br.readLine());
        sort(0);

        read(br.readLine());
        sort(1);

        read(br.readLine());
        sort(2);

        pq.clear();
        for (int n = 0; n < N; n++) {
            pq.offer(new Score(n, sum[n]));
        }
        sort(3);


        StringBuilder sbAll = new StringBuilder();
        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int n = 0; n < N; n++) {
            sb0.append(scores[n][0]).append(" ");
            sb1.append(scores[n][1]).append(" ");
            sb2.append(scores[n][2]).append(" ");
            sbAll.append(scores[n][3]).append(" ");
        }
        sb0.append("\n").append(sb1).append("\n").append(sb2).append("\n").append(sbAll);
        System.out.print(sb0);
	}
	
    static void read(String input){
        pq.clear();
        StringTokenizer st = new StringTokenizer(input, " ");
        for (int n = 0; n < N; n++) {
            int tmp = Integer.parseInt(st.nextToken());
            pq.offer(new Score(n, tmp));
            sum[n] += tmp;
        }
    }
	
    static void sort(int idx){
        Score ex = null;
        int reward = 1;
        for (int n = 0; n < N; n++) {
            Score node = pq.poll();
            scores[node.idx][idx] = ex != null && node.score == ex.score ? scores[ex.idx][idx] : reward;
            reward++;
            ex = node;
        }
    }

    static class Score implements Comparable<Score> {
        int idx;
        int score;


        public Score(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }

        @Override
        public int compareTo(Score o) {
            return Integer.compare(o.score, this.score);
        }
    }
}
