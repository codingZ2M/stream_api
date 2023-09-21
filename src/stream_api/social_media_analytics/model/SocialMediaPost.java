package stream_api.social_media_analytics.model;

public class SocialMediaPost {
    private String username;
    private String content;
    private int likes;
    private String category;

    public SocialMediaPost(String username, String content, int likes, String category) {
        this.username = username;
        this.content = content;
        this.likes = likes;
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public String getCategory() {
        return category;
    }
}
