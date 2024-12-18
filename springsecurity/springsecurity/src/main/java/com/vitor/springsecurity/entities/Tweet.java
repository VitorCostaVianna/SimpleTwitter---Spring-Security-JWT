package com.vitor.springsecurity.entities;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;


@Entity
@Table(name = Tweet.TABLE_NAME)
public class Tweet {

    private static final String TABLE_NAME = "tb_tweets";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "tweet_id")
    private Long tweetId;

    private User user;

    private String content;

    @CreationTimestamp
    private Instant creationTimestamp;

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Instant getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(Instant creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

}
