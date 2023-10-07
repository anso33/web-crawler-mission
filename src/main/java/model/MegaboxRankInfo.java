package model;

public class MegaboxRankInfo extends MovieRankInfo{

	private String likes;

	public MegaboxRankInfo(String title, String rank, String img, String age, String reservationRate, String openDate, String likes) {
		super(title, rank, img, age, reservationRate, openDate);
		this.likes = likes;
	}

	public String toString() {
		return super.toString() + ", likes=" + likes;
	}
}
