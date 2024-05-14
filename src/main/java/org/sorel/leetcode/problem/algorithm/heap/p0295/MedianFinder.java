package org.sorel.leetcode.problem.algorithm.heap.p0295;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    Queue<Integer> minQueue;
    Queue<Integer> maxQueue;

    public MedianFinder() {
        minQueue = new PriorityQueue<>(Comparator.reverseOrder());
        maxQueue = new PriorityQueue<>(Comparator.naturalOrder());
    }

    public void addNum(int num) {
        if (minQueue.isEmpty() || num <= minQueue.peek()) {
            minQueue.offer(num);
            if (maxQueue.size() + 1 < minQueue.size()) {
                maxQueue.offer(minQueue.poll());
            }
        } else {
            maxQueue.offer(num);
            if (maxQueue.size() > minQueue.size()) {
                minQueue.offer(maxQueue.poll());
            }
        }
    }

    public double findMedian() {
        if (minQueue.size() > maxQueue.size()) {
            return minQueue.peek();
        }
        return (minQueue.peek() + maxQueue.peek()) / 2.0;
    }
}
