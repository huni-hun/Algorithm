package algo230916;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class b17178_줄서기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		List<Ticket> sortlist = new ArrayList<Ticket>();
		Queue<String> list = new LinkedList<String>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				String ticket = st.nextToken();
				StringTokenizer tempSt = new StringTokenizer(ticket, "-");
				sortlist.add(new Ticket(ticket, tempSt.nextToken(), Integer.parseInt(tempSt.nextToken())));
				list.add(ticket);
			}
		}
		
		Collections.sort(sortlist);
		Stack<String> wating = new Stack<>();
		while(!sortlist.isEmpty()) {
			if(!list.isEmpty() && list.peek() == sortlist.get(0).original) {
				list.poll();
				sortlist.remove(0);
			} else if(!wating.isEmpty() && wating.peek() == sortlist.get(0).original) {
				wating.pop();
				sortlist.remove(0);
			} else {
				if(!list.isEmpty()) {
					wating.add(list.poll());
				} else {
					break;
				}
			}
		}
		
		if(sortlist.size() == 0) System.out.println("GOOD");
		else System.out.println("BAD");
	}
	
	public static class Ticket implements Comparable<Ticket>{
		String original;
		String alphabet;
		int num;
		
		public Ticket(String original, String alphabet, int num) {
			this.original = original;
			this.alphabet = alphabet;
			this.num = num;
		}

		@Override
		public int compareTo(Ticket o) {
			if(alphabet.compareTo(o.alphabet) == 0) {
				if (o.num > num) {
					return -1;
				} else {
					return 1;
				}
			}
			return alphabet.compareTo(o.alphabet);
		}

	}
}
