package model;

import lombok.Builder;
import lombok.Getter;

@Getter
public class MovieRankInfo {

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

	//
	//	public abstract static class Builder<T extends Builder<T>> {
	//		private final String title;
	//		private final String rank;
	//		private String img = "";
	//		private String age = "";
	//		private String reservationRate = "";
	//		private final String openDate;
	//
	//		public Builder(String title, String rank, String openDate) {
	//			this.title = title;
	//			this.rank = rank;
	//			this.openDate = openDate;
	//		}
	//
	//		public Builder img(String img) {
	//			this.img = img;
	//			return this;
	//		}
	//
	//		public Builder age(String age) {
	//			this.age = age;
	//			return this;
	//		}
	//
	//		public Builder reservationRate(String reservationRate) {
	//			this.reservationRate = reservationRate;
	//			return this;
	//		}
	//
	//		abstract MovieRankInfo build();
	//
	//		protected abstract T self();
	//	}

	//		private MovieRankInfo(Builder builder) {
	//			this.title = builder.title;
	//			this.rank = builder.rank;
	//			this.img = builder.img;
	//			this.age = builder.age;
	//			this.reservationRate = builder.reservationRate;
	//			this.openDate = builder.openDate;
	//		}

	public String toString() {
		return "RankInfo | title=" + title + ", rank=" + rank + ", img=" + img + ", age=" + age + ", reservationRate=" + reservationRate + ", openDate=" + openDate;
	}
}
