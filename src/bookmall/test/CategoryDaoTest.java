package bookmall.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	public static void main(String[] args) {
//		insert("소설");
//		insert("수필");
//		insert("컴퓨터/IT");
//		insert("인문");
//		insert("경제");
//		insert("예술");
//		update(2L, "만화");
		getListTest();
	}
	
	public static void insert(String categoryName) {
		new CategoryDao().insert(categoryName);
	}
	
	public static void update(Long no, String categoryName) {
		new CategoryDao().update(no, categoryName);
	}
	
	
	
	public static void getListTest() {
		List<CategoryVo> list = new CategoryDao().getList();
		for(CategoryVo vo : list) {
			System.out.println(vo);
		}
	}
}
