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

    public static Node sortedArrayToBalancedBst(int nums[] , int start , int end){
        /*
			steps -> 
			1 ->  find the mid in sorted array 
			2 ->  initialize root with new value nums[d]
			3-> go to left and right that will return a root store in root.left and rootright
			4->
			return the root
		*/
        if(start > end) return null;
        int mid = start + (end-start)/2;
        Node root = new Node(nums[mid]);
        root.left = sortedArrayToBalancedBst(nums, start, mid-1);
        root.right = sortedArrayToBalancedBst(nums, mid +1, end);
        return root;
    }







    public static void inorders(Node root , ArrayList<Integer>list){
        if(root == null){
            return;
        }
        inorders(root.left ,list );
        list.add(root.data);
        inorders(root.right ,list );
    }
    public static Node sortedArrayListToBalancedBst(ArrayList<Integer>list , int start , int end){
        if(start > end){
            return null;
        }
        int mid = start + (end-start)/2;
        Node root = new Node(list.get(mid));
        root.left = sortedArrayListToBalancedBst(list, start, mid-1);
        root.right = sortedArrayListToBalancedBst(list, mid+1,end);
        return root;
    }
    public static Node bstToBalancesBst(Node root){

        /*
         * step-1  ->  find the inorder of a tree it will give a sorted array and  store it in a arraylist
         * step 2 -> then balance the tree using the function list to balanced the bst
         *        -> same as array to bal bst  find mid -> root = mid -> root.left ,root.  right -> return root; 
         *
         */
        // to calculate the inorder seq to sorted array ans store in listsd
        ArrayList<Integer>list = new ArrayList<>();
        inorders(root ,list);

        // sorted inorder -> balanced tree
        root =  sortedArrayListToBalancedBst(list, 0, list.size()-1);
        return root;
    }





    static class Info3{
        boolean isBST;
        int size;
        int min;
        int max;
        public Info3(boolean isBST , int size , int min , int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }
    public static int maxBst = 0;
    public static Info3 largestBst(Node root){

        /*
         * step->1 = isBst
         * step->2 = size
         * step 3 -> = min
         * step 4-> = max
         */
        //largest bst nodes  = size
        if(root == null) return new Info3(true,  0,Integer.MAX_VALUE, Integer.MIN_VALUE);
        Info3 leftInfo = largestBst(root.left);
        Info3 rightInfo = largestBst(root.right);

        //find size  , min ,  max
        int size = leftInfo.size + rightInfo.size +1;
        int min  = Math.min(root.data , Math.min(leftInfo.min,rightInfo.min));
        int max  = Math.max(root.data , Math.max(leftInfo.max,rightInfo.max));

        //check for valid bst 
        if(root.data <= leftInfo.max || root.data >= rightInfo.min){
            return new Info3(false, size, min, max);
        }

        //if this left ans right is valid then return true  and Max size and maxBst
        if(leftInfo.isBST && rightInfo.isBST){
            maxBst = Math.max(maxBst , size);
            return new Info3(true, size, min, max);
        }

        //otherwise false
        return new Info3(false, size, min, max);
    }






    public static Node createBst(ArrayList<Integer>list , int start , int end){
        if(start > end){
            return null;
        }
        int mid = start + (end-start)/2;
        Node root = new Node(list.get(mid));
        root.left = createBst(list, start, mid -1);
        root.right = createBst(list, mid+1, end);
        return root;

    }
    public static Node mergeBST(Node root1 , Node root2){

        /*
         * step1 -> find the inorders of roots and store it in list -> inorder return an sorted list beacuse of bst
         * step2 -> merge the two list into a final list by using while loop again two loops for if elem still in list1 and list2
         * 
         * 
         * step 3 -> call the new funtion the converts the list into Balanced bst and return it
         *
         */

        // steq -> 1
        ArrayList<Integer>list = new ArrayList<>();
        inorders(root1 , list);
        // steq -> 2
        ArrayList<Integer>list1 = new ArrayList<>();
        inorders(root2 , list1);
        
        // steq -> 3 merge
        ArrayList<Integer>finalList = new ArrayList<>();
        
        int i = 0 , j = 0;
        while(i<list.size() && j<list1.size()){
            if(list.get(i) <= list1.get(j)){
                finalList.add(list.get(i));
                i++;
            }else {
                finalList.add(list1.get(j));
                j++;
            }
        }
        
        while(i<list.size()){
            finalList.add(list.get(i));
            i++;

        }
        while(j<list1.size()){
            finalList.add(list1.get(j));
            j++;

        }

        //step -> 4 -> sorted arrayList -> balanced bst
        return createBst(finalList, 0, finalList.size()-1);
        
    }
    public static void main(String[] args) {
        int values[] = { 3,5,6,8,10,11,12 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        // inorder(root);
        // System.out.println();
        // System.out.println(searchInBST(root, 1000));
        // root = deleteNode(root, 2);
        // inorder(root);

        // printInRange(root, 5, 12);
        // printRoot2Leaf(root, new ArrayList<>());
        // System.out.println(isValidBst(root, null, null));

        // root = mirrorBst(root);
        // preorder(root);
        // System.out.println();
        // Node head = sortedArrayToBalancedBst(values, 0, values.length -1);
        // preorder(head);




        // Create a BST but not balanced
        // Node unbalancedRoot = new Node(8);
        // unbalancedRoot.left = new Node(6);
        // unbalancedRoot.left.left = new Node(5);
        // unbalancedRoot.left.left.left = new Node(3);

        // unbalancedRoot.right = new Node(10);
        // unbalancedRoot.right.right = new Node(11);
        // unbalancedRoot.right.right.right = new Node(12);

        // unbalancedRoot = bstToBalancesBst(unbalancedRoot);
        // preorder(unbalancedRoot);



 
        // Creating the following tree:
        //          50
        //        /    \
        //      30      60
        //     /  \    /  \
        //    5   20  45   70
        //                 /  \
        //               65    85
        // Node node = new Node(50);
        // node.left = new Node(30);
        // node.left.left = new Node(5);
        // node.left.right = new Node(20);
        // node.right = new Node(60);
        // node.right.left = new Node(45);
        // node.right.right = new Node(70);
        // node.right.right.left = new Node(65);
        // node.right.right.right = new Node(85);
        // Info3 info = largestBst(node);
        // System.out.println("Largest bst size : "+maxBst);



        //bst -> 1
        Node root1 = new Node(2);
        root1.left = new Node(1);  
        root1.right = new Node(4);
        
        //bst -> 2
        Node root2 = new Node(9);
        root2.left = new Node(3);  
        root2.right = new Node(12);


        Node root3 =  mergeBST(root1, root2);
        preorder(root3);

    }
}
