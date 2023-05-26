package algo230526;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class b20920_영단어암기는괴로워 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < N; i++) {
			String word = br.readLine();
			if(word.length() < M) continue;
			
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		List<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				if(map.get(o1) == map.get(o2)) {
					if(o1.length() == o2.length()) {
						return o1.compareTo(o2);
					} else return o2.length() - o1.length();
				} else return map.get(o2) - map.get(o1);
			}
		});
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
