 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<!--=== CSS ===-->

	<!-- Bootstrap -->
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

	<!-- jQuery UI -->
	<!--<link href="plugins/jquery-ui/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />-->
	<!--[if lt IE 9]>
		<link rel="stylesheet" type="text/css" href="plugins/jquery-ui/jquery.ui.1.10.2.ie.css"/>
	<![endif]-->

	<!-- Theme -->
		<link href="${pageContext.request.contextPath}/resources/assets/css/errors-success.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/login.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/my_hor_menu.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/main.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/plugins.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/responsive.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/icons.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/fontawesome/font-awesome.min.css">
	<!--[if IE 7]>
		<link rel="stylesheet" href="assets/css/fontawesome/font-awesome-ie7.min.css">
	<![endif]-->

	<!--[if IE 8]>
		<link href="assets/css/ie8.css" rel="stylesheet" type="text/css" />
	<![endif]-->
	<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,600,700" rel="stylesheet" type="text/css">

	<!--=== JavaScript ===-->
		<link href="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/css/select2.min.css" rel="stylesheet" />
		<!-- <script src="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script> -->

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/libs/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/jquery-ui/jquery-ui-1.10.2.custom.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/libs/lodash.compat.min.js"></script>

	<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
		<script src="assets/js/libs/html5shiv.js"></script>
	<![endif]-->

	<!-- Smartphone Touch Events -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/touchpunch/jquery.ui.touch-punch.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/event.swipe/jquery.event.move.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/event.swipe/jquery.event.swipe.js"></script>

	<!-- General -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/libs/breakpoints.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/respond/respond.min.js"></script><!-- Polyfill for min/max-width CSS3 Media Queries (only for IE8) -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/cookie/jquery.cookie.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/slimscroll/jquery.slimscroll.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/slimscroll/jquery.slimscroll.horizontal.min.js"></script>

	<!-- Page specific plugins -->
	<!-- Charts -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/daterangepicker/moment.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/daterangepicker/daterangepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/blockui/jquery.blockUI.min.js"></script>

	<!-- Forms -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/uniform/jquery.uniform.min.js"></script><!-- Styled radio and checkboxes -->
	<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/select2/select2.min.js"> --%></script><!-- Styled select boxes -->

	<!-- DataTables -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/datatables/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/datatables/DT_bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/datatables/responsive/datatables.responsive.js"></script><!-- optional -->

	<!-- App -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/app.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/plugins.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/plugins.form-components.js"></script>
	<script>
	$(document).ready(function(){
		"use strict";

		App.init(); // Init layout and core plugins
		Plugins.init(); // Init all plugins
		FormComponents.init(); // Init all form-specific plugins
	});
	</script>


	<!-- Demo JS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/assets/js/custom.js"></script>
	<style type="text/css">.jqstooltip { position: absolute;left: 0px;top: 0px;visibility: hidden;background: rgb(0, 0, 0) transparent;background-color: rgba(0,0,0,0.6);filter:progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000);-ms-filter: "progid:DXImageTransform.Microsoft.gradient(startColorstr=#99000000, endColorstr=#99000000)";color: white;font: 10px arial, san serif;text-align: left;white-space: nowrap;padding: 5px;border: 1px solid white;z-index: 10000;}.jqsfield { color: white;font: 10px arial, san serif;text-align: left;}</style>
	</head>
	
	<body class="breakpoint-1200" >
	<img id="test" src="${pageContext.request.contextPath}/resources/bootstrap/img/minebg.jpg"  style=";position:absolute;width:100%;height:100%"> 
           
<!-- Header -->

<!-- <div class="header navbar navbar-fixed-top" role="banner">
    Top Navigation Bar
    <div class="container">
        Logo
         <a class="navbar-brand" href="index.html">
            <img src="resources/bootstrap/img/master_logo.png" alt="logo" />
        
        </a>
	</div>
</div>  -->

<!-- Header -->
   
   <form class="form-vertical login-form" action="<c:url value='j_spring_security_check' />" method="post" style="position:relative;width:100%;height:100%;z-index:200">
 
 	<!-- Left Spacing -->
   <div class="col-sm-3 col-sm-3 col-sm-offset-0" ></div>
   
   <!-- Login div -->
  <div class="col-sm-6 col-sm-6 col-sm-offset-0 my-login-div" style="text-align: center;">
         <h2 class="login_title" style="padding: 20px"></h2>
         
          <p class="form-group userId_box">
            <!-- <label class="user_id_pwd" for="emailId">Login ID</label> -->
        
            <i class="icon-user input-group"></i>
            <input type="text" value="" class="txtField" name="username" placeholder="xyz@gmail.com" maxlength="60" autofocus data-rule-required="true" data-msg-required="Please enter your username.">
          </p>
          
          <p class="form-group userId_box">
         <!--    <label class="user_id_pwd" for="pwd">Password</label> -->
               
           <i class="icon-lock input-group "></i>
           
            <input type="password" class="txtField" value="" name="password" maxlength="60" placeholder="******" data-rule-required="true" data-msg-required="Please enter your password.">
         <br><span class="clearfloat"></span>
           </p>
           
            <p class="userId_box chkbox" style="margin-top: -21px; margin-left: 8%">
              <a data-no-turbolink="" href="#" style="top: 8px; position: relative; "  class="lightBlue_link fgt_pwd">Forgot Password?</a>
              <span class="rcContainer">
              	<input type="checkbox" class="rc remember_me" name="remember_me" id="remember_me">
                <label class="keep_logged_in" for="remember_me">Remember me</label>
              </span>
              <span class="clearfloat"></span>
            </p>
            
            <p class="signin_btn">
              <button type="submit" style="position:relative;margin:auto; width: 78%" class=" actionbutton loginBtn large success btn-embossed" >
              <span class="">Login</span>
              </button>
            </p>
            
    </div>
          <!--right spacing  -->
           <div class="col-sm-3 col-sm-3 col-sm-offset-0">
           </div>
  
</form>

 
</body>
</html> 
