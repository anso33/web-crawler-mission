package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.MovieRankInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CgvRankCrawler implements IRankCrawler {

	private final String url = "http://www.cgv.co.kr/movies/?lt=1&ft=0";
	private final String title = "Cgv-Ranking";

	public CgvRankCrawler() {
	}

	@Override
	public void getRankInfo() throws IOException {

		Document document = null;
		try {
			document = Jsoup.connect(url).get(); // 예외처리
		} catch (IOException e) {
			e.printStackTrace();
		}

		Elements element = document.select("div.sect-movie-chart");

		Iterator<Element> rank = element.select("strong.rank").iterator();
		Iterator<Element> title = element.select("strong.title").iterator();
		List<String> imgList = new ArrayList<String>();
		for (Element e : element) {
			for (Element td : e.select("span.thumb-image")) {
				String text;
				if (td.select("img").attr("src").isEmpty()) {
					text = td.text();
				} else {
					text = td.select("img").attr("src");
				}
				imgList.add(text);
			}
		}
		Iterator<String> img = imgList.iterator();
		Iterator<Element> age = element.select("div.box-image span.thumb-image").iterator();
		Iterator<Element> reservationRate = element.select("div.box-contents div.score strong.percent span").iterator();
		Iterator<Element> openDate = element.select("div.box-contents span.txt-info strong").iterator();

		while (rank.hasNext()) {
			rankInfoList.add(new MovieRankInfo.Builder(title.next().text(), rank.next().text(), openDate.next().text())
							.img(img.next()).age(age.next().text()).reservationRate(reservationRate.next().text()).build());
		}
	}

	@Override
	public String getTitle() {
		return title;
	}
}
