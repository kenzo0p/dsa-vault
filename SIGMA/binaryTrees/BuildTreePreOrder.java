import java.util.LinkedList;
import java.util.Queue;

public class BuildTreePreOrder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = right;

        }

    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]) {// o(n)
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        public static void preorderTrav(Node root) {// o(n)
            if (root == null) {
                // System.out.print(-1 + " ");
                return;
            }
            System.out.print(root.data + " ");
            preorderTrav(root.left);
            preorderTrav(root.right);
        }

        public static void inorderTrav(Node root) {// o(n)
            if (root == null) {
                // System.out.print(-1 + " ");
                return;
            }
            inorderTrav(root.left);
            System.out.print(root.data + " ");
            inorderTrav(root.right);
        }

        public static void postorderTrav(Node root) {// o(n)
            if (root == null) {
                // System.out.print(-1 + " ");
                return;
            }
            postorderTrav(root.left);
            postorderTrav(root.right);
            System.out.print(root.data + " ");
        }

        // level order traverssal //! microsoft , fb , adobe
        public static void levelOrder(Node root) {
            if (root == null) {
                return;
            }

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        // agar empty nahi hain to null add kardo kyunki next elem ke baad bhi ti next line chahiye
                        q.add(null);
                    }
                } else {
                    // 
                    System.out.print(currNode.data + " ");
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }

            }
        }

        public static int heightOfTree(){

        }
    }

    public static void main(String[] args) {

        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        tree.levelOrder(root);
        // System.out.println(root.data);
    }
}
