/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.model.request;

/**
 *
 * @author Admin
 */
public class UserRegisterRequestDto {

    private String username;
    private String nickName;
    private String password;

    public UserRegisterRequestDto() {
    }

    public UserRegisterRequestDto(String username, String nickName, String password) {
        this.username = username;
        this.nickName = nickName;
        this.password = password;
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

}
