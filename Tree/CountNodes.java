package Tree;

public class CountNodes {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }

    static int count(node root){
        if(root==null) return 0;

        int leftCount = count(root.left);
        int rightCount = count(root.right);

        return leftCount+rightCount+1;
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(14);
        root.left.right = new node(15);
       System.out.println( count(root));
        
    }
}
