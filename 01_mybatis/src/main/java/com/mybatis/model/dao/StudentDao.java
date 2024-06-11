package com.mybatis.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.model.dto.Student;

public class StudentDao {
	
	// dao 에서 sql 문을 실행할 때 mybatis에서 제공하는 SqlSession 의 메소드를 이용
	// insert, update, delete,selectOne,
	public int insertStudent(SqlSession session) {
		// statement 파라미터에 전달하는 값 -> mapper, sql 문 정보
		// "mappernamespace속성값.sql태그의 id 값"
		return session.insert("student.insertStudent");
	}
	
	public int insertStudentByName(SqlSession session,String name) {
		// statement 파라미터에 전달하는 값 -> mapper, sql 문 정보
		// "mappernamespace속성값.sql태그의 id 값"
		return session.insert("student.insertStudentByName",name);
	}
	
	public int insertStudent(SqlSession session, Student s) {
		return session.insert("student.insertStudentTest",s);
	}
	
	public int updateStudent(SqlSession session, Student s) {
		return session.update("student.updateStudent",s);
	}
	public int deleteStudent(SqlSession session, int s) {
		return session.delete("student.deleteStudent",s);
	}
	
	//SelectOne : 결과(row 수)가 0-2개
	//selectList: 결과가 다수일 경우 상용하ㄴ
	public int selectStudentCount(SqlSession session) {
		return session.selectOne("student.selectStudentCount");
	}
	
	public List<Student> selectStudentAll(SqlSession session){
		return session.selectList("student.selectStudentAll");
	}
	
	public List<Student> searchByName(SqlSession session, String name){
		return session.selectList("student.searchstudentbyname", name);
	}
	
	public Map<String,Object> selectStudentByNameMap(SqlSession session, int no){
		return session.selectOne("student.selectStudentByNameMap", no);
	}
	
	public List<Map<String,Object>> studentAllMap(SqlSession session){
		return session.selectList("student.studentAllMap");
	}
	
	public List<Student> selectStudentPage(SqlSession session, Map<String,Integer> page){
		// mybatis 가 제공하는 페이징처리 객체를 이용해서 페이징 처리할 수 있다 !
		// RowBounds 클래스 이용 
		// 매개변수 있는 생성자를 이용해서 생성 후 selectList 메소드의 매개변수로 전달
		// 생성자에 2개의 매개변수를 전달해야 함.
		// 1 : row 의 시작위치 지정하는 값 (offset) -> (cPage-1)*numPerpage
		// 2 : 범위(간격) -> numPerpage
		RowBounds rb = new RowBounds((page.get("cPage")-1)*page.get("numPerpage"),page.get("numPerpage"));
		return session.selectList("student.selectStudentPage",null,rb);
		
	}
}
