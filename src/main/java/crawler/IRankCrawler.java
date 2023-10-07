package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.MovieRankInfo;

public interface IRankCrawler {

	List<MovieRankInfo> rankInfoList = new ArrayList<>();

	void getRankInfo() throws IOException;

	default List<MovieRankInfo> getRankInfoList() {
		return rankInfoList;
	}

	String getTitle();
}
