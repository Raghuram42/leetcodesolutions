class Twitter {
    int gt;
    HashMap<Integer, List<int[]>> userTweets;
    HashMap<Integer, HashSet<Integer>> userFol;
    public Twitter() {
        userTweets = new HashMap<>();
        userFol = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!userTweets.containsKey(userId))
            userTweets.put(userId, new ArrayList<>());
        
        userTweets.get(userId).add(new int[]{gt++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        HashSet<Integer> followers = userFol.getOrDefault(userId, new HashSet<>());
        followers.add(userId);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)->b[0]-a[0]);
        
        for(int f: followers){
            for(int[] tw: userTweets.getOrDefault(f, new ArrayList<int[]>())){
                pq.offer(tw);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        int l = 10;
        while(l > 0 && !pq.isEmpty()){
            res.add(pq.poll()[1]);
        l--;
        }
        
        return res;
        
    }
    
    public void follow(int followerId, int followeeId) {
        if(!userFol.containsKey(followerId))
            userFol.put(followerId, new HashSet<>());
        
        userFol.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userFol.containsKey(followerId))
            return;
        userFol.get(followerId).remove(followeeId);
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