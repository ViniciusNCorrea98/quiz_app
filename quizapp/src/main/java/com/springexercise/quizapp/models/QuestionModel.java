package com.springexercise.quizapp.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class QuestionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;
    private String difficultylevel;
    private String category;

}
