package crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.MovieRankInfo;

public interface IRankCrawler {

	List<MovieRankInfo> rankInfoList = new ArrayList<>();
	// 상황마다 변경에 유연하게 두려고 할 때 인터페이스를 쓴다.
	// 구현체를 두어야 할 떄

	//////////Q. 인터페이스의 디폴트 메서드로 둘지, 골격 클래스에서 구현할 지 어떻게 정함?
	//////////-> 메서드를 사용할 범위가 굉장히 공통적(많은 쪽에서)쓰면 인터페이스 구현, 아니면 추상 클래스,
	//////////-> 인터페이스는 "인터페이스" 답게 쓸 수 있도록!!!
	//// 인터페이스에 비즈니스로직이 들어가면 안된다. 인터페이스는 외부에 공개되는 것임을 잊지말자.

	//	default method의 예시로 -> Comparator

	// 모든 필드가 가지고 있을 멤버인데 어디다 두지?

	void getRankInfo() throws IOException;

	default List<MovieRankInfo> getRankInfoList() {
		return rankInfoList;
	}

	String getTitle();
}
