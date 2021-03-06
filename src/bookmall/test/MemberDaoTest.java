package bookmall.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		
		insert("박종억", 40287755L, "whddjr2225@naver.com", "test1234");
		insert("박소원", 76363123L, "thdnjs9570@naver.com", "test1234");
		update(2L, "박소원짱", 76363123L, "thdnjs9570@naver.com", "test1234");
		getListTest();
	}
	
	public static void insert(String name, Long tel, String email, String passwd) {
		MemberVo vo = new MemberVo();
		vo.setName(name);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setPasswd(passwd);
		new MemberDao().insert(vo);
	}

	public static void update(Long no, String name, Long tel, String email, String passwd) {
		MemberVo vo = new MemberVo();
		vo.setNo(no);
		vo.setName(name);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setPasswd(passwd);
		new MemberDao().update(vo);
	}	
	
	public static void getListTest() {
		List<MemberVo> list = new MemberDao().getList();
		for(MemberVo vo : list) {
			System.out.println(vo);
		}
	}
}
