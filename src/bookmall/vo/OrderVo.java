package bookmall.vo;

public class OrderVo {
	private Long no;
	private Long price;
	private String receiveAddress;
	private Long memberNo;

	private String name;
	private String email;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getReceiveAddress() {
		return receiveAddress;
	}
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", price=" + price + ", receiveAddress=" + receiveAddress + ", memberNo="
				+ memberNo + ", name=" + name + ", email=" + email + "]";
	}

	
	
}
