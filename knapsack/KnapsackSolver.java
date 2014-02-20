public class KnapsackSolver {

        int capacity;
        int items;
        int[] values;
        int[] weights;
        Solution[][] solution;
        boolean result;

    public static void main (String[] args) {
        if (args.length % 2 == 0) {
            throw new IllegalArgumentException("Bad input.");
        } else {
            for (int k = 0; k < args.length; k++) {
                if (Integer.parseInt(args[k]) < 0) {
                    throw new IllegalArgumentException("Unexpected negative argument.");
                }   
            }
        }
        /* Setup */
        int capacity = Integer.parseInt(args[args.length-1]);
        int items = (args.length-1)/2;
        int[] values = new int[items];
        int[] weights = new int[items];
        int i, j, ins;
        /* Finish parsing values and weights out of args */
        for (i = 0; i < args.length-1; i++) {
            ins = i / 2;
            if (i % 2 == 0) { 
                values[ins] = Integer.parseInt(args[i]);
            } else {
                weights[ins] = Integer.parseInt(args[i]);
            }
        }
        
        KnapsackSolver knap = new KnapsackSolver(capacity, values, weights);
        knap.solve();
        knap.ioOutResult();
    }

    public KnapsackSolver (int capacity, int[] values, int[] weights) {
        this.capacity = capacity;
        this.items = values.length;
        this.values = values;
        this.weights = weights;
        this.solution = new Solution[items][capacity+1];
    }

    private void solve () {
        for (int i = 0; i < items; i++) {
            for (int j = 0; j < capacity; j++) {
                int lbsLeft = j - this.weights[i];
                Solution target = this.solution[i][j];
                if (lbsLeft >= 0) {
                    target = new Solution(this.items); System.out.println("Soln made.");
                    target.setBit(i, true);
                    try {
                        target.logicOR(solution[i][lbsLeft]);
                    } catch (Exception e) {
                        System.out.println(e.toString());
                        System.out.println("i: " + i + " j: " + j);
                        System.out.println("lbs: " + lbsLeft);
                    }                  
                } 
                else if (i > 0 && lbsLeft < 0) {
                    target = solution[i-1][j];
                }
                if (i > 0 && valueOfSolution(target) < valueOfSolution(solution[i-1][j])) {
                    target = solution[i-1][j];
                }
            }
        }
    }

    private int valueOfSolution (Solution s) {
        int result = 0;
        if (s == null) return -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.valueAt(i)) {
                result = result + this.values[i];
            }
        }
        return result;
    }

    private boolean ioOutResult () {
        int totalWeight = 0;
        Solution answer = solution[items-1][capacity];
        debug_str_matrix();
        for (int i = 0; i < this.items; i++) {
            if (answer != null && answer.valueAt(i)) { //these items are to be accounted for
                totalWeight += weights[i];
                System.out.println("Take the " + weights[i] + " lbs item: $" + values[i]);
            } else {
                System.out.println("No solution.");
            }
        }
        System.out.println("Totals: " + totalWeight + " pounds, $" + valueOfSolution(answer));
        return true;
    }

    private void debug_str_matrix () {
        for (int i = 0; i < this.items; i++) {
            for (int j = 0; j < this.capacity; j++) {
                System.out.print(debug_char_rep(this.solution[i][j]));
            }
            System.out.print("\n");
        }

    }

    private char debug_char_rep (Solution s) {
        if (s == null)
            return 'n';
        else
            return '$';
    }
    
}