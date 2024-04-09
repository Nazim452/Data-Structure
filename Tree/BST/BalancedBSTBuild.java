package Tree.BST;

public class BalancedBSTBuild {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }

    static node createBST(int[]arr, int st, int end){
        if(st>end) return null;
        int mid =(st+end)/2;

        node root = new node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right= createBST(arr, mid+1, end);

        return root;
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
        int[]arr = {2,3,5,6,8,10,12};
        node root = createBST(arr, 0, arr.length-1);
        preOrder(root);
        // inorder(root);
        
        
    }
}
