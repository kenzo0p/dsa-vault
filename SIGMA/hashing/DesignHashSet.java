import java.util.LinkedList;

public class DesignHashSet {
    private boolean[] t;

    public DesignHashSet() {
        this.t = new boolean[1000001];
    }

    public void add(int key) {
        t[key] = true;
    }

    public void remove(int key) {
        t[key] = false;
    }

    public boolean contains(int key) {
        return t[key] == true;
    }

    public static void main(String[] args) {

    }
}

class MyHashSet {
    private int numBuckets;
    private LinkedList<Integer>[] buckets;

    public MyHashSet() {
        this.numBuckets = 1500; // a prime number helps distribute keys better
        this.buckets = new LinkedList[numBuckets];
        for (int i = 0; i < numBuckets; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getHashValue(int key) {
        return key % numBuckets;
    }

    public void add(int key) {
        int index = getHashValue(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    public void remove(int key) {
        int index = getHashValue(key);
        buckets[index].removeFirstOccurrence(key);
    }

    public boolean contains(int key) {
        int index = getHashValue(key);
        return buckets[index].contains(key);
    }
}
