package Tree;

import java.util.HashMap;

public class DupParanth {
    static HashMap<String, Integer> map;
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }

    static String inorder(node root){
        if(root==null) return "";

        String str ="(";
        str+=inorder(root.left);
        str+=Integer.toString(root.data);
        str+=inorder(root.right);
        str+=")";

        if(map.get(str)!=null && map.get(str)==1)   System.out.print(root.data+" ");

        if(map.containsKey(str)) map.put(str, map.get(str)+1);

        else map.put(str, 1);

        return str;
    }


    static void printAllDup(node root){
        map = new HashMap<>();
        inorder(root);
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(4);
        root.right = new node(3);
        root.left.left = new node(3);
        // root.left.right = new node(5);
        root.right.left = new node(4);
        root.right.left.left = new node(3);
        root.right.right = new node(3);
        printAllDup(root);
        
    }
}
