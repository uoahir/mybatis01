package com.mybatis.model.service;

import static com.mybatis.common.SessionTemplate.getSession;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dao.StudentDao;
import com.mybatis.model.dto.Student;

public class StudentService {
	private StudentDao dao = new StudentDao();
	
	public int insertStudent() {
		SqlSession session = getSession();
		int result =  dao.insertStudent(session);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	
	}
	
	public int insertStudent(String name) {
		SqlSession session = getSession();
		int result =  dao.insertStudentByName(session,name);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	
	}
	
	public int insertStudent(Student s) {
		SqlSession session = getSession();
		int result = dao.insertStudent(session,s);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int updateStudent(Student s) {
		SqlSession session = getSession();
		int result = dao.updateStudent(session,s);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	
	public int deleteStudent(int studentNo) {
		SqlSession session = getSession();
		int result = dao.deleteStudent(session,studentNo);
		if(result>0) session.commit();
		else session.rollback();
		session.close();
		return result;
	}
	public int selectStudentCount() {
		SqlSession session= getSession();
		int count = dao.selectStudentCount(session);
		session.close();
		return count;
	}
	
	public List<Student> selectStudentAll(){
		SqlSession session = getSession();
		List<Student> students = dao.selectStudentAll(session);
		session.close();
		return students;
	}
	
	public List<Student> searchByName(String name){
		SqlSession session = getSession();
		List<Student> students = dao.searchByName(session, name);
		session.close();
		return students;
	}
	
	public Map<String,Object> selectStudentByNameMap(int no){
		SqlSession session = getSession();
		Map<String,Object> result = dao.selectStudentByNameMap(session,no);
		session.close();
		return result;
	}
	
	public List<Map<String,Object>> studentAllMap(){
		SqlSession session = getSession();
		List<Map<String,Object>> result=dao.studentAllMap(session);
		session.close();
		return result;
	}
	
	public List<Student> selectStudentPage(Map<String,Integer> page){
		SqlSession session = getSession();
		List<Student> result = dao.selectStudentPage(session,page);
		session.close();
		return result;
	}
}
