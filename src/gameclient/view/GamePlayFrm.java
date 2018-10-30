/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.view;

import gameclient.controller.UserMatchController;
import gameclient.listener.OnQuitMessageListener;
import gameclient.listener.OnResultListener;
import gameclient.model.Question;
import gameclient.model.UserMatches;
import gameclient.util.ClientSocket;
import gameclient.util.Constant;
import gameclient.util.SocketMessageDto;
import gameclient.util.TimeMatch;
import gameclient.util.UserInfo;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Nobody
 */
public class GamePlayFrm extends javax.swing.JFrame implements OnResultListener, OnQuitMessageListener {
    
    private List<Question> listQuestions;
    private int currentQuestionNumber = 0;
    private int correctAnswer = 0;
    private String selectedAnswer;
    private int matchId;
    private final int userId = UserInfo.getInstance().getId();
    private final UserMatchController userMatchController = new UserMatchController();
    private ClientSocket client;
    private int opponentId;
    private DashBoardFrm dashBoard;
    /**
     * Creates new form DemoQuestion
     */
    
    private TimeMatch timeMatch;
    
    public GamePlayFrm() {
    }
    
    public void setLbTimeLeft(String text) {
        this.lbTimeLeft.setText(text);
    }
    
    public GamePlayFrm(List<Question> listQuestions, int matchId, int opponentId, ClientSocket client, DashBoardFrm dashBoard) {
        initComponents();
        this.dashBoard = dashBoard;
        this.setLocationRelativeTo(null);
        this.matchId = matchId;
        this.opponentId = opponentId;
        this.client = client;
        this.client.setOnResultListener(this);
        this.timeMatch = new TimeMatch(this);
        this.listQuestions = listQuestions;
        this.client.setOnQuitMessageListener(this);
        if (listQuestions.isEmpty()) {
            showMessage("Chua co cau hoi trong CSDL");
        } else {
            setDisplayQuestion(listQuestions.get(currentQuestionNumber));
        }
    }
    
    private void setDisplayQuestion(Question question) {
        this.lbQuestionContent.setText(question.getContent());
        this.rbAns1.setText(question.getAnswer1());
        this.rbAns2.setText(question.getAnswer2());
        this.rbAns3.setText(question.getAnswer3());
        this.rbAns4.setText(question.getAnswer4());
        this.lbCurrentQuestion.setText(String.valueOf(currentQuestionNumber + 1));
        this.lbTotalQuestion.setText(String.valueOf(Constant.RANDOM_QUESTION_NUMBER));
        this.selectedAnswer = "";
        this.buttonGroup1.clearSelection();
    }
    
    private boolean checkAnswer(String answer, Question question) {
        if (answer.equals(question.getKey())) {
            return true;
        }
        return false;
    }
    
