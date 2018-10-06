package gameclient.controller;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import gameclient.model.UserRank;

public class RankingController extends AbstractTableModel {

	private static final long serialVersionUID = -4241508350527328087L;

	private final String[] colName = { "No.", "Name", "Total Score", "Average Score", "Average Time" };
	private ArrayList<UserRank> list = new ArrayList<>();
	private int rank;

	public RankingController() {
		this.rank = 0;
	}

	@Override
	public int getColumnCount() {
		return colName.length;
	}

	@Override
	public int getRowCount() {
		return this.list.size();
	}

	@Override
	public String getColumnName(int column) {
		return colName[column];
	}

	@Override
	public Object getValueAt(int row, int column) {
		UserRank rank = this.list.get(row);
		switch (column) {
		case 0:
			return rank.getPosition();
		case 1:
			return rank.getName();
		case 2:
			return rank.getTotalScore();
		case 3:
			return rank.getAverageScore();
		case 4:
			return rank.getAverageTime();
		}
		return null;
	}

	public void initData() {
		
		fireTableDataChanged();
	}

	public String getRank() {
		return rank + "";
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
