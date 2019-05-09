package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;

public class CartDao {
	
	public Boolean insert(Long no, Long bookNo, Long totalCount) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into cart values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			pstmt.setLong(2, bookNo);
			pstmt.setLong(3, totalCount);
			
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

	public Boolean update(Long no, Long bookNo, Long totalCount) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "update cart set count=? where no=? and book_no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, totalCount);
			pstmt.setLong(2, no);
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
	
	public Boolean delete(Long no, Long bookNo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "delete from cart where no=? and book_no=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, no);
			pstmt.setLong(2, bookNo);
			
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
	
	public List<CartVo> getList(Long memberNo){
		List<CartVo> result = new ArrayList<CartVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
		
			String sql = "select c.name, b.title, a.count, a.no, a.book_no"
					+ " from cart a, book b, member c"
					+ " where a.no = c.no"
					+ " and a.book_no = b.no"
					+ " and a.no = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setLong(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				String memberName = rs.getString(1);
				String title = rs.getString(2);
				Long count = rs.getLong(3);
				Long no = rs.getLong(4);
				Long bookNo = rs.getLong(5);
				
				CartVo vo = new CartVo();
				vo.setMemberName(memberName);
				vo.setTitle(title);
				vo.setCount(count);
				vo.setNo(no);
				vo.setBookNo(bookNo);
				
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
