package bookmall.vo;

public class MemberVo {
	private Long no;
	private String name;
	private Long tel;
	private String email;
	private String passwd;
	
	public MemberVo() {
		
	}
	
	public MemberVo(Long no, String name, Long tel, String email, String passwd) {
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.passwd = passwd;
	}

	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", name=" + name + ", tel=" + tel + ", email=" + email + ", passwd=" + passwd
				+ "]";
	}
	
	
}
