import java.util.*;
 
class MaximumSumBST {
    static class Node 
    {
        Node left;
        Node right;
        int data;
 
        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
 
    static class Info 
    {
        int max;
        int min;
        boolean isBST;
        int sum;
        int currmax;
 
        Info(int max,int min,boolean isBST,int sum,int currmax)
        {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
            this.sum = sum;
            this.currmax = currmax;
        }
 
        Info() {
            this.max = 0;
            this.min = 0;
            this.isBST = true;
            this.sum = 0;
            this.currmax = 0;
        }
    }
 
    static int maxsum;
 
    static Info MaxSumBSTUtil( Node root)
    {
        if (root == null)
            return new Info( Integer.MIN_VALUE, 
                            Integer.MAX_VALUE, true, 0, 0 );
 
        if (root.left == null && root.right == null)
        {
            maxsum = Math.max(maxsum, root.data);
            return new Info( root.data, root.data, 
                            true, root.data, maxsum);
        }
 
        // Store information about the left subtree
        Info L = MaxSumBSTUtil(root.left);
 
        // Store information about the right subtree
        Info R = MaxSumBSTUtil(root.right);
 
        Info BST=new Info();
 
        // If the subtree rooted under the current node
        // is a BST
        if (L.isBST && R.isBST && L.max < root.data && 
                                R.min > root.data)
        {
 
            BST.max = Math.max(root.data, Math.max(L.max, R.max));
            BST.min = Math.min(root.data, Math.min(L.min, R.min));
 
            maxsum = Math.max(maxsum, R.sum + root.data + L.sum);
            BST.sum = R.sum + root.data + L.sum;
 
            // Update the current maximum sum
            BST.currmax = maxsum;
 
            BST.isBST = true;
            return BST;
        }
 
        // If the whole tree is not a BST then
        // update the current maximum sum
        BST.isBST = false;
        BST.currmax = maxsum;
        BST.sum = R.sum + root.data + L.sum;
 
        return BST;
    }
 
    static int MaxSumBST( Node root)
    {
        maxsum = Integer.MIN_VALUE;
        return MaxSumBSTUtil(root).currmax;
    }
 
    public static void main(String args[])
    {
        Node root = new Node(5);
        root.left = new Node(14);
        root.right = new Node(3);
        root.left.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(9);
        root.left.left.right = new Node(1);
 
        System.out.println( MaxSumBST(root));
    }
} 
    
