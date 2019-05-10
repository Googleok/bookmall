package bookmall.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
//		insert(53000L, "서울시", 1L, 3L, 1L);
//		insert(80000L, "부산시", 2L, 4L, 3L);
//		delete(13L);
//		delete(14L);

//		getOrderListTest(1L);
//		getOrderBookListTest(7L);
		
		getOrderListCount("20190510");
	}
	
	public static void insert(Long price, String receiveAddress, Long memberNo, Long totalCount, Long bookNo) {
		new OrderDao().insertOrder(price, receiveAddress, memberNo, totalCount, bookNo);
	}
	
	public static void delete(Long no) {
		new OrderDao().deleteOrderBook(no);
	}
	
	public static void getOrderListTest(Long memberNo) {
		List<OrderVo> list = new OrderDao().getOrderList(memberNo);
		for(OrderVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void getOrderBookListTest(Long orderNo) {
		List<OrderBookVo> list = new OrderDao().getOrderBookList(orderNo);
		for(OrderBookVo vo : list) {
			System.out.println(vo);
		}
	}
	
	public static void getOrderListCount(String date) {
		System.out.println(new OrderDao().getOrderListCount(date));
	}
	
	
}
