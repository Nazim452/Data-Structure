package Tree.BST;

import java.util.ArrayList;

public class RootToLeaf {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }

    static void pathPrint(ArrayList<Integer> path){
        for(int i = 0; i<path.size(); i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    static void pathRootLeadf(node root, ArrayList<Integer> path){
        if(root==null) return;

        path.add(root.data);
        if(root.left==null  && root.right==null) pathPrint(path);

        pathRootLeadf(root.left, path);
        pathRootLeadf(root.right, path);
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        pathRootLeadf(root, new ArrayList<>());

    
        
    }
}
