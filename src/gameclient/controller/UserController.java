/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.controller;

import gameclient.model.ResponseDto;
import gameclient.model.request.UserRegisterRequestDto;
import gameclient.model.response.GetOnlineUserResponseDto;
import gameclient.util.HttpClientUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Admin
 */
public class UserController {

    public ResponseDto registerUser(UserRegisterRequestDto requestDto) throws IOException {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", requestDto.getUsername()));
        params.add(new BasicNameValuePair("password", requestDto.getPassword()));
        params.add(new BasicNameValuePair("nickName", requestDto.getNickName()));
        ResponseDto response = HttpClientUtils.requestPost("register", params, ResponseDto.class);
        return response;
    }
    
    public GetOnlineUserResponseDto getOnlineUser(String status) throws IOException{
        String url = String.format("users?status=%s",status);
        GetOnlineUserResponseDto response = HttpClientUtils.requestGet(url, GetOnlineUserResponseDto.class);
        return response;
    }
}
