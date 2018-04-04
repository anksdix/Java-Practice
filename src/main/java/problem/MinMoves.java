package problem;
import java.util.HashMap;
import java.util.Map;

public class MinMoves {
	
	private static Map<Integer, Integer> map;

	public static int calcMoves(int[] arr, int i, int length, int moves) {

		int updMoves1 = -1,updMoves2 = -1;
		if (i+1 >= length - 1) {
			return ++moves;
		}

		Integer jumpIndex = map.get(arr[i+1]);

		if (jumpIndex != null)
			updMoves1 = calcMoves(arr, jumpIndex, length, ++moves);
		updMoves2 = calcMoves(arr, i+1, length, ++moves);

		return Math.min(updMoves1, updMoves2);

	}

	public static void main(String[] args) {

		int[] arr = { 4, 2, 3, 4, 2, 2, 1, 5 };
		map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		System.out.println(calcMoves(arr, -1, arr.length, 0));
	}
}
