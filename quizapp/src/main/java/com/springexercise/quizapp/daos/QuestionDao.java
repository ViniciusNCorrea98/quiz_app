package com.springexercise.quizapp.daos;

import com.springexercise.quizapp.models.QuestionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<QuestionModel, Integer> {
    List<QuestionModel> findByCategory(String category);

    @Query(value ="SELECT * FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<QuestionModel> findRamdomQuestionByCat(String category, int numQ);
}
