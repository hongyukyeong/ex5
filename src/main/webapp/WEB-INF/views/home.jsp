<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- session이 false로 되어있으면 안되기 때문에 지워준다. -->
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<c:if test="${member eq null}">
<a href="member/memberJoin">MemberJoin</a>
<a href="member/memberLogin">MemberLogin</a>
</c:if>

<c:if test="${member ne null}">
<a href="member/memberLogout">Logout</a>
<a href="member/memberPage">Mypage</a>
</c:if>


</body>
</html>
