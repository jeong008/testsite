package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@WebServlet("/flow/delect-task")
public class DelectTastController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String boardId = req.getParameter("boardId");

		SqlSessionFactory factory = (SqlSessionFactory) req.getServletContext().getAttribute("sqlSessionFactory");

		SqlSession session = factory.openSession();

		if ((Boolean) req.getSession().getAttribute("logon")) {
			session.delete("boards.deleteBoard", boardId);
		} else {
			String boardPass = req.getParameter("boardPass");
			String pass = session.selectOne("boards.checkLogin", boardId);
			if (!boardPass.equals(pass)) {
				resp.sendRedirect("/flow/delete?cause=error");
			} else {
				session.delete("boards.deleteBoard", boardId);
			}
		}

		req.getRequestDispatcher("WEB-INF/flow/veiws.jsp").forward(req, resp);
	}
}
