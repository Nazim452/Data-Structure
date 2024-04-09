package Tree.BST;

import java.util.ArrayList;

public class MergeBST {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }
    static void getinorder(node root,ArrayList<Integer> inorder) {
        if (root == null) return;
           
        getinorder(root.left, inorder);
        inorder.add(root.data);
        getinorder(root.right,inorder);
    }

    static node createBST(ArrayList<Integer> inorder, int st, int end) {
        if (st > end)
            return null;
        int mid = (st + end) / 2;

        node root = new node(inorder.get(mid));
        root.left = createBST(inorder, st, mid - 1);
        root.right = createBST(inorder, mid + 1, end);

        return root;
    }

    static node margeBST(node root1, node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        getinorder(root1, arr1);

        ArrayList<Integer> arr2 = new ArrayList<>();
        getinorder(root2, arr2);

        // Merge Two sortted arrays
        int i = 0, j = 0;
        ArrayList<Integer> finalArr = new ArrayList<>();

        while (i<arr1.size() && j<arr2.size()) {
            if(arr1.get(i)<=arr2.get(j)){
                finalArr.add(arr1.get(i));
                i++;
            }
            else{
                finalArr.add(arr2.get(j));
                j++;
            }
            
        }
        
        while (i<arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;

            
        }
        while (j<arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
            
        }

        return createBST(finalArr, 0, finalArr.size()-1);


        
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
    public static void main(String[] args) {

        node root1 = new node(2);
        root1.right = new node(4);
        root1.left = new node(1);


        node root2 = new node(9);
        root2.right = new node(12);
        root2.left = new node(3);
        

       node root = margeBST(root1, root2);
       preOrder(root);

    }
}
