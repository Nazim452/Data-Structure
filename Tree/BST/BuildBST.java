package Tree.BST;

public class BuildBST {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }

    static node insert(node root , int val){
        if(root==null) return new node(val);

        if(root.data>val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }
    static void inorder(node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        int value [] = {5,1,3,4,2,7};
        node root = null;

        for(int i = 0; i<value.length; i++) {
            root = insert(root, value[i]);
        }
        inorder(root);
        
    }
}
