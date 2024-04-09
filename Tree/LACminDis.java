package Tree;

public class LACminDis {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }
    static node lowestCommonAncestor(node root, int p, int q) {
        if(root==null) return null;

        if(root.data==p||root.data==q) return root;
        node  left =lowestCommonAncestor(root.left, p, q);
        node  right = lowestCommonAncestor(root.right,p,q);
        if(left==null) return right;
        if(right==null) return left;

        return root; 
        
    }

    static int lcaDist(node root , int n){
        if(root==null) return -1;
        if(root.data==n) return 0;
        
        int leftDis = lcaDist(root.left, n);
        int  rightDis =lcaDist(root.right, n);

        if(leftDis==-1  && rightDis==-1) return -1;

        else if(leftDis==-1) return rightDis+1;
        else  return leftDis+1;
    }

    static int minDist(node root, int n1, int n2){
        node lca = lowestCommonAncestor(root, n1, n2);
        int dis1 = lcaDist(lca, n1);
        int dis2 = lcaDist(lca, n2);

        return dis1+dis2;
    }
    public static void main(String[] args) {
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.left.right = new node(5);
        root.right.left = new node(6);
        root.right.right = new node(7);

        int n1 = 4, n2 = 5;
        System.out.println(minDist(root, n1, n2));//2
        
    }
}
