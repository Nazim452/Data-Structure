package HashMap;

import java.util.LinkedList;


// //Working Fine......................................................................


public class OwnHashMap {
    static class myHashMap<K, V> {
        public static final int DEFAULT_CAPACIT = 4;
        public static final float DEFAILT_LOAD_FACTOR = 0.75F;

        private class node {
            K key;
            V value;

            node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

        private int n;

        private LinkedList<node>[] bucket; // made bucket array

        // put empty LL in in each bucket

        private void initBucket(int N) { // N - size of bucket array
            // @SuppressWarnings("unchecked")
            bucket = new LinkedList[N];

            for (int i = 0; i < bucket.length; i++) {
                bucket[i] = new LinkedList<>();

            }

        }

        private int hashFun(K key) {
            int hc = key.hashCode(); // give hash value

            return (Math.abs(hc)) % bucket.length; /// found index of bucket
        }

        private int serch_in_bucket(LinkedList<node> ll, K key) {
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) {
                    return i;
                }

            }
            return -1;
        }

        // rehashing

        private void rehash() {

            LinkedList<node>[] old_bucket = bucket;
            n = 0;
            initBucket(old_bucket.length * 2);

            for (var bucket : old_bucket) { // traverse in old bucket
                for (var node : bucket) { // traverse nod eog each bucket
                    put(node.key, node.value);
                }
            }

        }

        // check capacity after rehashing

        public int capacity() {
            return bucket.length;
        }

        // check load factor after rehashing

        public float loadfactor() {
            return (n * 1.0f) / bucket.length; // load factor = thresold value?capcity

        }

        public myHashMap() {
            initBucket(DEFAULT_CAPACIT);
        }

        public int size() {
            return n;
        }

        public void put(K key, V value) { // INSERT & UPDATE
            int bi = hashFun(key);
            LinkedList<node> currBucket = bucket[bi];

            int ei = serch_in_bucket(currBucket, key);

            if (ei == -1) { // key not exist

                node Node = new node(key, value);
                currBucket.add(Node);
                n++;
            } else { // update case

                node currrNode = currBucket.get(ei);
                currrNode.value = value; // update value

            }

            // rehashing  - current capacity -  bucket.length
            if (n >= bucket.length * DEFAILT_LOAD_FACTOR) { // thresold value = capacity * load factor

                // if value greater than thresold value size double
                rehash();
            }

        }

        public V get(K key) {
            int bi = hashFun(key);
            LinkedList<node> currBucket = bucket[bi];

            int ei = serch_in_bucket(currBucket, key);

            if (ei != -1) { // KEY EXIST

                node currrNode = currBucket.get(ei);
                return currrNode.value;

            }
            // key no

            return null;

        }

        public V remove(K key) {
            int bi = hashFun(key);
            LinkedList<node> currBucket = bucket[bi];

            int ei = serch_in_bucket(currBucket, key);

            if (ei != -1) {
                node currrNode = currBucket.get(ei);
                V val = currrNode.value;
                currBucket.remove(ei);
                n--;
                return val;

            }

            // key not
            return null;

        }
    }

    public static void main(String[] args) {

        myHashMap<String, Integer> mp = new myHashMap<>();
        mp.put("a", 1);
        mp.put("b", 2);

        System.out.println("capcit" + mp.capacity()); // 4
        System.out.println("Load Factor" + mp.loadfactor());// <0.75f
        mp.put("c", 3);
        mp.put("d", 4);
        mp.put("e", 5);

        // System.out.println(mp.size()); //5
        // System.out.println(mp.get("e")); //5
        // System.out.println(mp.get("g")); // null
        // System.out.println(mp.remove("a")); // null

    //    System.out.println( mp.remove("a"));;
        System.out.println(mp.size()); //4
        System.out.println(mp.get("b")); // 2
        System.out.println(mp.get("College")); // null
        System.out.println(mp.remove("dfsdf"));//null
        

        System.out.println("capcit  " + mp.capacity()); // 8
        System.out.println("Load Factor" + mp.loadfactor());// <0.75

    }
}
