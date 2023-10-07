package model;

import lombok.Builder;
import lombok.Getter;

@Getter
public abstract class MovieRankInfo {

	private final String title;
	private final String rank;
	private final String img;
	private final String age;
	private final String reservationRate;
	private final String openDate;

	// TODO: use builder pattern
	public MovieRankInfo(String title, String rank, String img, String age, String reservationRate, String openDate) {
		this.title = title;
		this.rank = rank;
		this.img = img;
		this.age = age;
		this.reservationRate = reservationRate;
		this.openDate = openDate;
	}

	public String toString() {
		return "RankInfo | title=" + title + ", rank=" + rank + ", img=" + img + ", age=" + age + ", reservationRate=" + reservationRate + ", openDate=" + openDate;
	}
}
