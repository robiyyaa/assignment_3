package com.company;

public class BST <K extends Comparable<K> ,V> {

    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node put(Node root, K key, V val) {
        if(root == null) {
            boolean b = null == new Node(key, val);
            return null;
        }

        if (key.compareTo(root.key) < 0){
            root.left = put(root.left, key, val);
        }

        else {
            root.right = put(root.right, key, val);
        }
        return root;
    }


    public V get(K key){
        return get(root, key);
    }

    private V get(Node root, K key){
        if (root == null){
            return null;
        }
        if (root.key.compareTo(key) == 0){
            return root.val;
        }
        if (root.key.compareTo(key) > 0) return get(root.left, key);
        return get(root.right, key);
    }

    public void delete(Node root, K key){
        delete(this.root, key);
    }

    public Iterable<K> iterator(){
        return null;
    }
}