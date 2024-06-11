package com.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class SessionTemplate {
	
	// mybatis 를 이용해서 DB 에 접근하는 클래스를 제공해주는 매소드
	public static SqlSession getSession() {
		// SqlSession 객체를 생성하는 방법
		// 1. SqlSessionFactoryBuilder 클래스를 생성 -> default 생성자
		//	- build()메소드를 이용 -> SqlSessionFactory 클래스를 가져옴
		//	- build()메소드의 매개변수로 mybatis-config.xml파일 전달
		// 2. SqlSessionFactory 클래스가 제공하는 openSession()메소드 이용
		//	- openSession()매개변수로 true/false -> autoCommit 에 대한 설정	
		SqlSession session = null;
		String fileName = "mybatis-config.xml";
		
		try(InputStream is = Resources.getResourceAsStream(fileName);){
			SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
			SqlSessionFactory sf = sfb.build(is);
			session = sf.openSession(false);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
