<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Menu Allocation</title>

<%-- <script type="text/javascript"
	src="<c:url value="/resources/assets/js/jquery-1.11.0.min.js"/>"></script> --%>
	<script type="text/javascript" src="http://checkboxtree.googlecode.com/svn/tags/checkboxtree-0.5.2/library/jquery-1.4.4.js"></script>
<script type="text/javascript"
	src="http://checkboxtree.googlecode.com/svn/tags/checkboxtree-0.5.2/library/jquery-ui-1.8.12.custom/js/jquery-ui-1.8.12.custom.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://checkboxtree.googlecode.com/svn/tags/checkboxtree-0.5.2/library/jquery-ui-1.8.12.custom/css/smoothness/jquery-ui-1.8.12.custom.css" />
<script type="text/javascript"
	src="<c:url value="/resources/plugins/checkboxtree/jquery.checkboxtree.js"/>"></script>
<link
	href="<c:url value="/resources/plugins/checkboxtree/jquery.checkboxtree.css"/>"
	rel="stylesheet" type="text/css">
<script type="text/javascript">
	$(document).ready(function() {
		$.ajax({
			async:false,
			url:"./menu-list",
			type:"GET",
			success:function(response){
				var jsonOb = JSON.parse(JSON.stringify(response));
				var text = "";
				$.each(response, function(index, object){
					text += "<li><input type=\"checkbox\"><label>"+object.moduleName+"</label>"+
					"			<ul>";
					$.each(object.mainMenu, function(index, mainMenu){
						text += "				<li><input type=\"checkbox\"><label>"+mainMenu.menuName+"</label>"+
						"					<ul>";
						$.each(mainMenu.subMenu, function(index, subMenu){
							text += "						<li><input type=\"checkbox\"><label>"+subMenu.menuName+"</label>";
						});
						
						text += "					</ul>"+
						"					</li>";
						
					});
					
					text += "			</ul>"+"			</li>";
				});
				
				$('#tree1').empty().html(text);
				$('#tree1').checkboxTree();
			},
			error:function(){
				
			}
		});
	});
</script>
</head>
<body>
	<h3></h3>

	<ul id="tree1">
		<li><input type="checkbox"><label>Node 1</label>
			<ul>
				<li><input type="checkbox"><label>Node 1.1</label>
					<ul>
						<li><input type="checkbox"><label>Node 1.1.1</label>
						<li><input type="checkbox"><label>Node 1.1.2</label>
					</ul>
					</li>
			</ul>
			</li>
	</ul>

</body>
</html>