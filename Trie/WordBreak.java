package Trie;

public class WordBreak {

    // WORD BREAK - NOT WORKING CHECK LATER__________________________________________



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

    public static boolean wordBreak(String key) {
        if (key.length() == 0)
            return true;

        for (int i = 1; i <= key.length(); i++) {
            String firstcheck = key.substring(0, i);
            String secCheck = key.substring(i);// i to n string

            if (search(firstcheck) && wordBreak(secCheck))
                return true;

        }

        return false;
    }

    public static boolean search(String key) {
        node curr = root;

        for (int i = 0; i < key.length(); i++) {

            int index = key.charAt(i) - 'a';

            if (curr.child[index] == null)
                return false;

            if (i == key.length() - 1 && curr.child[index].eow == false)
                return false;

            curr = curr.child[index]; // going top next level
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
        
        String[]word ={"i","like","sam","samsang","mobile"};
        String key = "ilikesam";
        for(int i  =0; i < word.length; i++){
            insert(word[i]);
        }
        System.out.println(wordBreak(key));
      


    }
}
