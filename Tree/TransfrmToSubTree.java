package Tree;

public class TransfrmToSubTree {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }
    static int transform(node root){
        if(root==null) return 0;
         
        int leftChild = transform(root.left);
        int rightChild= transform(root.right);
        
        int data = root.data;
        int newLeft = root.left==null ?0 : root.left.data;
        int newRight = root.right==null ?0 :root.right.data;
        
       root.data  = newLeft+leftChild+newRight+rightChild;
       return data;
    }
    static void preOrder(node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
   
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        transform(root);
        preOrder(root);
        
    }
}
