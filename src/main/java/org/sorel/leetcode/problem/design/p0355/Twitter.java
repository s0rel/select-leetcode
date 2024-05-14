package org.sorel.leetcode.problem.design.p0355;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Twitter {
    private Map</*userId*/Integer, Set</*userId*/Integer>> follows;
    private Map</*userId*/Integer, List<Tweet>> tweets;
    private int timeStamp;

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
        timeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>());
        tweets.get(userId).add(0, new Tweet(tweetId, userId, timeStamp++));
        follows.computeIfAbsent(userId, k -> new HashSet<>()).add(userId);
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!follows.containsKey(userId)) {
            return Collections.emptyList();
        }

        List<Integer> feed = new ArrayList<>();
        Queue<Tweet> queue = new PriorityQueue<>((a, b) -> (b.timeStamp - a.timeStamp));
        Set<Integer> followed = follows.get(userId);
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : followed) {
            if (tweets.containsKey(i)) {
                Tweet tweet = tweets.get(i).get(0);
                queue.add(tweet);
                count.put(tweet.userId, 1);
            }
        }
        while (!queue.isEmpty() && feed.size() < 10) {
            Tweet tweet = queue.poll();
            feed.add(tweet.tweetId);
            int next = count.get(tweet.userId);
            count.put(tweet.userId, next + 1);
            if (next < tweets.get(tweet.userId).size()) {
                queue.add(tweets.get(tweet.userId).get(next));
            }
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followerId);
        follows.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }

    private static class Tweet {
        private int tweetId;
        private int timeStamp;
        private int userId;

        public Tweet(int tweetId, int userId, int timestamp) {
            this.tweetId = tweetId;
            this.timeStamp = timestamp;
            this.userId = userId;
        }
    }
}
