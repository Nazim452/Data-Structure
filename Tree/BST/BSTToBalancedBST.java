package Tree.BST;

import java.util.ArrayList;

public class BSTToBalancedBST {
    static class node {
        int data;
        node left;
        node right;

        node(int data) {
            this.data = data;
        }
    }

    static node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st > end)
            return null;
        int mid = (st + end) / 2;

        node root = new node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);

        return root;
    }

    static void getinorder(node root,ArrayList<Integer> inorder) {
        if (root == null) return;
           
        getinorder(root.left, inorder);
        inorder.add(root.data);
        getinorder(root.right,inorder);
    }

    static node balancedBST(node root){
        // Inorder sequence
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        getinorder(root, inorder);

        // Sorted inorder to Balanced BST
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }
    static void preOrder(node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) { 
       
        node root = new node(8);
        root.left = new node(6);
        root.left.left = new node(5);
        root.left.left.left= new node(3);

        root.right = new node(10);
        root.right.right = new node(11);
        root.right.right.right = new node(12);

        root = balancedBST(root);
        preOrder(root);
    }
}
