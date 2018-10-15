/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient.view;

import com.google.gson.Gson;
import gameclient.controller.UserController;
import gameclient.model.User;
import gameclient.model.response.GetOnlineUserResponseDto;
import gameclient.util.ClientSocket;
import gameclient.util.Constant;
import gameclient.util.UserInfo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import gameclient.listener.OnHaveMessageListener;
import gameclient.util.SocketMessageDto;
import gameclient.util.TimeMatch;
import java.sql.Time;

/**
 *
 * @author Admin
 */
public class DashBoardFrm extends javax.swing.JFrame implements OnHaveMessageListener {

    private final UserController userController = new UserController();
    private final String AVAILABLE = "Available";
    private final String BUSY = "Busy";
    private ClientSocket client = null;
    private final int userId = UserInfo.getInstance().getId();
    private final String nickName = UserInfo.getInstance().getNickName();
    private final Gson gson = new Gson();
    /**
     * Creates new form DashBoardFrm
     */
    public DashBoardFrm() {
        initComponents();
        try {
            //send first message to server for register id
            client = new ClientSocket();
            client.setOnHaveMessageListener(this);
            client.sendMessage(String.format("%d,%s", userId, nickName));
        } catch (Exception ex) {
            Logger.getLogger(DashBoardFrm.class.getName()).log(Level.SEVERE, null, ex);
        }

        lbNickname.setText(String.format("Nickname: %s", UserInfo.getInstance().getNickName()));
        lbScore.setText(String.format("Score: %.1f", UserInfo.getInstance().getScore()));

        //hidden column id
        TableColumnModel tcm = tblHome.getColumnModel();
        tcm.removeColumn(tcm.getColumn(0));

        setupData();
        addEventHandle();
    }

    private void addEventHandle() {
        tblHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table = (JTable) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {

                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    int id = Integer.parseInt(String.valueOf(model.getValueAt(table.getSelectedRow(), 0)));
                    if (id == UserInfo.getInstance().getId()) {
                        return;
                    }
                    int r = showConfirm(String.format("Bạn muốn thách đấu với %s?",
                            String.valueOf(model.getValueAt(table.getSelectedRow(), 1))));
                    if (r == JOptionPane.YES_OPTION) {
                        client.sendChallengeRequest(id);
                        showMessage("Đã gửi lời thách đấu đang đợi phản hồi lại!");
                    }
                }
            }
        });
    }

    private int showConfirm(String message) {
        return JOptionPane.showConfirmDialog(this, message, "Confirm", JOptionPane.YES_NO_OPTION);
    }

    private void setupData() {
        DefaultTableModel model = (DefaultTableModel) tblHome.getModel();
        model.setRowCount(0);
        String value = String.valueOf(cbStatus.getSelectedItem());
        String status;
        switch (value) {
            case BUSY: {
                status = Constant.BUSY_STATUS;
                break;
            }
            case AVAILABLE: {
                status = Constant.AVAILABLE_STATUS;
                break;
            }
            default:
                status = Constant.ONLINE_STATUS;
        }
        List<User> users = getOnlineUser(status);
        users.stream().forEach(u -> {
            if (u.getId() != UserInfo.getInstance().getId()) {
                model.addRow(u.toObject());
            }
        });
    }

    private List<User> getOnlineUser(String status) {
        try {
            GetOnlineUserResponseDto response = userController.getOnlineUser(status);
            if (response == null) {
                showMessage("Lỗi");
                return null;
            }
            return response.getUsers();
        } catch (IOException ex) {
            Logger.getLogger(DashBoardFrm.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
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

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHome = new javax.swing.JTable();
        lbNickname = new javax.swing.JLabel();
        lbScore = new javax.swing.JLabel();
        cbStatus = new javax.swing.JComboBox<>();
        btnLogout = new javax.swing.JButton();
        btnRanking = new javax.swing.JButton();
        btnSoloRandom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setLocation(new java.awt.Point(300, 300));

        tblHome.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "Nickname", "Total Score", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHome);
        if (tblHome.getColumnModel().getColumnCount() > 0) {
            tblHome.getColumnModel().getColumn(0).setResizable(false);
        }

        lbNickname.setText("Nickname");

        lbScore.setText("Score");

        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All","Available", "Busy" }));
        cbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbStatusItemStateChanged(evt);
            }
        });
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnRanking.setText("Ranking");
        btnRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankingActionPerformed(evt);
            }
        });

        btnSoloRandom.setText("Solo Random");
        btnSoloRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoloRandomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(lbNickname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbScore))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnLogout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSoloRandom)
                        .addGap(60, 60, 60)
                        .addComponent(btnRanking)))
                .addGap(35, 35, 35))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbScore)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogout)
                    .addComponent(btnRanking)
                    .addComponent(btnSoloRandom))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNickname))
                .addGap(274, 274, 274))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankingActionPerformed
        // TODO add your handling code here:
        new RankingFrm().setVisible(true);
    }//GEN-LAST:event_btnRankingActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginFrm().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnSoloRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoloRandomActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new GamePlayFrm().setVisible(true);
    }//GEN-LAST:event_btnSoloRandomActionPerformed

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatusActionPerformed

    private void cbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbStatusItemStateChanged
        setupData();
    }//GEN-LAST:event_cbStatusItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRanking;
    private javax.swing.JButton btnSoloRandom;
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbNickname;
    private javax.swing.JLabel lbScore;
    private javax.swing.JTable tblHome;
    // End of variables declaration//GEN-END:variables

    @Override
    public void onHaveMessage(SocketMessageDto message) {
        
        //có lời thách đấu tới
        if(message.getType().equals(Constant.CHALLENGE_REQUEST)){
            int res = showConfirm(String.format("Người chơi %s muốn thách đấu vói "
                    + "bạn bạn muốn chiến ko?", message.getNickName()));
            if(res == JOptionPane.NO_OPTION){
                client.sendChallengeResponse(message.getId(), Constant.REJECT);
                
            }
            else if(res == JOptionPane.YES_OPTION){
                client.sendChallengeResponse(message.getId(), Constant.ACCEPT);
            }
        }
        //tin nhắn trả lời lời thách đấu
        else if(message.getType().equals(Constant.CHALLENGE_RESPONSE)){
            //từ chối lời thách đấu
            if(message.getMsg().equals(Constant.REJECT)){
                showMessage(String.format("Người chơi %s đã từ chối lời thách đấu của bạn", message.getNickName()));
            }
            else if(message.getMsg().equals(Constant.ACCEPT)){
                this.dispose();
                new GamePlayFrm(message.getQuestionList(), message.getMatchId(), client);
            }
        }
        
    }

}
