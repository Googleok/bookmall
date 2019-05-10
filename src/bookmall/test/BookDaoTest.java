package bookmall.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		insert("나미야 잡화점의 기적", 20000L, 1L);
		insert("한강의 기적", 15000L, 2L);
		insert("자바의 정석", 30000L, 3L);

		updateTitle("낙동강의 기적", 2L);
		updatePrice(50000L, 3L);
		
		getListTest();
	}
	
	public static void insert(String title, Long price, Long categoryNo) {
		BookVo vo = new BookVo();
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategoryNo(categoryNo);
		new BookDao().insert(vo);
	}
	
	// 책이름 변경
	public static void updateTitle(String title, Long no) {
		BookVo vo = new BookVo();
		vo.setTitle("낙동강의 기적");
		vo.setNo(2L);
		new BookDao().updateTitle(vo);
	}
	
	// 책가격 변경
	public static void updatePrice(Long price, Long no) {
		BookVo vo = new BookVo();
		vo.setPrice(price);
		vo.setNo(no);
		new BookDao().updatePrice(vo);
	}	
	
	public static void getListTest() {
		List<BookVo> list = new BookDao().getList();
		for(BookVo vo : list) {
			System.out.println(vo);
		}
	}
}
