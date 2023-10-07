package crawler;

import java.io.IOException;
import java.util.List;
import model.MovieRankInfo;

public interface IRankCrawler {
	public void getRankInfo() throws IOException;
	public List<MovieRankInfo> getRankInfoList();
}
