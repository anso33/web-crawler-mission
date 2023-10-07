import controller.BoxOfficeRank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WebCrawler {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("안녕하세요!");

		while (true) {
			System.out.println("어떤 정보를 원하시나요?\n1. 박스 오피스 순위\n2. 영화 상세정보와 상영관\n3. 종료");
			int menu = Integer.parseInt(String.valueOf(br.readLine()));
			if (menu == 1) {
				BoxOfficeRank boxOfficeRank = new BoxOfficeRank();
				boxOfficeRank.menu();
			} else if (menu == 2) {
				System.out.println("아직 준비중입니다...hhhh");
			} else {
				break;
			}
		}
		System.out.println("그럼 좋은 하루 되세요~!");
	}
}
