<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mybatis 기본활용</title>
</head>
<body>
	<h2>mybatis접속하기</h2>
	<h3><a href="${path }/mybatistest.do">mybatis 접속하기</a></h3>
	<h3>
		<a href="${path }/insertstudent.do">학생등록</a>
	</h3>
	<form action="${path }/insertstudentbyname.do" method="POST">
		<input type="text" name="name">
		<input type="submit" value="저장">
	</form>
	<form action="${path }/insertstudenttest.do" method="POST">
		<input type="text" name="name">
		<input type="text" name="phone">
		<input type="text" name="email">
		<input type="text" name="address">
		<input type="submit" value="등록">
	</form>
	<!-- phone email address 만 수정 -->
	<h3>회원정보 수정	</h3>
	<form action="${path }/updatestudent.do" method="POST">
		<input type="text" name="no" placeholder="학생번호">
		<input type="text" name="phone" placeholder="전화번호">
		<input type="text" name="email" placeholder="이메일">
		<input type="text" name="address" placeholder="주소">
		<input type="submit" value="수정">
	</form>
	<h3>회원정보 삭제	</h3>
	<form action="${path }/deletestudent.do" method="POST">
		<input type="text" name="no" placeholder="학생번호">
		<input type="submit" value="삭제">
	</form>
	
	<h3>DB에 저장된 데이터 조회하기</h3>
	<p>SELECT문을 실행시키기 -> resultSet을 가져옴 -> DTO로 매핑(mybatis 알아서 해줌)</p>
	<h3>학생 수 조회하기</h3>
	<h4>
		<a href="${path }/student/studentCount.do">전체학생수조회</a>
	</h4>
	<h3>1번학생조회하기</h3>
	<h4></h4>
	
	<h3>학생번호 입력받아 조회하기</h3>
	<form action="${path }/student/studentsearch.do">
		<input type="text" name="no" placeholder="학생번호">
		<input type="submit" value="조회">
	</form>
	
	<h3>전체학생 조회하기</h3>
	<h4>
		<a href="${path }/student/studentall.do">전체학생조회</a>
	</h4>
	<h3>이름포함으로조회하기</h3>
	<h4>
		<form action="${path }/student/searchbyname.do">
			<input type="text" name="name" placeholder="이름으로조회">
			<input type="submit" value="조회">
		</form>
	</h4>
	
	<h3>DTO를 선언하지 않고 DB정보 가져오기</h3>
	<p>Map을 이용해서 데이터를 가져올 수 있다.</p>
	<h4>
		<a href="${path }/student/studentbynamemap.do?no=1">
			1번 학생 조회 -map-
		</a>
	</h4>
		<h4>
		<a href="${path }/student/studentallmap">
			전체학생 조회 -map-
		</a>
	</h4>
	</h4>
		<h4>
		<a href="${path }/student/studentpage.do">
			페이징처리
		</a>
	</h4>
</body>
</html>