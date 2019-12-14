package com.wax.service;

import java.util.List;
import java.util.Map;

import com.wax.JavaBeen.Class_Info;
import com.wax.JavaBeen.Student_info;
import com.wax.JavaBeen.Teacher_info;
import com.wax.dao.Class_InfoDao;
import com.wax.dao.Student_infoDao;
import com.wax.dao.Teacher_InfoDao;

public class AdminService {
	public List<Map<String, Object>> searchAllStudent(int currentPage) {
		Student_infoDao dao=new Student_infoDao();
		return dao.searchByPage(currentPage);
	}
	public int getStudetnCount () {
		Student_infoDao dao=new Student_infoDao();
		return dao.getTotalCount();
	}
	public int getTeacherCount () {
		Teacher_InfoDao dao=new Teacher_InfoDao();
		return dao.getTotalCount();
	}
	public List<Teacher_info> searchAllTeacher(int currentPage) {
		Teacher_InfoDao dao=new Teacher_InfoDao();
		return dao.searchAll(currentPage);
	}
	public List<Map<String, Object>> searchAllClass () {
		Class_InfoDao dao=new Class_InfoDao();
		return dao.findAll();
	}
	public int addClass(Class_Info cla) {
		Class_InfoDao dao=new Class_InfoDao();
		List<Map<String, Object>> search = dao.search(cla.getClass_id());
		if(search==null||search.size()<=0)
			return dao.insert(cla);
		return 0;
	}
	public int addStudent(Student_info stu) {
		Student_infoDao dao=new Student_infoDao();
		List<Map<String, Object>> search = dao.search(stu.getStu_id());
		if(search==null||search.size()<=0)
			return dao.insert(stu);
		return 0;
	}
}