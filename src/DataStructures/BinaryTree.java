package DataStructures;

class Node {
    int val;
    Node left;
    Node right;

    public Node() {
        this.left = null;
        this.right = null;
    }
    public Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {
    Node root;

    /**
     * Pre-order - recursive
     * 1. Visit current node
     * 2. Visit left child
     * 3. Visit right child
     * */
    static void preOrder(Node root) {
        if (null != root) {
            System.out.printf("%d ", root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * Post-order - recursive
     * 1. Visit left child
     * 2. Visit right child
     * 3. Visit current node
     * */
    static void postOrder(Node root) {
        if (null != root) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.printf("%d ", root.val);
        }
    }

    /**
     * In-order - recursive
     * 1. Visit left child
     * 2. Visit current node
     * 3. Visit right child
     * */
    static void inOrder(Node root) {
        if (null != root) {
            inOrder(root.left);
            System.out.printf("%d ", root.val);
            inOrder(root.right);
        }
    }

    /**
     * calculate height of binary tree - dfs
     * */
    static int heightOfTree() {return 0;}

    public static void main(String[] args) {

        /**
         *                    65
         *                  /    \ ---level 1
         *                 /      \
         *                /        \
         *              25          85 --- level 2
         *             /   \      /     \
         *            /     \    /       \
         *          15      35  75        95  -- level 3
         *                     /  \      /  \
         *                    /    \    /    \
         *                   70    80  90    100 -- level 4
         *
         *      PreOrder binary tree traversal :
         *      65 25 15 35 85 75 70 80 95 90 100
         *
         *      PostOrder binary tree traversal :
         *      15 35 25 70 80 75 90 100 95 85 65
         *
         *      InOrder binary tree traversal :
         *      15 25 35 65 70 75 80 85 90 95 100
         *
         * */

        // root level 0
        Node A = new Node(65);
        // Level 1
        Node B = new Node(25);
        Node C = new Node(85);
        // Level 2
        Node D = new Node(15);
        Node E = new Node(35);
        Node F = new Node(75);
        Node G = new Node(95);
        // Level 3
        Node H = new Node(70);
        Node I = new Node(80);
        Node J = new Node(90);
        Node K = new Node(100);

        // connect Level 0 and 1
        A.left = B;
        A.right = C;
        // connect level 1 and level 2
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        // connect level 2 and level 3
        F.left  = H;
        F.right = I;
        G.left  = J;
        G.right = K;

        System.out.println("PreOrder binary tree traversal :");
        preOrder(A);

        System.out.println("\nPostOrder binary tree traversal :");
        postOrder(A);

        System.out.println("\nInOrder binary tree traversal : ");
        inOrder(A);
    }
}
