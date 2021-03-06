package gameclient.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import gameclient.dto.RankDto;
import gameclient.model.response.RankResponseDTO;
import gameclient.util.HttpClientUtils;

public class RankingController extends AbstractTableModel {

	private static final long serialVersionUID = -4241508350527328087L;

	private final String[] colName = { "Name", "Total Score", "Average Opponents Score", "Average Time" };
	private ArrayList<RankDto> list = new ArrayList<>();
	private int rank;

	public RankingController() {
		this.rank = 0;
		initData();
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
		RankDto rank = this.list.get(row);
		switch (column) {
		case 0:
			return rank.getNickName();
		case 1:
			return rank.getScore();
		case 2:
			return rank.getAvgScore();
		case 3:
			return rank.getAvgTime();
		}
		return null;
	}

	public void initData() {
		try {
			RankResponseDTO response = HttpClientUtils.requestGet("rank", RankResponseDTO.class);
			list.clear();
			list.addAll(response.getRankList());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		fireTableDataChanged();
	}

	public String getRank() {
		return rank + "";
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

}
