package bookmall.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
//		insert(1L, 1L, 2L);
//		insert(2L, 2L, 3L);
//		update(2L, 2L, 4L);
		
		getListTest(1L);
	}
	
	public static void insert(Long no, Long bookNo, Long totalCount) {
		new CartDao().insert(no, bookNo, totalCount);
	}
	
	public static void update(Long no, Long bookNo, Long totalCount) {
		new CartDao().update(no, bookNo, totalCount);
	}
	
	public static void getListTest(Long memberNo) {
		List<CartVo> list = new CartDao().getList(memberNo);
		for(CartVo vo : list) {
			System.out.println(vo);
		}
	}
}
