
class Pair{
    int time;
    int id;
    Pair(int time, int id){
         this.time = time;
        this.id = id;
       
    }
}
class Twitter {
    HashMap<Integer, ArrayList<Integer>> followersMap; 
    HashMap<Integer, ArrayList<Pair>> postsMap ;
    int time = 0;
    public Twitter() {
        followersMap =  new HashMap<>();
        postsMap = new HashMap<>();
    }
    public void postTweet(int userId, int tweetId) {
        if(!postsMap.containsKey(userId)){
            postsMap.put(userId, new ArrayList<>());
        }
        time++;
        postsMap.get(userId).add(new Pair(time,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> y.time - x.time);
        if (postsMap.containsKey(userId)) {
            pq.addAll(postsMap.get(userId));
        }
        if(followersMap.containsKey(userId)){
            for(Integer followeeId : followersMap.get(userId)){
                if(postsMap.containsKey(followeeId)){ 
                    pq.addAll(postsMap.get(followeeId));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        while(!pq.isEmpty() && count < 10){
            Pair tweet =  pq.poll();
            ans.add(tweet.id);
            count++;
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followersMap.containsKey(followerId)){
            followersMap.put(followerId, new ArrayList<>());
        }
        if (!followersMap.get(followerId).contains(followeeId)) {
            followersMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followersMap.containsKey(followerId)){
            followersMap.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}




// Efficient approach for getNewsFeed() method:
class Pair {
    int time;
    int id;
    Pair(int time, int id) {
        this.time = time;
        this.id = id;
    }
}
class Tuple {
    int time;
    int id;
    int index;
    int userId;  // post belongs to this user
        Tuple(int time, int id, int index, int userId) {
        this.time = time;
        this.id = id;
        this.index = index;
        this.userId = userId;
    }
}

class Twitter {
    HashMap<Integer, ArrayList<Integer>> followersMap; 
    HashMap<Integer, ArrayList<Pair>> postsMap;
    int time =0;

    public Twitter() {
        followersMap = new HashMap<>();
        postsMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        if(!postsMap.containsKey(userId)){
            postsMap.put(userId, new ArrayList<>());
        }
        time++;
        postsMap.get(userId).add(new Pair(time,tweetId));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        List<Pair> userPosts = postsMap.get(userId);
        if (userPosts != null && !userPosts.isEmpty()) {
            int postIndex = userPosts.size() - 1;
            Pair latestPost = userPosts.get(postIndex);
            pq.add(new Tuple(latestPost.time, latestPost.id, postIndex, userId));
        }
        List<Integer> followees = followersMap.get(userId);
        if (followees != null) {
            for (int followeeId : followees) {
                List<Pair> followeePosts = postsMap.get(followeeId);
                if (followeePosts != null && !followeePosts.isEmpty()) {
                    int postIndex = followeePosts.size() - 1;
                    Pair latestPost = followeePosts.get(postIndex);
                    pq.add(new Tuple(latestPost.time, latestPost.id, postIndex, followeeId));
                }
            }
        }
        List<Integer> newsFeed = new ArrayList<>();
        while (!pq.isEmpty() && newsFeed.size() < 10) {
            Tuple topTweet = pq.poll();
            newsFeed.add(topTweet.id);

            int nextIndex = topTweet.index - 1;
            if (nextIndex >= 0) {
                Pair nextPost = postsMap.get(topTweet.userId).get(nextIndex);
                pq.add(new Tuple(nextPost.time, nextPost.id, nextIndex, topTweet.userId));
            }
        }
        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!followersMap.containsKey(followerId)){
            followersMap.put(followerId, new ArrayList<>());
        }

        if(!followersMap.get(followerId).contains(followeeId)) {
            followersMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (followersMap.containsKey(followerId)) {
            followersMap.get(followerId).remove(Integer.valueOf(followeeId));
        }
    }
}