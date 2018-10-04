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
public class UserInfo {
    private int id;
    private String nickName;
    private int score;
    private UserInfo(){
    }
    private static UserInfo instance;
    public static UserInfo getInstance(){
        if(instance == null){
            instance = new UserInfo();
        }
        return instance;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
