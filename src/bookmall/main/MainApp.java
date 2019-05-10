package bookmall.main;

import java.io.ObjectInputStream.GetField;
import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;

public class MainApp {

	public static void main(String[] args) {

		MemberDao memberDao = new MemberDao();
		CategoryDao categoryDao = new CategoryDao();
		BookDao bookDao = new BookDao();
		CartDao cartDao = new CartDao();
		OrderDao orderDao = new OrderDao();
		
//		memberDao.insert("참내", 76363123L, "thdnjs9570@naver.com", "thdnjs2");
//		memberDao.insert("자기자랑", 40287755L, "whddjr2225@naver.com", "test1234");
//		
//		categoryDao.insert("수필");
//		categoryDao.insert("소설");
//		categoryDao.insert("IT");
//		
//		bookDao.insert("소나기", 15000L, 2L);
//		bookDao.insert("엄홍길의 히말라야", 20000L, 1L);
//		bookDao.insert("자바스크립트 완벽 가이드", 50000L, 3L);
//		
//		cartDao.insert(1L, 2L, 3L);
//		cartDao.insert(1L, 3L, 4L);
//		
//		orderDao.insertOrder(45000L, "서울시", 1L, 3L, 2L);
//		
		// 리스트 뽑아내기
//		memberDao.getList();
//		categoryDao.getList();
//		bookDao.getList();
//		cartDao.getList(1L);
//		orderDao.getOrderList(1L);
//		orderDao.getOrderBookList(1L);
//		orderDao.getOrderListCount("20190510");
		
		
	}
	

}
