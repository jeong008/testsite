package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import data.Board;

public class Boards {
	
	static final String url = "jdbc:oracle:thin:@192.168.4.95:1521:xe";
	static final String user = "C##BOARD";
	static final String password = "1q2w3e4r";
	

	
	//게시글 작성(등록)
	public static int create(int num, String userId, String boardPass, String title, String content, String writer, Date writed) {
	
		try {
			// 1. 연결
			Connection conn = DriverManager.getConnection(url, user, password);

			// 2. 요청객체 (글작성)
			String sql = "INSERT INTO BAORDS(BAORD_ID, USER_ID, BOARD_PASS, TITLE, CONTENT, WRTIER, WRITED) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setString(2, userId);
			ps.setString(3, boardPass);
			ps.setString(4, title);
			ps.setString(5, content);
			ps.setString(6, writer);
			ps.setDate(7, writed);


			int r = ps.executeUpdate();
			conn.close();

			return r;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	
	
	// 게시글 목록
	public static int boardList(String nick, String title, String writer, Date wried, int num) {
		try {
			
			//연결
			Connection conn = DriverManager.getConnection(url, user, password);
			
			//객체 준비(게시판목록)
			String sql = "INSERT INTO BOARDS(WRITER, TITLE, USER_ID, WRITED, BOARD_ID)";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, nick);
			ps.setString(2, title);
			ps.setString(3, writer);
			ps.setDate(4, wried);
			ps.setInt(5, num);
						
			int r = ps.executeUpdate();
			conn.close();
			
			return r;
						
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	//추천
//	public static int 
	
}