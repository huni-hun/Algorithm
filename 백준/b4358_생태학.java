package algo230921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class b4358_생태학 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<String, Integer> map = new HashMap<>();
		int cnt = 0;
		String line;
		while((line = br.readLine()) != null) {
			cnt++;
			map.put(line, map.getOrDefault(line, 0) + 1);
		}
		
		List<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		for (String s : list) {
			double num = map.get(s) * 100;
			sb.append(s).append(" ").append(String.format("%.4f", num / (double)cnt));
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
