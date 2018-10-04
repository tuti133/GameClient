/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.model;

import gameclient.util.Constant;
import gameclient.util.ToObject;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class User implements ToObject {

    private int id;
    private String username;
    private String nickName;
    private String password;
    private String status;
    private int score;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public Object[] toObject() {
        String status = this.status.equals(Constant.AVAILABLE_STATUS) ? "Available" : "Busy";
        return new Object[]{id, nickName, score, status};
    }

}
