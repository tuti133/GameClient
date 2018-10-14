package gameclient.model.response;

import java.util.List;

import gameclient.model.RankDTO;
import gameclient.model.ResponseDto;

public class RankResponseDTO extends ResponseDto {

	private List<RankDTO> rankList;

	public RankResponseDTO() {
		
	}

	public List<RankDTO> getRankList() {
		return rankList;
	}

	public void setRankList(List<RankDTO> rankList) {
		this.rankList = rankList;
	}

}
