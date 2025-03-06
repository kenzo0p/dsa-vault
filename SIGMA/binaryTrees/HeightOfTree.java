public class HeightOfTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int nodeCount(Node root) {
        if (root == null) {
            return 0;
        }

        int leftNodes = nodeCount(root.left);
        int rightNodes = nodeCount(root.right);
        int nodes = leftNodes + rightNodes + 1;
        return nodes;
    }

    public static int sumOfNodes(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);
        int nodes = leftSum + rightSum + root.data;
        return nodes;
    }

    public static void main(String[] args) {


          /*
                             1
                           /   \
                         2      3
                       /   \   /   \
                     4      5 6      7
          
          
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        int height = sumOfNodes(root);
        System.out.println(height);
        // System.out.println("Based on edges the height -> " + (height-1));
    }
}
