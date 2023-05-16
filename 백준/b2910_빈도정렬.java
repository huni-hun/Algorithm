package algo230515;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class b2910_빈도정렬 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		
		List<Integer> list = new ArrayList<Integer>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) {
				return Integer.compare(map.get(b), map.get(a));
			}
		});
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < map.get(list.get(i)); j++) {
				System.out.print(list.get(i) + " ");
			}
		}
	}

}
