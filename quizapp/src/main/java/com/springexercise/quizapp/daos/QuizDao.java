package com.springexercise.quizapp.daos;

import com.springexercise.quizapp.models.QuizModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizDao extends JpaRepository<QuizModel, Integer> {
}
