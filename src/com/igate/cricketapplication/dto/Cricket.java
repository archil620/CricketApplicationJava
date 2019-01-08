package com.igate.cricketapplication.dto;

public class Cricket {

	private int playerId;
	private String playerName;
	private String dob;
	private int age;
	private String team;
	private String battingStyle;
	private String centuries;
	private String matchesPlayed;
	private String runScore;
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getBattingStyle() {
		return battingStyle;
	}
	public void setBattingStyle(String battingStyle) {
		this.battingStyle = battingStyle;
	}
	public String getCenturies() {
		return centuries;
	}
	public void setCenturies(String centuries) {
		this.centuries = centuries;
	}
	public String getMatchesPlayed() {
		return matchesPlayed;
	}
	public void setMatchesPlayed(String matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}
	public String getRunScore() {
		return runScore;
	}
	public void setRunScore(String runScore) {
		this.runScore = runScore;
	}
	
	
	
	
}
