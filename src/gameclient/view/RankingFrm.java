package gameclient.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gameclient.controller.RankingController;
import net.miginfocom.swing.MigLayout;

public class RankingFrm extends JFrame {

	private static final long serialVersionUID = 2871331266445445320L;
	private JPanel panel;
	private JLabel lblYourRank;
	private JTable table;
	private JButton btnRefresh;
	private JScrollPane scrollPane;
	private JLabel lblRank;

	private RankingController rankCtrl = new RankingController();

	public RankingFrm() {
		setTitle("Hall of Fame");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setMinimumSize(new Dimension(500, 300));

		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[grow][]", "[][grow]"));

		lblYourRank = new JLabel("Your Rank:");
		panel.add(lblYourRank, "flowx,cell 0 0,alignx left,aligny center");

		btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rankCtrl.initData();
			}
		});
		panel.add(btnRefresh, "cell 1 0,alignx right,aligny center");

		scrollPane = new JScrollPane();
		table = new JTable();
		table.setModel(rankCtrl);
		scrollPane.setViewportView(table);
		panel.add(scrollPane, "cell 0 1 2 1,grow");

		lblRank = new JLabel();
		lblRank.setText(rankCtrl.getRank());
		panel.add(lblRank, "cell 0 0,alignx left,aligny center");

		setVisible(true);
	}
}
