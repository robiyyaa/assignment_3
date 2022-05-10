import java.util.*;

public class MyHashTable <K, V> {
    private HashNode<K,V>[] chainArray;
    private int M = 15;
    private int size;


    private class HashNode<K, V>{
        private K  key;
        private V val;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.val = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + val + '}';
        }
    }

    public MyHashTable(int M){
        this.M = size;
        chainArray = new HashNode[M];
        this.size = 0;
    }

    public MyHashTable(){
        this(15);
    }

    public int size() {
        return size;
    }


    private int hash(K key){
        return key.toString().length() % chainArray.length;
    }



    public void put(K key, V value){
        if(key == null || value == null) {
            System.out.println("error");}

        int hashKey = hash(key);
        HashNode head = chainArray[hashKey];
        while(head != null){
            if(head.key == key){
                head.val = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = chainArray[hashKey];
        HashNode em = new HashNode(key,value);
        em.next = head;
        chainArray[hashKey] = em;
    }

    public V remove(K key) {
        int hashKey = hash(key);
        HashNode head = chainArray[hashKey];
        HashNode prev = null;
        while(head!= null){
            if(head.key == key){
                break;
            }
            prev = head;
            head = head.next;
        }

        if(head == null){
            return null;
        }
        size--;

        if(prev != null){
            prev.next = head.next;
        }
        else{
            chainArray[hashKey] = head.next;
        }
        return (V) head.val;
    }





    public void key(V val){
        if(val == null) {
            throw new IllegalArgumentException("Val is null");
        }

        int hashVal = hash((K) val);
        HashNode head = chainArray[hashVal];
        while(head != null){
            if(head.val == val){
                System.out.println(head.key);
            }
            head = head.next;
        }
    }

    public V get(K key){
        if(key == null){
            throw new IllegalArgumentException("Key equals null");
        }

        int hashedKey = hash(key);
        HashNode head = chainArray[hashedKey];
        while(head != null) {
            if (head.key == key) {
                System.out.println(head.val);
            }
            head = head.next;
        }
        return null;
    }



    public boolean contains(V value){
        return contains(value);
    }
}