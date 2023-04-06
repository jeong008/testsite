package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Users {

	static final String url = "jdbc:oracle:thin:@192.168.4.95:1521:xe";
	static final String user = "C##BOARD";
	static final String password = "1q2w3e4r";

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

}
