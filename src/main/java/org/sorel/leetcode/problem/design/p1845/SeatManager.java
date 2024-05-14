package org.sorel.leetcode.problem.design.p1845;

import java.util.PriorityQueue;
import java.util.Queue;

public class SeatManager {
    Queue<Integer> queue;
    int i = 1;

    public SeatManager(int n) {
        queue = new PriorityQueue<>();
    }

    public int reserve() {
        return !queue.isEmpty() ? queue.poll() : i++;
    }

    public void unreserve(int seatNumber) {
        queue.add(seatNumber);
    }
}