    private void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        btnQuit = new javax.swing.JButton();
        btnSubmit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbCurrentQuestion = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbTotalQuestion = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbTimeLeft = new javax.swing.JLabel();
        lbQuestionContent = new javax.swing.JLabel();
        rbAns1 = new javax.swing.JRadioButton();
        rbAns2 = new javax.swing.JRadioButton();
        rbAns3 = new javax.swing.JRadioButton();
        rbAns4 = new javax.swing.JRadioButton();
        btnNext = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnQuit.setText("Quit");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });

        btnSubmit.setText("Submit");
        btnSubmit.setEnabled(false);
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel1.setText("Question:");

        lbCurrentQuestion.setText("1");

        jLabel3.setText("of");

        lbTotalQuestion.setText("10");

        jLabel5.setText("End in:");

        lbTimeLeft.setText("02:30");

        lbQuestionContent.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbQuestionContent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuestionContent.setText("Question content here...");

        buttonGroup1.add(rbAns1);
        rbAns1.setText("Ans 1");
        rbAns1.setName(""); // NOI18N
        rbAns1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAns1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbAns2);
        rbAns2.setText("Ans 2");
        rbAns2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAns2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbAns3);
        rbAns3.setText("Ans 3");
        rbAns3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAns3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbAns4);
        rbAns4.setText("Ans 4");
        rbAns4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAns4ActionPerformed(evt);
            }
        });

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnQuit)
                .addGap(84, 84, 84)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSubmit)
                .addGap(32, 32, 32))
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2))
                .addContainerGap())
            .addComponent(lbQuestionContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbCurrentQuestion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTotalQuestion)
                        .addGap(175, 175, 175)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTimeLeft))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbAns1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbAns3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rbAns4)
                            .addComponent(rbAns2))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbCurrentQuestion)
                    .addComponent(jLabel3)
                    .addComponent(lbTotalQuestion)
                    .addComponent(jLabel5)
                    .addComponent(lbTimeLeft))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbQuestionContent, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAns1)
                    .addComponent(rbAns2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbAns3)
                    .addComponent(rbAns4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNext)
                    .addComponent(btnQuit)
                    .addComponent(btnSubmit))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // TODO add your hand ling code here:
        client.sendQuitMsg(userId, opponentId, matchId, Constant.QUIT);
        this.dispose();
        this.dashBoard.setVisible(true);
    }//GEN-LAST:event_btnQuitActionPerformed

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        try {
            // TODO add your handling code here:
            btnSubmit.setEnabled(false);
            if (checkAnswer(selectedAnswer, listQuestions.get(currentQuestionNumber))) {
                this.correctAnswer++;
            }
            
            timeMatch.stop();
            int time = Constant.TIME_PLAY - timeMatch.getTime();
            UserMatches userMatches = new UserMatches();
            userMatches.setMatchId(matchId);
            userMatches.setTime(time);
            userMatches.setCorrectAnswers(correctAnswer);
            userMatches.setUserId(userId);
            userMatchController.create(userMatches);
        } catch (IOException ex) {
            Logger.getLogger(GamePlayFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void rbAns1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAns1ActionPerformed
        // TODO add your handling code here:
        this.selectedAnswer = this.rbAns1.getText();
    }//GEN-LAST:event_rbAns1ActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (this.selectedAnswer.isEmpty()) {
            showMessage("You must choose an answer!");
            return;
        }
        if (currentQuestionNumber == Constant.RANDOM_QUESTION_NUMBER - 2) {
            this.btnNext.setEnabled(false);
            this.btnSubmit.setEnabled(true);
        }
        if (checkAnswer(selectedAnswer, listQuestions.get(currentQuestionNumber))) {
            this.correctAnswer++;
        }
        currentQuestionNumber++;
        setDisplayQuestion(listQuestions.get(currentQuestionNumber));
    }//GEN-LAST:event_btnNextActionPerformed

    private void rbAns2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAns2ActionPerformed
        // TODO add your handling code here:
        this.selectedAnswer = this.rbAns2.getText();
    }//GEN-LAST:event_rbAns2ActionPerformed

    private void rbAns3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAns3ActionPerformed
        // TODO add your handling code here:
        this.selectedAnswer = this.rbAns3.getText();
    }//GEN-LAST:event_rbAns3ActionPerformed

    private void rbAns4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAns4ActionPerformed
        // TODO add your handling code here:
        this.selectedAnswer = this.rbAns4.getText();
    }//GEN-LAST:event_rbAns4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            // TODO add your handling code here:
            client.sendQuitMsg(userId, opponentId, matchId, Constant.QUIT);
            client.getSession().close();
            System.exit(0);
        } catch (IOException ex) {
            Logger.getLogger(GamePlayFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_formWindowClosing
    
    public JButton getSubmitButton() {
        return this.btnSubmit;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnSubmit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbCurrentQuestion;
    private javax.swing.JLabel lbQuestionContent;
    private javax.swing.JLabel lbTimeLeft;
    private javax.swing.JLabel lbTotalQuestion;
    private javax.swing.JRadioButton rbAns1;
    private javax.swing.JRadioButton rbAns2;
    private javax.swing.JRadioButton rbAns3;
    private javax.swing.JRadioButton rbAns4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onResultListener(SocketMessageDto messageDto) {
        this.dispose();
        switch (Integer.parseInt(messageDto.getMsg())) {
            case Constant.WIN:
//                showMessage(String.format("Your correct answer: %d\nYou win!", messageDto.getCorrectAnswer()));
                new GameOverFrm(this.client, this, "You won!", messageDto.getCorrectAnswer(), opponentId, this.dashBoard).setVisible(true);
                break;
            case Constant.LOSE:
//                showMessage(String.format("Your correct answer: %d\nYou lose!", messageDto.getCorrectAnswer()));
                new GameOverFrm(this.client, this, "You lost!", messageDto.getCorrectAnswer(), opponentId, this.dashBoard).setVisible(true);
                break;
            default:
//                showMessage(String.format("Your correct answer: %d\nMatch draw!", messageDto.getCorrectAnswer()));
                new GameOverFrm(this.client, this, "Drawn match!", messageDto.getCorrectAnswer(), opponentId, this.dashBoard).setVisible(true);
                break;
        }
    }
    
    @Override
    public void onQuitMessageListener(SocketMessageDto messageDto) {
        if (messageDto.getType().equals(Constant.YOU_WIN)) {
            showMessage("Your opponent has quit the match");
            this.dispose();
            this.dashBoard.setVisible(true);
        }
    }
}
