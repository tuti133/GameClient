package gameclient.model.response;

import java.util.List;

import gameclient.dto.RankDto;
import gameclient.dto.ResponseDto;

public class RankResponseDTO extends ResponseDto {

	private List<RankDto> rankList;

	public RankResponseDTO() {
		
	}

	public List<RankDto> getRankList() {
		return rankList;
	}

	public void setRankList(List<RankDto> rankList) {
		this.rankList = rankList;
	}

}
