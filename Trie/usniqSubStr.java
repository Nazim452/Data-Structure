package Trie;

public class usniqSubStr {
    static class node {
        node[] child;
        boolean eow;

        public node() {
            child = new node[26];
            for (int i = 0; i < child.length; i++) {
                child[i] = null;

            }
            eow = false;
        }
    }
    static node root = new node();
    
    public static int count_Node(node root){
        if(root == null)return 0;

        int count = 0;

        for(int i = 0; i<26; i++){
            if(root.child[i]!=null){
                count+=count_Node(root.child[i]);
            }
        }
        return count+1;
    }
    public static void insert(String word) {
        node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';

            if (curr.child[index] == null)
                curr.child[index] = new node();
            if (i == word.length() - 1)
                curr.child[index].eow = true;

            curr = curr.child[index];

        }

    }
    public static void main(String[] args) {
        
        String str = "ababa";  //10        apple - 15

        for(int i = 0; i < str.length(); i++){


            String suffix = str.substring(i);
            System.out.println("ALl Suffix"+ suffix);
           insert(suffix);


        }
        System.out.println(count_Node(root));
        
    }
    
}
