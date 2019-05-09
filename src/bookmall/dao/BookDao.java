package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.BookVo;

public class BookDao {
	
	public Boolean insert(String title, Long price, Long categoryNo) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into book values(null, ?, ?, ?);";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setLong(2, price);
			pstmt.setLong(3, categoryNo);
			
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

	// 책 이름 변경
	public Boolean update(Long no, String title) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "update book set title=? where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, title);
			pstmt.setLong(2, no);
			
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

	// 책 가격 변경
	public Boolean update(Long no, Long price) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "update book set price=? where no=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, price);
			pstmt.setLong(2, no);
			
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
	
	// 책 카테고리 변경은 스킵
	
	public Boolean delete(Long no) {
		Boolean result = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "delete from book where no=?";
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
	
	public List<BookVo> getList(){
		List<BookVo> result = new ArrayList<BookVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
		
			String sql = "select a.no, a.title, a.price, b.no, b.name from book a, category b"
					+ " where a.category_no = b.no"
					+ " order by a.no asc";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				Long price = rs.getLong(3);
				Long categoryNo = rs.getLong(4);
				String categoryName = rs.getString(5);
				
				BookVo vo = new BookVo(no, title, price, categoryNo, categoryName);
				
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
