package gameclient.model;

public class RankDTO {

	private Integer pos;
	private String username;
	private String nickName;
	private Double score;
	private Double avgScore;
	private Double avgTime;

	public RankDTO() {
		
	}
	
	public RankDTO(Integer pos, String username, String nickName, Double score, Double avgScore, Double avgTime) {
		this.pos = pos;
		this.username = username;
		this.nickName = nickName;
		this.score = score;
		this.avgScore = avgScore;
		this.avgTime = avgTime;
	}

	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Double getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(Double avgScore) {
		this.avgScore = avgScore;
	}

	public Double getAvgTime() {
		return avgTime;
	}

	public void setAvgTime(Double avgTime) {
		this.avgTime = avgTime;
	}

}
