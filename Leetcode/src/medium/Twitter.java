package medium;

import java.util.*;

public class Twitter {
    HashMap<Integer,User> userHashMap;

    int time;
    public Twitter() {
        time = 0;
        userHashMap = new HashMap<>();
    }
    private User addUser(int userId){
        User user = new User(userId);
        userHashMap.put(userId,user);
        return user;
    }

    public void postTweet(int userId, int tweetId) {
        User user = userHashMap.get(userId);

        if (user == null){
            user = addUser(userId);
        }

        List<Integer> followers = user.getFollowers().stream().toList();

        if (!followers.isEmpty()){
            for (Integer followerId : followers) {
                User follower = userHashMap.get(followerId);
                user.addOwnPost(tweetId,++time);
                follower.addPost(userId,tweetId,time);
            }

        }
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = userHashMap.get(userId);
        return user.getNewTenPost();
    }

    public void follow(int followerId, int followeeId) {
        User followee = userHashMap.get(followeeId);
        User follower = userHashMap.get(followerId);

        if (followee == null) followee = addUser(followeeId);
        if (follower == null) follower = addUser(followerId);

        followee.addFollower(followerId);
        follower.addFollowee(followeeId);
        follower.addFolloweePostList(followee.myPosts);
    }

    public void unfollow(int followerId, int followeeId) {
        User followee = userHashMap.get(followeeId);
        User follower = userHashMap.get(followerId);

        if (followee == null) followee = addUser(followeeId);
        if (follower == null) follower = addUser(followerId);

        followee.dropFollower(followerId);
        follower.dropFollowee(followeeId);
    }
    class User{
        public int userId;
        private PriorityQueue<Post> posts;

        private ArrayList<Post> myPosts;
        private HashSet<Integer> followedBy;
        private HashSet<Integer> followed;

        public User(int userId){
            this.userId = userId;
            posts = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
            myPosts = new ArrayList<>();
            followedBy = new HashSet<>();
            followed = new HashSet<>();

            followedBy.add(userId);
            followed.add(userId);
        }

        HashSet<Integer> getFollowers(){
            return followedBy;
        }

        void addOwnPost(int postId,int time){
            Post post = new Post(userId,postId,time);
            myPosts.add(post);
            posts.offer(post);
        }
        void addPost(int userId,int postId,int time){
            posts.offer(new Post(userId,postId,time));
        }
        void addFolloweePostList(ArrayList<Post> followeePost){
            for (Post post : followeePost) {
                posts.offer(post);
            }
        }

        List<Integer> getNewTenPost(){
            ArrayList<Integer> list = new ArrayList<>();

            while (list.size()<10&&!posts.isEmpty()){
                Post post = posts.poll();
                if (followed.contains(post.userId)) {
                    list.add(post.postId);
                }
            }

            return list;

        }

        void addFollowee(int followeeId){
            followedBy.add(followeeId);
        }

        void dropFollowee(int followeeId){
            followedBy.remove(followeeId);
        }
        void addFollower(int followerId){
            followedBy.add(followerId);
        }

        void dropFollower(int followerId){
            followedBy.remove(followerId);
        }

        class Post{
            int userId;
            int postId;

            int time;

            public Post(int userId,int postId,int time){
                this.userId = userId;
                this.postId = postId;
                this.time = time;

            }
        }

    }
}
