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

import data.User;
import repository.Boards;

/*
 * 
 * 
 * 
 */
@WebServlet
public class IndexController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		SqlSessionFactory factory = (SqlSessionFactory)req.getServletContext().getAttribute("sqlSessionFactory");
		
		SqlSession session = factory.openSession();
		// select sql 은 selectOne or selectList
		List<User> result = session.selectList("boards.findLatest");
		  // list 추출
		
		Date today = new Date();
		req.setAttribute("today", today);
		
		List<User> list ;
		
		req.setAttribute("latest", result);
		req.setAttribute("millis", System.currentTimeMillis());
		
		req.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
	}
}
