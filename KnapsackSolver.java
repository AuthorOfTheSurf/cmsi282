public class KnapsackSolver {

	public static void main (String[] args) {
		if (args.length % 2 == 0) {
			throw new IllegalArgumentException("Bad input.");
		}
		/* Setup */
		int capacity = Integer.parseInt(args[args.length-1]);
		int items = (args.length - 1) / 2;
		int[] values = new int[items];
		for (int i = 1, j = 0; i < args.length; i = i + 2, j++) {
			values[j] = args[i];
		}
		/* Solve Sequence */
		Solution[][] = new Solution[items][capacity];

	}

	private int valueOfSolution(Solution s) {
		int result = 0;
		for (int i = 0; i < s.length; i++) {
			result = result + s[i] * this.data[i];
		}
		return result;
	}

}