package com.wax.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wax.dao.Course_infoDao;
import com.wax.dao.Topic_InfoDao;
import com.wax.utils.Page;

public class TopicToTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TopicToTeacherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");	
		
		String cPage = request.getParameter("currentPage");
		int currentPage=1;
		if(cPage==null) {
			currentPage=1;
		}else {	
			currentPage=Integer.parseInt(cPage);
		}
		String tea_id = request.getParameter("tea_id");
		Topic_InfoDao dao=new Topic_InfoDao();
		List<Map<String, Object>> topics = dao.searchAllByTea(tea_id,currentPage);
		int totalCount = dao.getTotalCount();
		HttpSession session = request.getSession();
		Page page=new Page(topics,totalCount, currentPage);
		session.setAttribute("topics", page);
		Course_infoDao cdao=new Course_infoDao();
		List<Map<String, Object>> courses = cdao.findAll();
		session.setAttribute("courses", courses);
		response.sendRedirect("/StudentTopic/Essay/teacher/subjects.jsp");	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
