/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.listener;

import gameclient.socket.SocketMessageDto;

/**
 *
 * @author Nobody
 */
public interface OnQuitMessageListener {
    void onQuitMessageListener(SocketMessageDto messageDto);
}
