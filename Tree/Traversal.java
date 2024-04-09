package Tree;
public class Traversal {

    static int index = -1;

    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }
    static void preOrder(node root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
   
    static void inorder(node root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }
    static void postOrder(node root){
        if(root==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    static node buildTree(int nodes[]){
        index++;
        if(nodes[index]==-1) return null;

        node newNode = new node(nodes[index]);

        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        return newNode;  // returning root
    }
   
   
    public static void main(String[] args) {

        int[]nodes = {1,2,4,-1,-1,5,-1,-1,2,-1,6,-1,-1};

         node root = buildTree(nodes);
         System.out.println(root.data);
        
    }
}
