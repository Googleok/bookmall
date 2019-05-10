package bookmall.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
		insert(1L, 1L, 2L);
		insert(2L, 2L, 3L);
		update(2L, 2L, 4L);

		getListTest(2L);
	}
	
	public static void insert(Long memberNo, Long bookNo, Long count) {
		CartVo vo = new CartVo();
		vo.setMemberNo(memberNo);
		vo.setBookNo(bookNo);
		vo.setCount(count);
		new CartDao().insert(vo);
	}
	
	public static void update(Long memberNo, Long bookNo, Long count) {
		CartVo vo = new CartVo();
		vo.setMemberNo(memberNo);
		vo.setBookNo(bookNo);
		vo.setCount(count);
		new CartDao().update(vo);
	}
	
	public static void getListTest(Long memberNo) {
		List<CartVo> list = new CartDao().getList(memberNo);
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	}
}
