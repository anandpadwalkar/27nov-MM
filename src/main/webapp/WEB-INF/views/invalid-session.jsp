<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Custom Login Page</title>
</head>
<body onload='document.f.j_username.focus();'>
	<h3>Invalid Session</h3>

	<ul>
		<c:forEach items="${menuList}" var="menu">
			<li><a href="/"><i class="fa fa-wrench fa-fw"></i>
					${menu.moduleName}<span class="fa arrow"></span></a>
				<ul class="nav nav-second-level">
					<c:forEach items="${menu.mainMenu}" var="mainMenu">
						<li><a href="${mainMenu.menuName}"><i
								class="glyphicon glyphicon-user"></i> ${mainMenu.menuName} <span
								class="fa arrow"></span></a>
							<ul class="nav nav-third-level">
								<c:forEach items="${mainMenu.subMenu}" var="subMenu">
									<li><a href="${subMenu.menuName}">${subMenu.menuName}</a></li>
								</c:forEach>
							</ul> <!-- /.nav-third-level --></li>
					</c:forEach>
				</ul> <!-- /.nav-second-level --></li>
		</c:forEach>
	</ul>

</body>
</html>