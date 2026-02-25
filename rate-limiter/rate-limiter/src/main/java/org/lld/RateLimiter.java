package org.lld;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private final int maxRequests;
    private final long windowSizeSeconds;
    private final Map<String, Deque<Long>> userRequests;

    public RateLimiter(int maxRequests, long windowSizeSeconds) {
        this.maxRequests = maxRequests;
        this.windowSizeSeconds = windowSizeSeconds;
        this.userRequests = new HashMap<>();
    }

    public boolean allow(String userId, long timestampSeconds) {
        userRequests.putIfAbsent(userId, new ArrayDeque<>());
        Deque<Long> timestamps = userRequests.get(userId);
        long windowStart = timestampSeconds - windowSizeSeconds;
        while (!timestamps.isEmpty() && timestamps.peekFirst() <= windowStart) {
            timestamps.pollFirst();
        }
        if (timestamps.size() < maxRequests) {
            timestamps.offerLast(timestampSeconds);
            return true;
        }
        return false;
    }
}
