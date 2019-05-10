package bookmall.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
		insert("소설");
		insert("수필");
		insert("컴퓨터/IT");
		
//		update(2L, "만화");
		getListTest();
	}
	
	public static void insert(String categoryName) {
		CategoryVo vo = new CategoryVo();
		vo.setName(categoryName);
		new CategoryDao().insert(vo);
	}
	
	public static void update(Long no, String categoryName) {
		CategoryVo vo = new CategoryVo();
		vo.setNo(no);
		vo.setName(categoryName);
		new CategoryDao().update(vo);
	}
	
	
	
	public static void getListTest() {
		List<CategoryVo> list = new CategoryDao().getList();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
}
