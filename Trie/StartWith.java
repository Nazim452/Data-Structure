package Trie;

public class StartWith {


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


    public static boolean startWith(String prefix){

        node curr = root;


        for(int i = 0; i<prefix.length(); i++){

            int index = prefix.charAt(i)-'a';

            if(curr.child[index]==null) return false;

            // if exist then upadate level

            curr = curr.child[index];

        }
        return true;


        
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
        
        String[]word = {"apple","app","mango","man"};
        String prefix = "mano";
        for(int i  =0; i < word.length; i++){
            insert(word[i]);
        }

        System.out.println(startWith(prefix));
        
    }
}
