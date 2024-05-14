package org.sorel.leetcode.problem.design.p0460;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class LFUCache {
    Map<Integer, Node> cache;
    Map<Integer, LinkedHashSet<Node>> frequenciesMap;
    int min;
    int size;
    int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        frequenciesMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        increaseFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }

        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            increaseFrequency(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }

            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    private void increaseFrequency(Node node) {
        int frequency = node.frequency;
        Set<Node> set = frequenciesMap.get(frequency);
        set.remove(node);
        if (frequency == min && set.isEmpty()) {
            min = frequency + 1;
        }
        node.frequency++;
        Set<Node> newSet = frequenciesMap.computeIfAbsent(frequency + 1, k -> new LinkedHashSet<>());
        newSet.add(node);
    }

    private void addNode(Node node) {
        Set<Node> set = frequenciesMap.computeIfAbsent(1, k -> new LinkedHashSet<>());
        set.add(node);
        min = 1;
    }

    private Node removeNode() {
        Set<Node> set = frequenciesMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}

class Node {
    int key;
    int value;
    int frequency = 1;

    public Node() {

    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

