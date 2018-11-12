/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.model.response;

import gameclient.dto.ResponseDto;
import gameclient.model.User;
import java.util.List;

/**
 *
 * @author Admin
 */
public class GetOnlineUserResponseDto extends ResponseDto{
    List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    
}
