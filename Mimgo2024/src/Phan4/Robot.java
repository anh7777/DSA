package Phan4;

import java.util.HashMap;

//Sinh viên hoàn thành phương thức countPath(int M, int N, int t)

public class Robot {
	private HashMap<String, Integer> memo;
	public int countPath(int M, int N, int t)
	{
		memo = new HashMap<>();
		return countPathsUtil(0,0,M,N,t);
	}

	public int countPathsUtil(int x, int y, int M, int N, int t) {
		if (x == M - 1 && y == N -1) {
			return 1;
		}

		if (t <= 0) {
			return 0;
		}

		String key = x + "," + y + "," + t;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}

		int down = countPathsUtil(x+1, y, M, N, t-1);
		int right = countPathsUtil(x, y+1, M, N, t-1);

		memo.put(key, down+right);
		return down + right;
	}

	public static void main(String[] args) {
		Robot robot = new Robot();
		int M = 3;
		int N = 3;
		int t = 4;

		int paths = robot.countPath(M, N, t);
		System.out.println("Số cách để đến đích: " + paths);
	}

}
