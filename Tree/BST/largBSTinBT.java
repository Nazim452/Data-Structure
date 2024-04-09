package Tree.BST;

public class largBSTinBT {
    static class node{
        int data;
        node left;
        node right;

        node(int data){
            this.data = data;
        }
    }

    static class info{
        boolean isBST;
        int size;
        int min;
        int max;

        public  info(boolean isBST, int size, int min , int max){
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    static info largestBST(node root){
        if(root==null) return new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        info leftInfo = largestBST(root.left);
        info rightInfo = largestBST(root.right);

        int size =leftInfo.size+rightInfo.size+1;

        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data<=leftInfo.max || root.data>=rightInfo.min) return new info(false, size, min, max);

        if(rightInfo.isBST   &&leftInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new info(true, size, min, max);
        }

        return new info(false, size, min, max);
    }
    public static void main(String[] args) {
        node root = new node(50);
        root.left = new node(30);
        root.left.left = new node(5);
        root.left.right = new node(20);

        root.right = new node(60);
        root.right.right = new node(70);
        root.right.right.right = new node(80);

        root.right.left = new node(45);
        root.right.right.left = new node(65);

        largestBST(root);

        System.out.println("Largest BST - "+maxBST);

        

    }
}
