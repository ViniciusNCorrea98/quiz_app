package com.springexercise.quizapp.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ResponseModel {
    private Integer id;
    private String response;
}
