<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.mybatis.model.dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생정보	</title>
</head>
<body>
	<!-- <c:if test "${student!=null }">
		
	</c:if> -->
	<table>
	<tbody>
	<c:if test="${not empty students }">
		<c:forEach var="student" items="${students }">
			<tr>
				<td><c:out value="${student.studentNo }"/></td>
				<td><c:out value="${student.studentName }"/></td>
				<td><c:out value="${student.studentTel }"/></td>
				<td><c:out value="${student.studentEmail }"/></td>
				<td><c:out value="${student.studentAddress }"/></td>
				<td><fmt:formatDate value="${student.reg_date }" 
												dateStyle="full"/></td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${not empty mapStudents }">
		<tr>
			<td>${mapStudents.STUDENT_NO }</td>
			<td>${mapStudents.STUDENT_NAME }</td>
			<td>${mapStudents.STUDENT_TEL }</td>
			<td>${mapStudents.STUDENT_EMAIL }</td>
			<td>${mapStudents.STUDENT_ADDR }</td>
			<td>${mapStudents.REG_DATE }</td>
		</tr>
	</c:if>
	</tbody>
	</table>

</body>
</html>