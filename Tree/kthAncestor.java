package Tree;


public class kthAncestor{
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }

    static int kthan(node root, int n, int k){
          // Write your code here
          if(root==null) return -1;
        
          if(root.data==n) return 0;
          
          int leftDist = kthan(root.left, n,k);
          int rightDist =kthan(root.right, n, k);
          
          if(leftDist== -1 && rightDist== -1) return -1;
          
          int max = Math.max(leftDist,rightDist);
          if(max+1==k) System.out.println(root.data );
           return max+1;
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);
        int n = 4,  k=1;

        kthan(root, n, k);
        
    }
}