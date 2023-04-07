package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Board;
import data.User;
import repository.Boards;
import repository.Users;

/*
 * 
 */
@WebServlet("/home/list")
public class IndexController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SqlSessionFactory factory =
				(SqlSessionFactory)req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		
		String target = req.getParameter("target"); 
		Board found = sqlSession.selectOne("boards.");
		List<User> result = sqlSession.selectList("boards.findLatest");

		
		Date today = new Date();
		req.setAttribute("today", today);
		
		List<Board> list = Boards.boardList();
		
		req.setAttribute("latest", result);
		req.setAttribute("millis", System.currentTimeMillis());
		
		req.getRequestDispatcher("/WEB-INF/home/list.jsp").forward(req, resp);
	}
}
