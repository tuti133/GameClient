/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.util;

/**
 *
 * @author Admin
 */
public interface Constant {

    String BASE_URL = "http://localhost:8080/api/";
    String ERROR = "1";
    String ONLINE_STATUS = "0";
    String OFFLINE_STATUS = "1";
    String AVAILABLE_STATUS = "2";
    String BUSY_STATUS = "3";

    int TIME_PLAY = 180;
    int RANDOM_QUESTION_NUMBER = 5;
    
    int LOST = 0;
    int DROW = 1;
    int WIN = 2;

    String SEND_ATTACK_MSG = " You want play with ";
    String ATTACK_REQUEST_MSG = " Play with you? ";
    String ACCEPT_MSG = " Accept this game ";
}
