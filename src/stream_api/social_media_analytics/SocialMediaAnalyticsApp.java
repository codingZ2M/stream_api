package stream_api.social_media_analytics;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import stream_api.social_media_analytics.model.SocialMediaPost;

public class SocialMediaAnalyticsApp {
    public static void main(String[] args) {
    	
        // Sample social media posts
        List<SocialMediaPost> posts = Arrays.asList(
            new SocialMediaPost("user1", "Exciting news!", 100, "News"),
            new SocialMediaPost("user2", "Check out this cute cat video!", 300, "Entertainment"),
            new SocialMediaPost("user3", "Tech trends in 2023", 50, "Technology"),
            new SocialMediaPost("user4", "Delicious recipe for lasagna", 150, "Food"),
            new SocialMediaPost("user5", "Hiking in the mountains", 75, "Travel")
        );

        
        // Filter posts with more than 100 likes
        Stream<SocialMediaPost> popularPosts = posts.stream()
                .filter(post -> post.getLikes() > 100);

        
        // Transform posts into a map by category
        Map<String, List<SocialMediaPost>> postsByCategory = posts.stream()
                .collect(Collectors.groupingBy(SocialMediaPost::getCategory));

        
        // Calculate the total number of likes for each category
        Map<String, Integer> likesByCategory = posts.stream()
                .collect(Collectors.groupingBy(
                        SocialMediaPost::getCategory,
                        Collectors.summingInt(SocialMediaPost::getLikes)
                ));

        
        // Display popular posts
        System.out.println("Popular Posts:");
        popularPosts.forEach(post -> System.out.println(post.getContent()));

        
        // Display posts by category
        System.out.println("\nPosts by Category:");
        postsByCategory.forEach((category, categoryPosts) -> {
            System.out.println(category + ":");
            categoryPosts.forEach(post -> System.out.println("  " + post.getContent()));
        });

        
        // Display total likes by category
        System.out.println("\nLikes by Category:");
        likesByCategory.forEach((category, totalLikes) ->
            System.out.println(category + ": " + totalLikes + " likes"));
        
        System.out.println();
        
     // Sort posts by likes in descending order
        List<SocialMediaPost> sortedPosts = posts.stream()
                .sorted((post1, post2) -> post2.getLikes() - post1.getLikes())
                .collect(Collectors.toList());

        // Limit to the top N posts
        int topN = 3;
        List<SocialMediaPost> topPosts = sortedPosts.stream()
                .limit(topN)
                .collect(Collectors.toList());

        // Display top N posts
        System.out.println("Top " + topN + " Posts:");
        topPosts.forEach(post -> System.out.println(post.getContent()));

        // Peek and display all posts (for demonstration)
        System.out.println("\nAll Posts (Peek):");
        posts.stream()
                .peek(post -> System.out.println(post.getContent()))
                .collect(Collectors.toList()); // Terminal operation to trigger processing
        
        
        System.out.println();
        
     // Extract and display usernames of the top N liked posts
        System.out.println("Usernames of the Top " + topN + " Liked Posts:");
        List<String> topLikedUsernames = topPosts.stream()
                .map(SocialMediaPost::getUsername)
                .collect(Collectors.toList());

        topLikedUsernames.forEach(username -> System.out.println(username));
    
    }
}
