/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.listener;

import gameclient.socket.ClientSocket;
import gameclient.socket.SocketMessageDto;

/**
 *
 * @author Admin
 */
public interface OnHaveMessageListener {

    void onHaveMessage(SocketMessageDto message);

}
