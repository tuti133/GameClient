/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.controller;

import gameclient.model.request.UserLoginRequestDto;
import gameclient.model.response.UserLoginResponseDto;
import gameclient.util.Constant;
import gameclient.util.HttpClientUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Admin
 */
public class LoginController {

    public UserLoginResponseDto login(UserLoginRequestDto userDto) throws UnsupportedEncodingException, IOException {
        
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("username", userDto.getUsername()));
        urlParameters.add(new BasicNameValuePair("password", userDto.getPassword()));
        UserLoginResponseDto responseDto = HttpClientUtils.requestPost("login", urlParameters, UserLoginResponseDto.class);
        return responseDto;
    }
}
