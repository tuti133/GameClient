/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.controller;

import gameclient.model.response.GetRandomQuestionResponseDto;
import gameclient.util.HttpClientUtils;
import java.io.IOException;

/**
 *
 * @author Nobody
 */
public class QuestionController {
    public GetRandomQuestionResponseDto getRandomQuestions(int number) throws IOException{
        String url = String.format("questions//random=%d", number);
        GetRandomQuestionResponseDto response = HttpClientUtils.requestGet(url, GetRandomQuestionResponseDto.class);
        return response;
    }
}
