package bookmall.vo;

public class BookVo {
	private Long no;
	private String title;
	private Long price;
	
	private Long categoryNo;
	private String categoryName;
	
	public BookVo() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public BookVo(Long no, String title, Long price, Long categoryNo, String categoryName) {
		super();
		this.no = no;
		this.title = title;
		this.price = price;
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}



	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", price=" + price + ", CategoryNo=" + categoryNo
				+ ", CategoryName=" + categoryName + "]";
	}
	
}
