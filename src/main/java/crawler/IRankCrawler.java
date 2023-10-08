package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.MovieRankInfo;

public interface IRankCrawler {

	List<MovieRankInfo> rankInfoList = new ArrayList<>();
	// 모든 필드가 가지고 있을 멤버인데 어디다 두지?

	void getRankInfo() throws IOException;

	default List<MovieRankInfo> getRankInfoList() {
		return rankInfoList;
	}

	String getTitle();
}
