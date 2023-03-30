package algo230330;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2251_물통 {
	static int A, B, C;
	static boolean Water[][][];
			
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		Queue<Bottle> queue = new LinkedList<Bottle>();
		queue.add(new Bottle(0, 0, C));
		Water = new boolean[A+1][B+1][C+1];
		
		List<Integer> list = new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			Bottle now = queue.poll();
			
			if(Water[now.a][now.b][now.c]) continue;
			
			if(now.a == 0) {
				list.add(now.c);
			}
			
			Water[now.a][now.b][now.c] = true;
			
			queue.add(cTob(now.a, now.b, now.c));
			
			queue.add(cToa(now.a, now.b, now.c));

			queue.add(aTob(now.a, now.b, now.c));

			queue.add(aToc(now.a, now.b, now.c));
			
			queue.add(bToc(now.a, now.b, now.c));
			
			queue.add(bToa(now.a, now.b, now.c));
			
		}
		
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
	}
	
	static Bottle cTob(int a, int b, int c) {
		if(B >= c + b) {
			b += c;
			c = 0;
		}else {
			c = (b+c) - B;
			b = B;
		}
		
		return new Bottle(a, b, c);
	}

	static Bottle cToa(int a, int b, int c) {
		if(A >= c + a) {
			a += c;
			c = 0;
		}else {
			c = (c+a) - A;
			a = A;
		}
		
		return new Bottle(a, b, c);
	}
	
	static Bottle aTob(int a, int b, int c) {
		if(B >= a + b) {
			b += a;
			a = 0;
		}else {
			a = (a+b) - B;
			b = B;
		}
		
		return new Bottle(a, b, c);
	}

	static Bottle aToc(int a, int b, int c) {
		if(C >= c + a) {
			c += a;
			a = 0;
		}else {
			a = (a+c) - C;
			c = C;
		}
		
		return new Bottle(a, b, c);
	}
	
	static Bottle bToc(int a, int b, int c) {
		if(C >= b + c) {
			c += b;
			b = 0;
		}else  {
			b = (b+c) - C;
			c = C;
		}
		
		return new Bottle(a, b, c);
	}
	
	static Bottle bToa(int a, int b, int c) {
		if(A >= a + b) {
			a += b;
			b = 0;
		}else {
			b = (a+b) - A;
			a = A;
		}
		
		return new Bottle(a, b, c);
	}
	
	static class Bottle {
		int a;
		int b;
		int c;
		
		public Bottle(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}
}
