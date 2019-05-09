package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.OrderBookVo;
import bookmall.vo.OrderVo;

public class OrderDao {
	
	private int tmpMemberPK = 0;
	private Long memberPK = 0L;
	
	
	public Boolean insertOrder(Long price, String receiveAddress, Long memberNo, Long totalCount, Long bookNo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into orders values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, price);
			pstmt.setString(2, receiveAddress);
			pstmt.setLong(3, memberNo);
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			if(result == true) {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select last_insert_id()");
				if(rs.next()) {
					tmpMemberPK = rs.getInt(1);
					memberPK = (long) tmpMemberPK;
				}
				insertOrderBook(totalCount, memberPK, bookNo);
			}
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( pstmt != null) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Boolean insertOrderBook(Long totalCount, Long orderNo, Long bookNo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into order_book values(null, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, totalCount);
			pstmt.setLong(2, orderNo);
			pstmt.setLong(3, bookNo);
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
		
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( pstmt != null) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Boolean deleteOrder(Long no) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "delete from orders where no=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
		
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( pstmt != null) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public Boolean deleteOrderBook(Long orderNo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "delete from order_book where order_no=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, orderNo);
			
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
			if(result == true) {
				deleteOrder(orderNo);
			}
			
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( pstmt != null) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<OrderVo> getOrderList(Long memberNo){
		List<OrderVo> result = new ArrayList<OrderVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
		
			String sql = "select a.no, a.price, a.receive_address, b.name, b.email, a.member_no"
					+ " from orders a, member b "
					+ " where a.member_no = b.no"
					+ " and a.member_no=?";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setLong(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				Long no = rs.getLong(1);
				Long price = rs.getLong(2);
				String receiveAddress = rs.getString(3);
				String name = rs.getString(4);
				String email = rs.getString(5);
				Long memberNoFinal = rs.getLong(6);
				
				OrderVo vo = new OrderVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setEmail(email);
				vo.setPrice(price);
				vo.setReceiveAddress(receiveAddress);
				vo.setMemberNo(memberNoFinal);
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( rs != null) {
					rs.close();
				}
				if( pstmt != null) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<OrderBookVo> getOrderBookList(Long orderNo){
		List<OrderBookVo> result = new ArrayList<OrderBookVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
		
			String sql = "select a.no, b.no, c.title, a.count, a.book_no, c.price"
					+ " from order_book a, orders b, book c "
					+ " where a.order_no = b.no"
					+ " and a.book_no = c.no"
					+ " and order_no=?";
			pstmt = conn.prepareStatement(sql);
		
			pstmt.setLong(1, orderNo);
			
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				Long no = rs.getLong(1);
				Long order_no = rs.getLong(2);
				String title = rs.getString(3);
				Long count = rs.getLong(4);
				Long bookNo = rs.getLong(5);
				Long price = rs.getLong(6);
				
				OrderBookVo vo = new OrderBookVo();
				vo.setNo(no);
				vo.setOrderNo(order_no);
				vo.setTitle(title);
				vo.setCount(count);
				vo.setBookNo(bookNo);
				vo.setPrice(price);
				
				result.add(vo);
			}
			
		} catch (SQLException e) {
			System.out.println("error" + e);
		} finally {
			try {
				if( rs != null) {
					rs.close();
				}
				if( pstmt != null) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.123:3307/bookmall";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading failed..." + e);
		} 
		return conn;
	}
}
