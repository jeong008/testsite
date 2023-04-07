package service;

public class UserService {
	public static boolean validate(String id, String pass, String name) {
		
		if (!id.matches("[a-z][a-z0-9]{3,}")) {   // 소문자+숫자
			return false;
		}
		
		if (pass.length() < 4) {   // 4글자 이상
			return false; 
		}
		
		if (name.length() < 2) {   // 2글자 이상
			return false;
		}
		return true;
		
	}
}
