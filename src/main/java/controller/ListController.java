package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import data.Board;


//글목록


@WebServlet("/flow/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String[] cates = req.getParameterValues("cates");
		
		int p;
		if(req.getParameter("page") == null) {
			p = 1;
		} else {
			p = Integer.parseInt(req.getParameter("page"));
		}
		
		SqlSessionFactory factory = (SqlSessionFactory)req.getServletContext().getAttribute("sqlSessionFactory");
		SqlSession sqlSession = factory.openSession();
		Map<String, Object> map = new HashMap<>();
		
		map.put("a", (p-1) * 10 + 1); 
		map.put("b", 10 * p);
		
		List<Board> rate = sqlSession.selectList("Board.findSomeByAtoB", map);
		
		int total = sqlSession.selectOne("boards.countDatas");
		
		sqlSession.close();
		
		//페이지 표시
		
		int lastPage = total/11 + (total % 10 > 0 ? 1:0);
		int last = (int) Math.ceil(p/10.0) * 10 ;
		int start = last - 9;
		
		last = last > lastPage ? lastPage : last ;
		
		req.setAttribute("rate", rate);
		req.setAttribute("start", start);
		req.setAttribute("last", last);
		
		boolean existPrev = p >= 11 ;
		boolean existNext = lastPage > last;
		
		req.setAttribute("exsitPrev", true);
		req.setAttribute("exsitNext", false);
		
		req.getRequestDispatcher("/WEB-INF/flow/list.jsp").forward(req, resp);		
		
	}
	

}
