import java.util.*;

class Twitter {
    
    class Tweet {
        int tweetId;
        int userId;
        public Tweet(int tweetId, int userId) {
            this.tweetId = tweetId;
            this.userId = userId;
        }
    }
    
    private Map<Integer, Set<Integer>> followees;
    private List<Tweet> tweetList;

    /** Initialize your data structure here. */
    public Twitter() {
        followees = new HashMap<>();
        tweetList = new ArrayList<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        tweetList.add(new Tweet(tweetId, userId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        if (!followees.containsKey(userId)) {
            followees.put(userId, new HashSet<>());
            followees.get(userId).add(userId);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = tweetList.size() - 1; i >= 0; i--) {
            if (followees.get(userId).contains(tweetList.get(i).userId))
                result.add(tweetList.get(i).tweetId);
            if (result.size() == 10)
                break;
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!followees.containsKey(followerId)) {
            followees.put(followerId, new HashSet<>());
            followees.get(followerId).add(followerId);
        }
        followees.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!followees.containsKey(followerId)) {
            followees.put(followerId, new HashSet<>());
            followees.get(followerId).add(followerId);
        }
        if (followerId == followeeId) return;
        followees.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */