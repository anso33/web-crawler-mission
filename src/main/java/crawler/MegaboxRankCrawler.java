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

public class MegaboxRankCrawler implements IRankCrawler {

	private static final MegaboxRankCrawler instance = new MegaboxRankCrawler();
	private final String url = "https://www.megabx.co.kr/movie";
	private final String title = "Megabox-Ranking";

	private MegaboxRankCrawler() {
	}

	public static MegaboxRankCrawler getInstance() {
		return instance;
	}

	@Override
	public void getRankInfo() {

		try {
			Document document = Jsoup.connect(url).get(); // 예외처리

			Elements element = document.select("div.movie-list ol.list li.no-img");
			System.out.println(element);

			Iterator<Element> rank = element.select("div.movie-list-info p.rank").iterator();
			Iterator<Element> title = element.select("div.tit-area p.tit").iterator();

			List<String> imgList = new ArrayList<String>();
			for (Element e : element) {
				for (Element td : e.select("div.movie-list-info")) {
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
			Iterator<Element> age = element.select("div.box-image span.thumb-image").iterator(); //
			Iterator<Element> reservationRate = element.select("div.rate-date span.rate").iterator();
			Iterator<Element> openDate = element.select("div.rate-date span.date").iterator();

			while (title.hasNext()) {
				//			System.out.println(
				//							rank.next().text() + "\t" + title.next().text() + "\t" + img.next() + "\t"
				//											+ "\t" + reservationRate.next().text() + "\t" + openDate.next().text());
				rankInfoList.add(new MovieRankInfo.Builder(title.next().text(), rank.next().text(), openDate.next().text())
								.img(img.next()).age(age.next().text()).reservationRate(reservationRate.next().text()).build());
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("MegaboxRank 크롤링 중 오류가 발생했습니다.");
		}
	}

	@Override
	public String getTitle() {
		return title;
	}
}
