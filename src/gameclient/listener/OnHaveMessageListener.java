/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.listener;

import gameclient.util.ClientSocket;
import gameclient.util.SocketMessageDto;

/**
 *
 * @author Admin
 */
public interface OnHaveMessageListener {

    void onHaveMessage(SocketMessageDto message);

    void sendAcceptMessage(String message, ClientSocket clientSocket);
}
