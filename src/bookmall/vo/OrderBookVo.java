package bookmall.vo;

public class OrderBookVo {
	private Long no;
	private Long count;
	private Long orderNo;
	private Long bookNo;
	
	private String title;
	private Long price;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
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
	@Override
	public String toString() {
		return "OrderBookVo [no=" + no + ", count=" + count + ", orderNo=" + orderNo + ", bookNo=" + bookNo + ", title="
				+ title + ", price=" + price + "]";
	}
	
	
	
}
