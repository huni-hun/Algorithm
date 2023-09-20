package algo230920;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b17143_낚시왕 {
	static int R, C, M;
	static int result;
	static int king;
	static List<Shark> wating;
	static Shark map[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R][C];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			map[r][c] = new Shark(r, c, s, d, z);
		}
		
		result = 0;
		king = -1;
		start();
		System.out.println(result);
	}
	
	public static void start() {
		for (int i = 0; i < C; i++) {
			moveRight();
		}
	}
	
	public static void moveRight() {
		king++;
		fishing();
	}
	
	public static void fishing() {
		for (int i = 0; i < R; i++) {
			if(map[i][king] != null) {
				result += map[i][king].z;
				map[i][king] = null;
				break;
			}
		}
		
		sharkMove();
	}

	public static void sharkMove() {
		wating = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			
			for (int j = 0; j < C; j++) {
				if(map[i][j] != null) {
					switch (map[i][j].d) {
					case 1:
						int speed = map[i][j].s % ((R-1) * 2);
						boolean flag;
						if(map[i][j].r == 0) {
							flag = false;
							map[i][j].d = 2;
						} else {
							flag = true;
						}
						for (int k = 0; k < speed; k++) {
							if(flag) {
								map[i][j].r -= 1;
								if(map[i][j].r == 0) {
									map[i][j].d = 2;
									flag = false;
								}
							} else {
								map[i][j].r += 1;
								if(map[i][j].r == R-1) {
									map[i][j].d = 1;
									flag = true;
								}
							}
						}
						wating.add(map[i][j]);
						map[i][j] = null;
						break;
					case 2:
						int speed2 = map[i][j].s % ((R-1) * 2);
						boolean flag2;
						if(map[i][j].r == R-1) {
							flag2 = false;
							map[i][j].d = 1;
						} else {
							flag2 = true;
						}
						for (int k = 0; k < speed2; k++) {
							if(flag2) {
								map[i][j].r += 1;
								if(map[i][j].r == R-1) {
									map[i][j].d = 1;
									flag2 = false;
								}
							} else {
								map[i][j].r -= 1;
								if(map[i][j].r == 0) {
									map[i][j].d = 2;
									flag2 = true;
								}
							}
						}
						wating.add(map[i][j]);
						map[i][j] = null;
						break;
					case 3:
						int speed3 = map[i][j].s % ((C-1) * 2);
						boolean flag3;
						if(map[i][j].c == C-1) {
							flag3 = false;
							map[i][j].d = 4;
						} else {
							flag3 = true;
						}
						for (int k = 0; k < speed3; k++) {
							if(flag3) {
								map[i][j].c += 1;
								if(map[i][j].c == C-1) {
									map[i][j].d = 4;
									flag3 = false;
								}
							} else {
								map[i][j].c -= 1;
								if(map[i][j].c == 0) {
									map[i][j].d = 3;
									flag3 = true;
								}
							}
						}
						wating.add(map[i][j]);
						map[i][j] = null;
						break;
					case 4:
						int speed4 = map[i][j].s % ((C-1) * 2);
						boolean flag4;
						if(map[i][j].c == 0) {
							flag4 = false;
							map[i][j].d = 3;
						} else {
							flag4 = true;
						}
						for (int k = 0; k < speed4; k++) {
							if(flag4) {
								map[i][j].c -= 1;
								if(map[i][j].c == 0) {
									map[i][j].d = 3;
									flag4 = false;
								}
							} else {
								map[i][j].c += 1;
								if(map[i][j].c == C-1) {
									map[i][j].d = 4;
									flag4 = true;
								}
							}
						}
						wating.add(map[i][j]);
						map[i][j] = null;
						break;
					}
				}
				
			} // end for second
		} // end for first
		
		eatSmallShark();
	}
	
	public static void eatSmallShark() {
		for (Shark shark : wating) {
			int r = shark.r;
			int c = shark.c;
			if(map[r][c] == null) {
				map[r][c] = shark;
			} else {
				if(map[r][c].z < shark.z) {
					map[r][c] = shark;
				} 
			}
		}
	}

	public static class Shark {
		int r, c; // 위치
		int s, d, z; // 속력 방향 크기
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
