/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.model;

import gameclient.util.Constant;
import gameclient.util.ToObject;
import java.io.Serializable;
import javax.swing.JButton;

/**
 *
 * @author Admin
 */
public class User implements ToObject, Serializable {

    private int id;
    private String username;
    private String nickName;
    private String password;
    private String status;
    private double score;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public Object[] toObject() {
        String status = this.status.equals(Constant.AVAILABLE_STATUS) ? "Available" : "Busy";
        return new Object[]{id, nickName, score, status};
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", nickName=" + nickName + ", password=" + password + ", status=" + status + ", score=" + score + '}';
    }
    
    

}
