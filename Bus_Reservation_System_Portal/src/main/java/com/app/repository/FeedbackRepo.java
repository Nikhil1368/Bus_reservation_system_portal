package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer> {


}
