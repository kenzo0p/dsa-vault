package Linear-dp;
import java.util.*;
public class UniqueBinarySearchTreesII {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        Map<Pair<Integer, Integer>, List<TreeNode>> memo;

        public List<TreeNode> allPossibleBST(int start, int end) {
            List<TreeNode> res = new ArrayList<>();
            if (start > end) {
                res.add(null);
                return res;
            }
            if (memo.containsKey(new Pair<>(start, end))) {
                return memo.get(new Pair<>(start, end));
            }

            // Iterate through all values from start to end to construct left and right
            // subtree recursively.

            for (int i = start; i <= end; ++i) {
                List<TreeNode> leftSubTrees = allPossibleBST(start, i - 1);
                List<TreeNode> rightSubTrees = allPossibleBST(i + 1, end);

                // Loop through all left and right subtrees and connect them to ith root.
                for (TreeNode left : leftSubTrees) {
                    for (TreeNode right : rightSubTrees) {
                        TreeNode root = new TreeNode(i, left, right);
                        res.add(root);
                    }
                }
            }
            memo.put(new Pair<>(start, end), res);
            return res;
        }

        public List<TreeNode> generateTrees(int n) {
            memo = new HashMap<>();
            return allPossibleBST(1, n);
        }
    }
}
