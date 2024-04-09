package Tree.BST;

public class PrintRange {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }

    static void printINRange(node root , int k1,  int k2){
        if(root == null) return;
        if(root.data>=k1  && root.data<=k2){
            printINRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printINRange(root.right, k1, k2);
        }

        else if(root.data<k1)  printINRange(root.left, k1, k2);
        else printINRange(root.right, k1, k2);
    }

    static node insert(node root , int val){
        if(root==null) return new node(val);

        if(root.data>val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    public static void main(String[] args) {
        int value [] = {5,1,3,4,2,7,10,11,14,8};
        node root = null;

        for(int i = 0; i<value.length; i++) {
            root = insert(root, value[i]);
        }
        printINRange(root, 5, 12);
        
    }
}
