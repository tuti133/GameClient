/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.util;

import gameclient.dto.ResponseDto;
import gameclient.model.response.UserLoginResponseDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Admin
 */
public class HttpClientUtils {

    private static String getResponseAsString(HttpResponse response) {
        InputStream ips;
        try {
            ips = response.getEntity().getContent();
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(ips));

            StringBuffer result = new StringBuffer();
            String line = "";

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (Exception ex) {
            Logger.getLogger(HttpClientUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static <T extends ResponseDto> T requestPost(String url, List<NameValuePair> params, Class<T> clazz) throws UnsupportedEncodingException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost request = new HttpPost(Constant.BASE_URL + url);
        request.setEntity(new UrlEncodedFormEntity(params));
        HttpResponse response = client.execute(request);
        String responseStr = HttpClientUtils.getResponseAsString(response);
        if (responseStr == null) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        T responseDto = objectMapper.readValue(responseStr, clazz);
        return responseDto;
    }

    public static <T extends ResponseDto> T requestGet(String url, Class<T> clazz) throws UnsupportedEncodingException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(Constant.BASE_URL + url);
        HttpResponse response = client.execute(request);
        String responseStr = HttpClientUtils.getResponseAsString(response);
        if (responseStr == null) {
            return null;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.AUTO_CLOSE_SOURCE, true);
        T responseDto = objectMapper.readValue(responseStr, clazz);
        return responseDto;
    }
}
