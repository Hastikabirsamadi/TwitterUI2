package Model;

public class Retweet extends Tweet{
    public Retweet(String body, int likes, int retweets, int comments, User author) {
        super(body, likes, retweets, comments, author);
    }
}
