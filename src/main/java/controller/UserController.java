package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mindrot.jbcrypt.BCrypt;

import data.User;
import service.CookieService;


@WebServlet("/user/login")
public class UserController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String ctxPath = req.getContextPath();
		String uri = req.getRequestURI().substring(ctxPath.length());

		switch (uri) {
		case "/user/login" -> {
			Cookie[] cookies = req.getCookies();
			Cookie found = CookieService.findByName(cookies, "ID_SAVE");

			if (found != null) {
				req.setAttribute("idSave", found.getValue());
			}
			req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
		}

		case "/user/login-task" -> {
			String id = req.getParameter("id");
			String pass = req.getParameter("pass");

			SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactroy");

			SqlSession sqlSession = factory.openSession();
			User found = sqlSession.selectOne("users.findById", id);

			// ======================
			if (found != null && BCrypt.checkpw(pass, found.getPass())) {
				HttpSession session = req.getSession();
				session.setAttribute("logon", true);
				session.setAttribute("logonUser", found);

				// ==
				Cookie c = new Cookie("ID_SAVE", id);
				c.setMaxAge(60 * 60 * 24 * 7);
				c.setPath("/");
				resp.addCookie(c);
				// ==
				resp.sendRedirect("/");
				return;
			} else {
				resp.sendRedirect("/uers/loing?cause=error");
				return;
			}
		}
		default -> {

		}
		}

	}

}
