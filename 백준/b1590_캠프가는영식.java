package algo230202;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class b1590_캠프가는영식 {
	static ArrayList<Integer> bus;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int busCnt = Integer.parseInt(st.nextToken());
		int sik = Integer.parseInt(st.nextToken());
		
		bus = new ArrayList<>();
		for (int i = 0; i < busCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int busStart = Integer.parseInt(st.nextToken());
			int interval = Integer.parseInt(st.nextToken());
			int carCnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < carCnt; j++) {
				bus.add(busStart);
				busStart += interval;
			}
		}
		
		Collections.sort(bus);
		int start = 0;
		int end = bus.size() - 1;
		int mid = 0;
		
		if(sik <= bus.get(0)) {
			System.out.println(bus.get(0) - sik);
		}else if(sik > bus.get(end)) {
			System.out.println(-1);
		}else {
			while(start < end) {
				mid = (start + end) / 2;
				if(bus.get(mid) == sik) {
					System.out.println(0);
					return;
				}else if(bus.get(mid) > sik) {
					end = mid;
				}else {
					start = mid + 1;
				}
				
			}
			System.out.println(bus.get(end) - sik);
		}
		
	}
}
