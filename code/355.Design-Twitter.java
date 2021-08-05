class Twitter {
    HashMap<Integer, List<Tweet>> userTweets;
    HashMap<Integer, HashSet<Integer>> followers;
    int time;
    int constant = 100000;
    /** Initialize your data structure here. */
    public Twitter() {
        userTweets = new HashMap<>();
        followers = new HashMap<>();
        time = 0;
    }
    class Tweet{
        int time;
        int tweetId;
        Tweet(int time, int tweetId){
            this.time = time;
            this.tweetId = tweetId;
        }
    }
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        time++;
        if(!userTweets.containsKey(userId))
            userTweets.put(userId, new ArrayList<Tweet>());
        userTweets.get(userId).add(0, new Tweet(time, tweetId));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<Tweet>( new Comparator<Tweet>(){
            @Override
            public int compare(Tweet a, Tweet b){
                return b.time-a.time;
            }
        });
        List<Integer> recentTweets = new ArrayList<>();
  
        int p = 0;
        // System.out.println(userId+" "+followers.getOrDefault(userId, new HashSet<Integer>()));
        for(int i=0;i<10;i++){
            
            for(int followerId: followers.getOrDefault(userId, new HashSet<Integer>())){
                if(userTweets.containsKey(followerId) && userTweets.get(followerId).size() > p)
                    pq.offer(userTweets.get(followerId).get(p));
            }
              if(userTweets.containsKey(userId) && userTweets.get(userId).size() > p)
                    pq.offer(userTweets.get(userId).get(p));
            p++;
          if(recentTweets.size() >= 10)
                break;    
            if(!pq.isEmpty())
            recentTweets.add(pq.poll().tweetId);
        }
                
            // while(!pq.isEmpty() && recentTweets.size() < 10)
            //      recentTweets.add((int)(pq.poll().tweetId));
        return recentTweets;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followers.containsKey(followerId))
            followers.put(followerId, new HashSet<Integer>());
        followers.get(followerId).add(followeeId);
        // System.out.println(followers);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followers.containsKey(followerId) && followers.get(followerId).contains(followeeId))
          followers.get(followerId).remove(followeeId);
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
