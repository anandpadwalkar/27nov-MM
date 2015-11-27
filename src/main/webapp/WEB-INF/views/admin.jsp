<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
	<%--  <h1>MenuList: ${menuList}</h1> --%> 
     <c:forEach items="${menus}" var="menu">
     	${menu.menuName}<br>
     </c:forEach>  
	<c:if test="${pageContext.request.userPrincipal.name != null}">
	   <h2>Welcome : ${pageContext.request.userPrincipal.name} 
           | <a href="<c:url value="/j_spring_security_logout" />" > Logout</a></h2>  
	</c:if>
	
	<sec:authorize ifAnyGranted="ROLE_USER" >
		<h4>Its User</h4>
	</sec:authorize>
	<sec:authorize ifAnyGranted="ROLE_ADMIN" >
		<h4>Its Admin</h4>
		
	</sec:authorize>
	
</body>
</html>