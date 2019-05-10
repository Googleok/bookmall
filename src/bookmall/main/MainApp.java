package bookmall.main;

import java.text.Format;
import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class MainApp {
	public static void main(String[] args) {
		getListMember();
		getListCategory();
		getListBook();
		getListCart(1L);
		getListOrder(2L);
		getListOrderBook(1L);
	}

	//멤버 리스트
	public static void getListMember() {
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.getList();
		System.out.println("*******회원리스트*******");
		for(MemberVo vo : list) {
			System.out.println("이름 : "+vo.getName()+", 전화번호 : "+ vo.getTel() + ", 이메일 : "+ vo.getEmail());
		}
	}
	
	//카테고리리스트
	public static void getListCategory() {
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();
		System.out.println("*******카테고리 리스트*******");
		for(CategoryVo vo : list) {
			System.out.println("도서 장르 : "+vo.getName());
		}
	}
	// 책 리스트
	public static void getListBook() {
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		System.out.println("*******도서 리스트*******");
		for(BookVo vo : list) {
			System.out.println("제목 : "+vo.getTitle()+", 가격 : "+ vo.getPrice() + "원, 카테고리넘버 : "+ vo.getCategoryName());
		}
	}
	
	// 카트 리스트
	public static void getListCart(Long memberNo) {
		CartDao dao = new CartDao();
		List<CartVo> list = dao.getList(memberNo);
		System.out.println("*******카트 리스트*******");
		for(CartVo vo : list) {
			System.out.println("이름 : "+vo.getMemberName()+", 제목 : "+ vo.getTitle() + ", 수량 : "+ vo.getCount());
		}
	}
	
	//주문리스트
	public static void getListOrder(Long memberNo) {
		OrderDao dao = new OrderDao();
		List<OrderVo> list = dao.getOrderList(memberNo);
		System.out.println("*******주문 리스트*******");
		for(OrderVo vo : list) {
			System.out.println("이름 : "+vo.getName()+", 가격 : "+ vo.getPrice() + ", 이메일 : "+ vo.getEmail()+", 주소 : "+vo.getReceiveAddress());
		}
	}
	
	// 주문 도서리스트
	public static void getListOrderBook(Long ordersNo) {
		OrderDao dao = new OrderDao();
		List<OrderBookVo> list = dao.getOrderBookList(ordersNo);
		System.out.println("*******주문 도서 리스트*******");
		for(OrderBookVo vo : list) {
			System.out.println("도서 제목 : "+vo.getTitle()+", 수량 : "+ vo.getCount() + ", 가격 : "+ vo.getPrice());
		}
	}

}
