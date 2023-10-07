package model;

import lombok.Getter;

@Getter
public class MovieRankInfo {

	private final String title;
	private final String rank;
	private final String img;
	private final String age;
	private final String reservationRate;
	private final String openDate;

	private MovieRankInfo(Builder builder) {
		this.title = builder.title;
		this.rank = builder.rank;
		this.openDate = builder.openDate;
		this.img = builder.img;
		this.age = builder.age;
		this.reservationRate = builder.reservationRate;
	}

	public String toString() {
		return "RankInfo | title=" + title + ", rank=" + rank + ", img=" + img + ", age=" + age + ", reservationRate="
						+ reservationRate + ", openDate=" + openDate;
	}

	public static class Builder {

		private final String title;
		private final String rank;
		private final String openDate;
		private String img = "";
		private String age = "";
		private String reservationRate = "";

		public Builder(String title, String rank, String openDate) {
			this.title = title;
			this.rank = rank;
			this.openDate = openDate;
		}

		public Builder img(String img) {
			this.img = img;
			return this;
		}

		public Builder age(String age) {
			this.age = age;
			return this;
		}

		public Builder reservationRate(String reservationRate) {
			this.reservationRate = reservationRate;
			return this;
		}

		public MovieRankInfo build() {
			return new MovieRankInfo(this);
		}
	}
}
