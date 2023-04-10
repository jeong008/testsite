package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.User;

@WebServlet("/views/login-task")
public class LoginTaskController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
		String id = req.getParameter("id");
		String pass = req.getParameter("pass");
		User user = sqlSession.selectOne("users.findById", id);

		if (user == null) {
			resp.sendRedirect("/views/login?cause=error");
		}else {
			if (user.getPass().equals(pass)) {
				HttpSession session = req.getSession();
				session.setAttribute("logon", true);
				session.setAttribute("logonUser", user);
				resp.sendRedirect("/");
			}else {
				resp.sendRedirect("/views/login?cause=error");
			}
		}
		sqlSession.close();
	}
}
