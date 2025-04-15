package DP.HouseRobber;

import java.util.HashMap;

import javax.swing.tree.TreeNode;

public class HouseRobberIII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int rec(TreeNode curr, HashMap<TreeNode, Integer> dp) {
        if (curr == null) {
            return 0;
        }

        if (dp.containsKey(curr) == true) {
            return dp.get(curr);
        }
        int notTake = rec(curr.left, dp) + rec(curr.right, dp);
        int take = curr.val;
        if (curr.left != null) {
            take += rec(curr.left.left, dp) + rec(curr.left.right, dp);
        }
        if (curr.right != null) {
            take += rec(curr.right.right, dp) + rec(curr.right.left, dp);
        }
        int ans = Math.max(take, notTake);
        dp.put(curr, ans);
        return ans;
    }

    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> dp = new HashMap<>();
        return rec(root, dp);
    }

    public static void main(String[] args) {

    }

}
