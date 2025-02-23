import java.util.HashMap;
import java.util.Map;

public class NumberOfSubmatricesThatSumtoTarget {
    // !imp
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;


        // first take the cumulative sum row-wise
        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }
        // now find the no of subarrays with sum k in the downward direction leetcode 560 approach
        int result = 0;
        for (int startCol = 0; startCol < cols; startCol++) {
            for (int currCol = startCol; currCol < cols; currCol++) {
                // we need to find all submatrices sum

                // now comes the concept of no of subarrays with sum k'
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                // go downWards row wise
                for (int row = 0; row < rows; row++) {
                    sum += matrix[row][currCol] - (startCol > 0 ? matrix[row][startCol - 1] : 0);

                    if (map.containsKey(sum - target)) {
                        result += map.get(sum - target);
                    }
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}