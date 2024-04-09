package Tree;

public class SumOfNodes {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }
    static int sum(node root){
        if(root==null) return 0;

        return sum(root.left)+sum(root.right)+root.data;

    }
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);                                         
        root.left.left = new node(14);
        root.left.right = new node(15);
       System.out.println( sum(root));
        
    }
}
