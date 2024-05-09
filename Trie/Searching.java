package Trie;

public class Searching {
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

    // SEARCHING

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

    public static void main(String[] args) {
        
        String[]word ={"the","a","there","their","any"};

        for(int i  =0; i < word.length; i++){
            insert(word[i]);
        }
          System.out.println(search("there"));

    }
}
