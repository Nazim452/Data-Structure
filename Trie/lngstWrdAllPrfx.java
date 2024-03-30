package Trie;

public class lngstWrdAllPrfx {
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

    
    public static String ans ="";
    public static void longest_Word(node root, StringBuilder temp){
        if(root==null) return;

        for(int i = 0; i<26; i++){
            if(root.child[i]!=null&&root.child[i].eow==true){
                temp.append((char)(i+'a'));

                if(temp.length()>ans.length()) ans = temp.toString();

                longest_Word(root.child[i], temp);

                temp.deleteCharAt(temp.length()-1);
            }
        }
    }
    static node root = new node();


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
        
        String[]word = {"ap","a","app","appl","banan", "apply","apple"};

        for(int i = 0; i<word.length; i++){
            insert(word[i]);
        }

        longest_Word(root, new StringBuilder(""));
        System.out.println(ans);

        
    }
}
