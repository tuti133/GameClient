/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.util;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ClientEndpoint;
import javax.websocket.ContainerProvider;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import gameclient.listener.OnHaveMessageListener;
import javax.websocket.OnOpen;

/**
 *
 * @author Admin
 */
@ClientEndpoint
public class ClientSocket {

    private OnHaveMessageListener onHaveMessageListener;
    private Session session = null;

    public ClientSocket() throws Exception {
        URI uri = new URI("ws://localhost:8080/game");
        session = ContainerProvider.getWebSocketContainer().connectToServer(this, uri);
    }

    public void setOnHaveMessageListener(OnHaveMessageListener onHaveMessageListener) {
        this.onHaveMessageListener = onHaveMessageListener;
    }

    @OnOpen
    public void handleOpen(Session session) {
        System.out.println("Connected to Server!");
    }

    @OnMessage
    public void handleMessage(String message) {
        String response = message;
        System.err.println(response);
        if (response.equals("have match")) {
            this.onHaveMessageListener.onHaveRequest(response);
        }
    }

    @OnClose
    public void handleClose() {
        System.out.println("Disconnected to Server!");
    }

    @OnError
    public void handleError(Throwable t) {
        t.printStackTrace();
    }

    public void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
