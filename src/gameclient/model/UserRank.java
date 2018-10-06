package gameclient.model;

public class UserRank {

	private int position;
	private String name;
	private double totalScore;
	private double averageScore;
	private double averageTime;

	public UserRank() {

	}

	public UserRank(int position, String name, double totalScore, double averageScore, double averageTime) {
		super();
		this.position = position;
		this.name = name;
		this.totalScore = totalScore;
		this.averageScore = averageScore;
		this.averageTime = averageTime;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	public double getAverageTime() {
		return averageTime;
	}

	public void setAverageTime(double averageTime) {
		this.averageTime = averageTime;
	}

}
