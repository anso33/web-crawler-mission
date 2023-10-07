package controller;

import crawler.CgvRankCrawler;
import crawler.IRankCrawler;
import crawler.MegaboxRankCrawler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import view.PdfExporter;

public class BoxOfficeRank {

	public BoxOfficeRank () {}

	public void menu() throws IOException {

		IRankCrawler rankCrawler = menuSelectCinema();
		menuSelectResult(rankCrawler);
	}

	private IRankCrawler menuSelectCinema() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("어떤 영화관의 박스오피스 순위를 알고 싶으신가요?\n1. CGV\n2. 메가박스");
		int menu = Integer.parseInt(String.valueOf(br.readLine()));
		IRankCrawler rankCrawler;
		if (menu == 1) {
			rankCrawler = new CgvRankCrawler();
			rankCrawler.getRankInfo();
		} else if (menu == 2) {
			rankCrawler = new MegaboxRankCrawler();
			rankCrawler.getRankInfo();
		} else {
			System.out.println("잘못 입력하셨습니다.");
			return null;
		}
		return rankCrawler;
	}

	private void menuSelectResult (IRankCrawler rankCrawler) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("박스오피스 결과를 어떻게 보여드릴까요?\n1. PDF\n2. Excel\n3. Console");
		int menu = Integer.parseInt(String.valueOf(br.readLine()));
		if (menu == 1) {
			PdfExporter pdfExporter = new PdfExporter();
			pdfExporter.exportRankInfo(rankCrawler.getRankInfoList(), "test");
		} else if (menu == 2) {

		} else {

		}
	}

}
