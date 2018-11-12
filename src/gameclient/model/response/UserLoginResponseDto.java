/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.model.response;

import gameclient.dto.ResponseDto;
import gameclient.model.User;

/**
 *
 * @author Admin
 */
public class UserLoginResponseDto extends ResponseDto{
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserLoginResponseDto() {
    }
    
}
