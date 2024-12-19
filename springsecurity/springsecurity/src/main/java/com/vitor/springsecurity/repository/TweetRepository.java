package com.vitor.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitor.springsecurity.entities.Tweet;

public interface TweetRepository extends JpaRepository<Tweet, Long> { 
}
