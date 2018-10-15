/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.controller;

import gameclient.model.ResponseDto;
import gameclient.model.UserMatches;
import gameclient.model.request.UserLoginRequestDto;
import gameclient.model.response.UserLoginResponseDto;
import gameclient.util.HttpClientUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Admin
 */
public class UserMatchController {

    public ResponseDto create(UserMatches userMatches) throws UnsupportedEncodingException, IOException {

        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("matchId", String.valueOf(userMatches.getMatchId())));
        urlParameters.add(new BasicNameValuePair("userId", String.valueOf(userMatches.getUserId())));
        urlParameters.add(new BasicNameValuePair("time", String.valueOf(userMatches.getTime())));
        urlParameters.add(new BasicNameValuePair("correctAnswers", String.valueOf(userMatches.getCorrectAnswers())));

        ResponseDto responseDto = HttpClientUtils.requestPost("user_match", urlParameters, ResponseDto.class);
        
        return responseDto;
    }
}
