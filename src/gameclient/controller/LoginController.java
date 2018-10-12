/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.controller;

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
public class LoginController {

    public UserLoginResponseDto login(UserLoginRequestDto userDto) throws UnsupportedEncodingException, IOException {
        
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("username", userDto.getUsername()));
        urlParameters.add(new BasicNameValuePair("password", userDto.getPassword()));
        UserLoginResponseDto responseDto = HttpClientUtils.requestPost("login", urlParameters, UserLoginResponseDto.class);
        return responseDto;
    }
}
