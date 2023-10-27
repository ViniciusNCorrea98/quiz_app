package com.springexercise.quizapp.service;


import com.springexercise.quizapp.daos.QuestionDao;
import com.springexercise.quizapp.models.QuestionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    final
    QuestionDao questionDao;

    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public ResponseEntity <List<QuestionModel>> getAllQuestions() {
        try{
            return new ResponseEntity<>( questionDao.findAll(), HttpStatus.OK);
        } catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<QuestionModel>> getQuestionByCategory(String category) {
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK) ;
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST) ;
    }

    public ResponseEntity<String> addQuestion(QuestionModel questionModel) {
        questionDao.save(questionModel);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
