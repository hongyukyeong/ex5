<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<h1>MEMBER MYPAGE</h1>


<p><img src ="${pageContext.request.contextPath}/resources/upload/${member.filename}"></p>
<table>
<tr>
<td>ID : </td> <td>${member.id}</td>
</tr>
<tr>
<td>NAME : </td> <td>${member.name}</td>
</tr>
<tr>
<td>AGE : </td> <td>${member.age}</td>
</tr>
<tr>
<td>GRADE : </td> <td>${member.grade}</td>
</tr>


<!-- 학생 정보 -->
<c:if test="${member.grade eq 'student'}">
<tr>
<td>PHONE :</td> <td>${member.phone}</td>
</tr>
<tr>
<td>TID :</td> <td>${member.tid}</td>
</tr>
</c:if>


<!-- 선생님 정보 -->
<c:if test="${member.grade eq 'teacher'}">
<tr>
<td>SUBJECT :</td> <td>${member.subject}</td>
</tr>
<tr>
<td>HIREDATE :</td> <td>${member.hiredate}</td>
</tr>
</c:if>


</table>



</body>
</html>