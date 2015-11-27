<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title> -->


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> -->
	<script type="text/javascript"
	src="<c:url value="/resources/assets/js/jquery-1.11.0.min.js"/>"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>





<!-- Bootstrap -->
<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css">

<!-- jQuery UI -->
<!--<link href="plugins/jquery-ui/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />-->
<!--[if lt IE 9]>
		<link rel="stylesheet" type="text/css" href="plugins/jquery-ui/jquery.ui.1.10.2.ie.css"/>
	<![endif]-->

<!-- Theme -->
<link href="<c:url value="/resources/assets/css/main.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/assets/css/plugins.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/assets/css/responsive.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/assets/css/icons.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/assets/css/datatables.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/assets/css/select2.min.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/assets/css/select2.css"/>"
	rel="stylesheet" type="text/css">
<link
	href="<c:url value="/resources/assets/css/datatables_bootstrap.css"/>"
	rel="stylesheet" type="text/css">
<link href="<c:url value="/resources/assets/css/my_hor_menu.css"/>"
	rel="stylesheet" type="text/css">
<link rel="stylesheet"
	href="<c:url value="/resources/assets/css/fontawesome/font-awesome.min.css"/>">
<!--[if IE 7]>
		<link rel="stylesheet" href="assets/css/fontawesome/font-awesome-ie7.min.css">
	<![endif]-->

<!--[if IE 8]>
		<link href="assets/css/ie8.css" rel="stylesheet" type="text/css" />
	<![endif]-->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:400,600,700"
	rel="stylesheet" type="text/css">

<!--=== JavaScript ===-->
<link
	href="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css"
	rel="stylesheet" />
<!-- <script
	src="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script> -->

<%-- <script type="text/javascript"
	src="<c:url value="/resources/assets/js/libs/jquery-1.10.2.min.js"/>"></script> --%>
<script type="text/javascript"
	src="<c:url value="/resources/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/assets/js/libs/lodash.compat.min.js"/>"></script>

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
		<script src="assets/js/libs/html5shiv.js"></script>
	<![endif]-->

<!-- Smartphone Touch Events -->
<script type="text/javascript"
	src="<c:url value="/resources/plugins/touchpunch/jquery.ui.touch-punch.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/plugins/event.swipe/jquery.event.move.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/plugins/event.swipe/jquery.event.swipe.js"/>"></script>

<!-- General -->
<script type="text/javascript"
	src="<c:url value="/resources/assets/js/libs/breakpoints.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/plugins/respond/respond.min.js"/>"></script>
<!-- Polyfill for min/max-width CSS3 Media Queries (only for IE8) -->
<script type="text/javascript"
	src="<c:url value="/resources/plugins/cookie/jquery.cookie.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/plugins/slimscroll/jquery.slimscroll.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/plugins/slimscroll/jquery.slimscroll.horizontal.min.js"/>"></script>

<!-- Page specific plugins -->
<!-- Charts -->
<script type="text/javascript"
	src="<c:url value="/resources/plugins/sparkline/jquery.sparkline.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/plugins/daterangepicker/moment.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/plugins/daterangepicker/daterangepicker.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/plugins/blockui/jquery.blockUI.min.js"/>"></script>

<!-- Forms -->
<script type="text/javascript"
	src="<c:url value="/resources/plugins/uniform/jquery.uniform.min.js"/>"></script>
<!-- Styled radio and checkboxes -->
<%-- <script type="text/javascript"
	src="<c:url value="/resources/plugins/select2/select2.min.js"/>"></script> --%>
<!-- Styled select boxes -->

<!-- DataTables -->
<script type="text/javascript"
	src="<c:url value="/resources/plugins/datatables/jquery.dataTables.min.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/plugins/datatables/DT_bootstrap.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/plugins/datatables/responsive/datatables.responsive.js"/>"></script>
<!-- optional -->

<!-- App -->
 <script type="text/javascript"
	src="<c:url value="/resources/assets/js/app.js"/>"></script> 
 <script type="text/javascript"
	src="<c:url value="/resources/assets/js/plugins.js"/>"></script> 
<script type="text/javascript"
	src="<c:url value="/resources/assets/js/plugins.form-components.js"/>"></script>
<script>
	$(document).ready(function() {
		"use strict";

		App.init(); // Init layout and core plugins
		Plugins.init(); // Init all plugins
		FormComponents.init(); // Init all form-specific plugins
	});
</script> 



<!-- Demo JS -->
 <script type="text/javascript"
	src="<c:url value="/resources/assets/js/custom.js"/>"></script> 
	
	<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
	
<style type="text/css">
.jqstooltip {
	position: absolute;
	left: 0px;
	top: 0px;
	visibility: hidden;
	background: rgb(0, 0, 0) transparent;
	background-color: rgba(0, 0, 0, 0.6);
	filter: progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000,
		endColorstr=#99000000);
	-ms-filter:
		"progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";
	color: white;
	font: 10px arial, san serif;
	text-align: left;
	white-space: nowrap;
	padding: 5px;
	border: 1px solid white;
	z-index: 10000;
}

.jqsfield {
	color: white;
	font: 10px arial, san serif;
	text-align: left;
}
</style>

<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
		$(document).ready(function(){
			$(".module-link").click(function(e){
				e.preventDefault();
				//alert($(this).attr('for'));
				$("#navbar-collapse-1").empty();
				$.ajax({
					async: false,
					url:"./master1",
					data:{"id" : $(this).attr('for')},
					type:"GET",
					success:function(response){
						//alert(JSON.stringify(response));
						
						var menuList = JSON.parse(JSON.stringify(response));
					//	alert(menuList);
						var menuText = '';
						$.each(menuList, function(index, menu){
							menuText += '<ul class=\"nav navbar-nav\">'+
							'                    <li class=\"dropdown\">'+
							'                      <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">'+menu.menuName+'<b class=\"caret\"></b></a> '+
							'                        <ul class=\"dropdown-menu\">';
							$.each(menu.submenu, function(index, submenu){
								menuText +='                            <li><a href=\"'+contextPath + '/' +submenu.menuLink+'\">'+submenu.menuName+'</a></li>';
								
							});
							menuText += '                        </ul>'; 
							menuText += '                    </li>'+
							'                    '+
							'                </ul>';
						});
					
						$("#navbar-collapse-1").html(menuText);
						$(".project-switcher-btn").click();
						
					},
					error:function(){
						alert('Error...');
					}
					
				});
				
				//e.preventDefault();
			});
			
		});
		
		function userLogout() {
			document.getElementById("logoutForm").submit();
		}
	</script>
<!-- </head>


</head>
<body>


</body>
</html> -->