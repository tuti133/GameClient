/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.util;

import com.google.gson.Gson;
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
import gameclient.listener.OnQuitMessageListener;
import gameclient.listener.OnResultListener;
import javax.websocket.OnOpen;

/**
 *
 * @author Admin
 */
@ClientEndpoint
public class ClientSocket {

    private OnHaveMessageListener onHaveMessageListener;
    private OnResultListener onResultListener;
    private OnQuitMessageListener onQuitMessageListener;
    private Session session = null;
    private Gson gson = new Gson();

    public ClientSocket() throws Exception {
        URI uri = new URI("ws://localhost:8080/game");
        session = ContainerProvider.getWebSocketContainer().connectToServer(this, uri);
    }

    public void setOnHaveMessageListener(OnHaveMessageListener onHaveMessageListener) {
        this.onHaveMessageListener = onHaveMessageListener;
    }

    public void setOnQuitMessageListener(OnQuitMessageListener onQuitMessageListener) {
        this.onQuitMessageListener = onQuitMessageListener;
    }

    public void setOnResultListener(OnResultListener onResultListener) {
        this.onResultListener = onResultListener;
    }

    public Session getSession() {
        return session;
    }

    @OnOpen
    public void handleOpen(Session session) {
        System.out.println("Connected to Server!");
    }

    @OnMessage
    public void handleMessage(String message) {
        System.err.println(message);
        try {
            SocketMessageDto response = gson.fromJson(message, SocketMessageDto.class);
            switch (response.getType()) {
                case Constant.RESULT_RESPONSE:
                    onResultListener.onResultListener(response);
                    break;
                case Constant.YOU_WIN:
                    onQuitMessageListener.onQuitMessageListener(response);
                    break;
                default:
                    onHaveMessageListener.onHaveMessage(response);
                    break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @OnClose
    public void handleClose() throws IOException {
        
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

    public void sendChallengeRequest(int userId) {
        try {
            SocketMessageDto dto = new SocketMessageDto();
            dto.setType(Constant.CHALLENGE_REQUEST);
            dto.setId(userId);
            this.session.getBasicRemote().sendText(gson.toJson(dto));
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendChallengeResponse(int userId, String msg) {
        try {
            SocketMessageDto dto = new SocketMessageDto();
            dto.setType(Constant.CHALLENGE_RESPONSE);
            dto.setId(userId);
            dto.setMsg(msg);
            this.session.getBasicRemote().sendText(gson.toJson(dto));
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendQuitMsg(int idUserQuit, int idUserWin, int MatchId, String msg) {
        try {
            SocketMessageDto dto = new SocketMessageDto();
            dto.setType(Constant.QUIT);
            dto.setId(idUserQuit);
            dto.setIdWin(idUserWin);
            dto.setMatchId(MatchId);
            dto.setMsg(msg);
            this.session.getBasicRemote().sendText(gson.toJson(dto));
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
