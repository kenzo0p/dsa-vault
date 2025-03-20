import java.util.*;

public class HashMapCode {
    static class HashMap<K, V> {// generics -> parametrized types
        private class Node {
            K key;
            V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }

        }

        private int n;// n
        private int N;
        private LinkedList<Node> buckets[];// N

        @SuppressWarnings("unchecked") // no warnings LL
        public HashMap() {
            this.N = 4;
            this.buckets = new LinkedList[4];
            for (int i = 0; i < 4; i++) {
                this.buckets[i] = new LinkedList<>();
            }
        }
        private int hashFunction(K key) {
            int hc = key.hashCode();
            return Math.abs(hc) % N; // vallue will be in 0 to 3 because hashCode can return any value thats %4

        }
        
        private int SearchInLinkedList(K key, int bi) {
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            // For finding the correct index if we get key then return di otherwise di++
            // else return -1
            for (int i = 0; i < ll.size(); i++) {
                Node node = ll.get(i);
                if (node.key == key) {
                    return di;
                }
                di++;
            }
            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash() {
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LinkedList[N * 2];
            N = 2 * N;
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
            // nodes -> add in bucket
            for (int i = 0; i < oldBuck.length; i++) {
                LinkedList<Node> ll = oldBuck[i];
                for (int j = 0; j < ll.size(); j++) {
                    Node node = ll.get(i);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value) {
            int bi = hashFunction(key);
            int di = SearchInLinkedList(key, bi);// valid; -1
            if (di != -1) {
                Node node = buckets[bi].get(di);
                node.value = value;
            } else {
                buckets[bi].add(new Node(key, value));
                n++;
            }

            double lambda = (double) n / N;
            if (lambda > 2.0) {
                rehash();
            }
        }

        public boolean containsKey(K key) {
            int bi = hashFunction(key);
            int di = SearchInLinkedList(key, bi);// valid; -1
            if (di != -1) {
                return true;
            } else {
                return false;
            }
        }

        public V get(K key) {
            int bi = hashFunction(key);
            int di = SearchInLinkedList(key, bi);// valid; -1
            if (di != -1) {
                Node node = buckets[bi].get(di);

                return node.value;
            } else {
                return null;
            }
        }

        public V remove(K key) {
            int bi = hashFunction(key);
            int di = SearchInLinkedList(key, bi);// valid; -1
            if (di != -1) {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            } else {
                return null;
            }
        }

        public ArrayList<K> keySet() {
            ArrayList<K> keys = new ArrayList<>();
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for (Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }

        public boolean isEmpty() {
            return n == 0;

        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 100);
        map.put("China", 50);
        map.put("Nepal", 5);
        map.put("Indo", 200);
        ArrayList<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(map.get("India"));
        System.out.println(map.remove("India"));
        System.out.println(map.get("India"));
    }
}
