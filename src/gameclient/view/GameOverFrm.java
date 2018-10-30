/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.view;

import gameclient.listener.OnHaveMessageListener;
import gameclient.listener.OnLeaveMatchListener;
import gameclient.util.ClientSocket;
import gameclient.util.Constant;
import gameclient.util.SocketMessageDto;
import gameclient.util.UserInfo;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author Nobody
 */
public class GameOverFrm extends javax.swing.JFrame implements OnHaveMessageListener, OnLeaveMatchListener {

    private GamePlayFrm gamePlayFrm;
    private ClientSocket client;
    private final int userId = UserInfo.getInstance().getId();
    private int opponentId;
    private DashBoardFrm dashBoard;

    /**
     * Creates new form GameOverFrm
     *
     * @param client
     */
    public GameOverFrm(ClientSocket client, GamePlayFrm gamePlayFrm, String matchResult, int totalCorrectAnswers, int opponentId, DashBoardFrm dashBoard) {
        initComponents();
        this.setTitle(UserInfo.getInstance().getNickName());
        this.setLocationRelativeTo(null);
        this.dashBoard = dashBoard;
        this.client = client;
        this.client.setOnHaveMessageListener(this);
        this.client.setOnLeaveMatchListener(this);
        this.gamePlayFrm = gamePlayFrm;
        this.opponentId = opponentId;
        this.lbMatchResult.setText(matchResult);
        this.lbTotalCorrectAnswer.setText("Total correct answers: " + String.valueOf(totalCorrectAnswers));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbMatchResult = new javax.swing.JLabel();
        lbTotalCorrectAnswer = new javax.swing.JLabel();
        btnReplay = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        lbWaitForReplay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbMatchResult.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lbMatchResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMatchResult.setText("You won!");

        lbTotalCorrectAnswer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTotalCorrectAnswer.setText("Total correct answers");

        btnReplay.setText("Replay");
        btnReplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplayActionPerformed(evt);
            }
        });

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        lbWaitForReplay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbMatchResult, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbTotalCorrectAnswer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(171, Short.MAX_VALUE))
            .addComponent(lbWaitForReplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbMatchResult, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(lbTotalCorrectAnswer)
                .addGap(18, 18, 18)
                .addComponent(lbWaitForReplay, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReplay)
                .addGap(18, 18, 18)
                .addComponent(btnHome)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        this.client.sendLeaveMatch(opponentId);
        goHome();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnReplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplayActionPerformed
        // TODO add your handling code here:
        btnReplay.setEnabled(false);
        lbWaitForReplay.setText("Waiting for player's response...");
        client.sendChallengeRequest(opponentId);
        System.out.println(opponentId);
        System.out.println(UserInfo.getInstance().getId() + " " + UserInfo.getInstance().getNickName());
    }//GEN-LAST:event_btnReplayActionPerformed

    private void goHome() {
        this.dispose();
        this.dashBoard.setVisible(true);
        this.client.setOnHaveMessageListener(this.dashBoard);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnReplay;
    private javax.swing.JLabel lbMatchResult;
    private javax.swing.JLabel lbTotalCorrectAnswer;
    private javax.swing.JLabel lbWaitForReplay;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onHaveMessage(SocketMessageDto message) {
        //có lời thách đấu tới
        if (message.getType().equals(Constant.CHALLENGE_REQUEST)) {
            int res = showConfirm(String.format("%s want to play again. Accept? ", message.getNickName()));
            if (res == JOptionPane.YES_OPTION) {
                client.sendChallengeResponse(message.getId(), Constant.ACCEPT);
            } else {
                client.sendChallengeResponse(message.getId(), Constant.REJECT);
                goHome();
            }
        }
        
        //tin nhắn trả lời lời thách đấu
        else if (message.getType().equals(Constant.CHALLENGE_RESPONSE)) {
            //từ chối lời thách đấu
            if (message.getMsg().equals(Constant.REJECT)) {
                showMessage(String.format("%s has rejected your request.", message.getNickName()));
                goHome();
            } else if (message.getMsg().equals(Constant.ACCEPT)) {
                this.dispose();
                new GamePlayFrm(message.getQuestionList(), message.getMatchId(), opponentId, client, this.dashBoard).setVisible(true);
            }
        }
    }

    private int showConfirm(String message) {
        return JOptionPane.showConfirmDialog(this, message, "Confirm", JOptionPane.YES_NO_OPTION);
    }

    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    @Override
    public void onLeaveMatch(SocketMessageDto message) {
        if (message.getType().equals(Constant.LEAVE_MATCH)){
            showMessage("Your opponent has left the match!");
            goHome();
        }
    }
}
