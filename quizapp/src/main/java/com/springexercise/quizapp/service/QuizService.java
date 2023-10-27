package com.springexercise.quizapp.service;

import com.springexercise.quizapp.daos.QuestionDao;
import com.springexercise.quizapp.daos.QuizDao;
import com.springexercise.quizapp.models.QuestionModel;
import com.springexercise.quizapp.models.QuestionWrapper;
import com.springexercise.quizapp.models.QuizModel;
import com.springexercise.quizapp.models.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    final
    QuizDao quizDao;

    final QuestionDao questionDao;

    public QuizService(QuizDao quizDao, QuestionDao questionDao) {
        this.quizDao = quizDao;
        this.questionDao = questionDao;
    }

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<QuestionModel> questionModelList =questionDao.findRamdomQuestionByCat(category, numQ);
        QuizModel quizModel = new QuizModel();
        quizModel.setTitle(title);
        quizModel.setQuestions(questionModelList);
        quizDao.save(quizModel);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {
        Optional<QuizModel> quiz = quizDao.findById(id);
        List<QuestionModel> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUsers = new ArrayList<>();
        for(QuestionModel q: questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUsers.add(qw);
        }

        return new ResponseEntity<>(questionsForUsers, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculatedResult(Integer id, List<ResponseModel> responses) {
        QuizModel quiz = quizDao.findById(id).get();
        List<QuestionModel> questions = quiz.getQuestions();
        int right = 0;
        int i =0;

        for(ResponseModel response: responses){
            if(response.getResponse().equals(questions.get(i).getRightAnswer()))
                right++;
            i++;
        }

        return new ResponseEntity<>(right, HttpStatus.OK);
    }
}
