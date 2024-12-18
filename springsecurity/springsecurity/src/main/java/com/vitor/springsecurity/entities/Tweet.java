package com.vitor.springsecurity.entities;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = Tweet.TABLE_NAME)
public class Tweet {

    private static final String TABLE_NAME = "tb_tweets";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long tweetId;

    private User user;

    private String content;

    @CreationTimestamp
    private Instant creationTimestamp;
}
