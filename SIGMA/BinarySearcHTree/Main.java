import java.util.*;
public class Main {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            ;
        }

    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // ḷeft subtree
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean searchInBST(Node root, int target) {
        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }
        if (root.data > target) {
            return searchInBST(root.left, target);
        } else {

            return searchInBST(root.right, target);
        }

    }

    public static Node deleteNode(Node root, int target) {
        if(root == null){
            return null;
        }
        if (root.data < target) {
            root.right = deleteNode(root.right, target);
        } else if (root.data > target) {
            root.left = deleteNode(root.left, target);
        } else {// voila
                // case 1 - LEAF NODE
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2 -> single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3 -> two childrens
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = deleteNode(root.right, IS.data);

        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.println(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data > k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);

        }
    }





    public static void printPath(ArrayList<Integer>path){
        for(int i = 0;i<path.size();i++){
            System.out.print(path.get(i)  + "->");
        }
        System.out.println("null");
    }
    public static void printRoot2Leaf(Node root , ArrayList<Integer>path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);//to remove the last elem to backtack
    }

    public static boolean isValidBst(Node root , Node min , Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }else if(max != null && root.data >= max.data){
            return false;
        }
        return isValidBst(root.left, min, root) && isValidBst(root.right, root, max);
    }







    public static void preorder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static Node mirrorBst(Node root){ // o(n)
        if(root == null){
            return null;
        }
        //crate mirror for leftSubtree and rightSubtree
        Node leftSubMirror = mirrorBst(root.left);
        Node rightSubMirror = mirrorBst(root.right);
        //swap the left and right
        root.left = rightSubMirror;
        root.right = leftSubMirror;
        return root;
    }
    public static void main(String[] args) {
        int values[] = { 5, 3, 7, 2, 4, 6, 8 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        // System.out.println(searchInBST(root, 1000));
        // root = deleteNode(root, 2);
        // inorder(root);

        // printInRange(root, 5, 12);
        // printRoot2Leaf(root, new ArrayList<>());
        // System.out.println(isValidBst(root, null, null));

        root = mirrorBst(root);
        preorder(root);
        System.out.println();

    }
}
