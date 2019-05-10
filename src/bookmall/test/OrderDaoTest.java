package bookmall.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
		OrderVo vo1 = new OrderVo();
		OrderBookVo vo2 = new OrderBookVo();
		boolean result = false;
		
		vo1.setPrice(53000L);
		vo1.setReceiveAddress("서울시");
		vo1.setMemberNo(1L);
		result = insertOrder(vo1);
		
		if(result) {
			vo2.setCount(3L);
			vo2.setOrderNo(vo1.getNo());
			vo2.setBookNo(1L);
			insertOrderBook(vo2);
			vo2.setCount(4L);
			vo2.setOrderNo(vo1.getNo());
			vo2.setBookNo(2L);
			insertOrderBook(vo2);
		}
		
//		vo1.setPrice(33000L);
//		vo1.setReceiveAddress("부산시");
//		vo1.setMemberNo(2L);
//		result = insertOrder(vo1);
//		
//		if(result) {
//			vo2.setCount(4L);
//			vo2.setOrderNo(vo1.getNo());
//			vo2.setBookNo(2L);
//			insertOrderBook(vo2);
//		}
		

		getOrderListTest(1L);
		getOrderBookListTest(1L);
		
		getOrderListCount("20190510");
	}
	
	public static Boolean insertOrder(OrderVo vo) {
		return new OrderDao().insertOrder(vo);
	}
	
	public static void insertOrderBook(OrderBookVo vo) {
		new OrderDao().insertOrderBook(vo);
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
