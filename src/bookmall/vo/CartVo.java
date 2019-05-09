package bookmall.vo;

public class CartVo {
	private Long no;
	private Long bookNo;
	private Long count;

	private String title;
	private String memberName;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	@Override
	public String toString() {
		return "CartVo [no=" + no + ", book_no=" + bookNo + ", count=" + count + ", title=" + title + ", memberName="
				+ memberName + "]";
	}
	
	
	
}
