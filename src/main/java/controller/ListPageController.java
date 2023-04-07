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


//글목록 페이지 나눔


@WebServlet("/flow/write-task")
public class ListPageController extends HttpServlet{
	
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
		map.put("arr", cates);
		
		List<Board> rate = sqlSession.selectList("boards.findSomeByAtoBIncates", map);
		
		int total = sqlSession.selectOne("boards.countDatas", cates);
		sqlSession.close();
		
		//페이지 표시
		
		int lastPage = total/11 + (total % 10 > 0 ? 1:0);
		
		req.setAttribute("rate", rate);
		
		int last = (int) Math.ceil(p/10.0) * 10 ;
		int start = last - 9;
		
		last = last > lastPage ? lastPage : last ;
		
		req.setAttribute("start", start);
		req.setAttribute("last", last);
		
		boolean existPrev = p >= 11 ;
		boolean existNext = lastPage > last;
		
		req.setAttribute("exsitPrev", existPrev);
		req.setAttribute("exsitNext", existNext);
		
		req.getRequestDispatcher("/WEB-INF/flow/write-task.jsp").forward(req, resp);		
		
	}
	

}
