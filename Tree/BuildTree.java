package Tree;

public class BuildTree {
    
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        
        
    }
    
}
