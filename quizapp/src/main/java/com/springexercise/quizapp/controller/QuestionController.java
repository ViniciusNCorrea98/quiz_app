package com.springexercise.quizapp.controller;

import com.springexercise.quizapp.models.QuestionModel;
import com.springexercise.quizapp.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    final
    QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("allQuestions")
    public ResponseEntity<List<QuestionModel>> getAllQuestions(){

        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public ResponseEntity<List<QuestionModel>>  getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }


    @PostMapping(value = "add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionModel questionModel){
        return questionService.addQuestion(questionModel);
    }
}
