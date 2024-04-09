package Tree;


public class Diameter{
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    public static int height(Node root){
        if(root==null) return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
    static int diameterOfBinaryTree(Node root) {

        if(root==null) return 0;
        int dl = diameterOfBinaryTree(root.left);
        int dr = diameterOfBinaryTree(root.right);
        int hl = height(root.left);
        int hr = height(root.right);

        int curr =hl+hr+1;
        return Math.max(curr,Math.max(dl,dr));
        
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(diameterOfBinaryTree(root));
        System.out.println(height(root));        
    }
}