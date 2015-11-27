<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url value="/resources/assets/js/jquery-1.11.0.min.js"/>"></script>
	
	<script type="text/javascript">
	$(document).ready(function() {
		//alert('hi...');
		$("#check").click(function(){
			alert('hi...');
		});
	});
	</script>
</head>
<body>

<form action="./testing" method="post">
	<input type="checkbox" name="check"  value="1">
	<input type="button" id="check">
</form>
</body>
</html>