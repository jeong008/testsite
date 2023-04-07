package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import data.User;

public class Users {

	static final String url = "jdbc:oracle:thin:@3.34.136.30:1521:xe";
	static final String user = "C##ALPHA";
	static final String password = "1q2w3e4r";

	
	//로그인
	public static int login(String id, String pass, String nick) {
		try {

			// 연결
			Connection conn = DriverManager.getConnection(url, user, password);

			// 요청객체 (로그인)
			String sql = "INSERT INTO USERS(ID, PASS, NICK) VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pass);
			ps.setString(3, nick);

			int r = ps.executeUpdate();
			conn.close();

			return r;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public static User findById(String id) {
		try {
			
			Connection conn = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT USERS.*, AVATARS.URL AS AVATAR_URL FROM USERS JOIN AVATARS ON USERS.AVATAR_ID = AVATARS.ID WHERE USERS.ID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			User one = null;
			if (rs.next()) {
				one = new User();
				one.setId(rs.getString("id"));
				one.setPass(rs.getString("pass"));
				one.setNick(rs.getString("nick"));

				
			}
			conn.close();
			return one;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
