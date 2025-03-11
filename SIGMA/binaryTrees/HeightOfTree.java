import java.util.*;

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

    public static int diameter(Node root){//o(n^2)
        if(root == null){
            return 0;
        }
        int leftDiameter = diameter(root.left); 
        int leftHt = height(root.left);
        int rightDiameter = diameter(root.right);
        int rightHt = height(root.right);
        int selfDiameter = leftHt + rightHt+1;
        return Math.max(selfDiameter , Math.max(rightDiameter, leftDiameter));
    }
    static class Info {
        int diameter;
        int height;
        public Info(int diameter , int height){
            this.diameter = diameter;
            this.height = height;
        }
    }
    public static Info diameter2(Node root){//o(n^2)
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);
        int diameter = Math.max(Math.max(leftInfo.diameter ,rightInfo.diameter) , leftInfo.height + rightInfo.height +1 );
        int ht = Math.max(leftInfo.height , rightInfo.height)+1;
        return new Info(diameter, ht);
    }
    public static boolean isIdentical(Node node , Node subRoot){
        if(node == null && subRoot == null){
            return true;
        }else if(node == null || subRoot == null || node.data != subRoot.data){
            return false;
        }

        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
        if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        return true;
    }
    public static boolean isSubtree(Node root  , Node subRoot){
        if(root == null ){
            return false;
        }
        if(root.data == subRoot.data){
            if(isIdentical(root , subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    static class Info2 {
        Node node;
        int hd;
        public Info2(Node node , int hd){
            this.node = node;
            this.hd = hd;
        }
    }
    public static void TopView(Node root){
        // level order traversal
        Queue<Info2>  q = new java.util.LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();
        int min = 0;
        int max  = 0;
        q.add(new Info2(root, 0));
        q.add(null);
        while (!q.isEmpty()) {
            Info2 curr = q.remove();
            if(curr == null){
                if(q.isEmpty()){
                    break;
                }else {
                    q.add(null);
                }
            }else {

                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info2(curr.node.left, curr.hd-1));
                    min = Math.min(min , curr.hd-1);
                }
                if(curr.node.right != null){
                    q.add(new Info2(curr.node.right, curr.hd+1));
                    max = Math.max(max , curr.hd+1);
                }
            }
        }
        for(int i = min;i<=max;i++){
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }
    public static void kLevel(Node root , int level , int k){
        // /in this question we have to print the kth level of the gove tree
        if(root == null){
            return;
        }
        if(level == k){
            System.out.print(root.data + " ");
            return;
        }
        kLevel(root.left, level+1, k);
        kLevel(root.right, level+1, k);
    }
    public static boolean getPath(Node root , int n , ArrayList<Node>path){
        // base case if root is null then return false
        if(root == null){
            return false;
        }
        // root is not null then add to the path
        path.add(root);

        // if root == n -> true
        if(root.data == n){
            return true;
        }


        // find the n in left and right if found return true otherwise ->  false
        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        // if its found in right or left -> true
        if(foundLeft || foundRight){
            return true;
        }

        // else -> false -> and then remove the last node because its also not equal n as we check in his right and also there is no then return false 
        path.remove(path.size()-1);
        return false;
    }

    public static Node lca(Node root , int n1 , int n2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root , n1 , path1);
        getPath(root , n2 , path2);
        
        // last common ancestor
        //iterate over the paths and compare them if its eqaul or not if we got not equal then break;
        int i  = 0;
        for (;i<path1.size() && i < path2.size();i++){
            if(path1.get(i) != path2.get(i)){
                break;
            }
        }

        // store the last elem in lca -> path1 or path2.get(i-1)th index 
        Node lca = path1.get(i-1);
        return lca;
    }


    public static Node lca2(Node root , int n1 , int n2){
        //base case check if the root is null 
        if(root == null){
            return null;
        }
        //if root data equals to n1 or n2 return root
        if( root.data == n1 || root.data == n2 ){
            return root;
        }
        //check in the right and left part
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);


        // leftLca = val rightLCA = nulll
        if(rightLca == null){
            return leftLca;
        }
        if(leftLca == null){
            return rightLca;
        }
        // agar dono not null hain then return root
        return root;
    }
    public static int lcaDist(Node root, int n){
        // base case if root -> null then -1
        if(root == null){
            return -1;
        }
        if(root.data ==n){
            return 0;
        }
        int leftDist = lcaDist(root.left, n);  
        int rightDist = lcaDist(root.right, n);
        //if its not found anywhere then return -1
        if(leftDist == -1 && rightDist == -1){
            return -1;
        }else if(leftDist == -1){
             //if found in right then right +1  -> 0+1 = 1 and so on;
            return rightDist+1;
        }  else {
            //if found in left then left +1  -> 0+1 = 1 and so on;
            return leftDist+1;
        }
        
    }
    public static int  minDistance(Node root , int n1 , int n2){
        // find the lca
        Node lca = lca2(root, n1, n2);
        // find the distance lca and n1
        int dist1 = lcaDist(lca , n1);
        // find the distace between lca and n2
        int dist2 = lcaDist(lca , n2);

        // calculate their distance
        return dist1 + dist2;
    }
    public static int kAncestor(Node root , int n , int k){
        //base case
        if(root == null){
            return -1;
        }
        //if root data == n return ->  0
        if(root.data == n){
            return 0;
        }
        //otherwise get the leftDistance and rightDistance
        int leftDist = kAncestor(root.left, n, k);
        int rightDist = kAncestor(root.right, n, k);
        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        //maximum calcaulate like -1 and 0 -> 0
        int max = Math.max(leftDist ,rightDist);
         //check if max +1 is equal to  k -> 0+1 == k(assume  value is 1) > then print that root data
        if(max +1 == k){
            System.out.println(root.data);
        }
        //otherwise return max+1 for next
        return max+1;
    }
    public static int transformTOSumTree(Node root){//o(n)
        //base case
        if(root == null){
            return 0;
        }
        // calculate left subtree sum and right subtree sum
        int leftChild = transformTOSumTree(root.left);
        int rightChild = transformTOSumTree(root.right);
        //store in this data variable
        int data = root.data;
        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftChild + newRight + rightChild;
        return data;

    }
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
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
        // int k = 3;
        // System.out.println(diameter2(root).diameter);
        // System.out.println("Based on edges the height -> " + (height-1));
        // TopView(root);
        // kLevel(root, 1, k);
        // int n1 = 4 , n2  = 6;
        // System.out.println(lca(root, n1,n2).data);//o(n)
        // System.out.println(lca2(root, n1, n2).data);
        // System.out.println(minDistance(root, n1, n2));
        // int n = 5 , k1 = 1;
        // kAncestor(root, n, k1);
        transformTOSumTree(root);
        preOrder(root);


        /*
                     2
                   /   \
                 4      5
         */
        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        // System.out.println(isSubtree(root, subRoot));
    }
}
