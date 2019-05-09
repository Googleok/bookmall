package bookmall.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
//		insert("나미야 잡화점의 기적", 20000L, 1L);
//		insert("한강의 기적", 15000L, 2L);
//		insert("자바의 정석", 30000L, 3L);
//		insert("인문학", 20000L, 4L);
//		insert("경제가 움직인다", 20000L, 5L);
//		insert("다빈치 코드", 20000L, 6L);
//		update(2L, "낙동강의 기적");
		getListTest();
	}
	
	public static void insert(String title, Long price, Long categoryNo) {
		new BookDao().insert(title, price, categoryNo);
	}
	
	// 책이름 변경
	public static void update(Long no, String title) {
		new BookDao().update(no, title);
	}
	
	// 책가격 변경
	public static void update(Long no, Long price) {
		new BookDao().update(no, price);
	}	
	
	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
}
