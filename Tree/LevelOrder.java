package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static void levelOrder(Node root){
        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();

            if(currNode==null){
                System.out.println();
                if(q.isEmpty()) break;
                else q.add(null);   // for next level
            }

            else{
                System.out.print(currNode.data+" ");
                if(currNode.left!=null)q.add(currNode.left);
                if(currNode.right!=null) q.add(currNode.right);
            }
            
        }
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        levelOrder(root);
        
    }
    
}
