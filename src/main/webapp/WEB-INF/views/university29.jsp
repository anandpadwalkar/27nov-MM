<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<title>University Details | Master software</title>

	<!--=== CSS ===-->
<title>Enable Hover State on Bootstrap 3 Table Rows</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>





	<!-- Bootstrap -->
	<link href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">

	<!-- jQuery UI -->
	<!--<link href="plugins/jquery-ui/jquery-ui-1.10.2.custom.css" rel="stylesheet" type="text/css" />-->
	<!--[if lt IE 9]>
		<link rel="stylesheet" type="text/css" href="plugins/jquery-ui/jquery.ui.1.10.2.ie.css"/>
	<![endif]-->

	<!-- Theme -->
	<link href="${pageContext.request.contextPath}/resources/assets/css/main.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/plugins.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/responsive.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/icons.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/datatables.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/select2.min.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/select2.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/datatables_bootstrap.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath}/resources/assets/css/my_hor_menu.css" rel="stylesheet" type="text/css">
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
<script src="//cdnjs.cloudflare.com/ajax/libs/select2/4.0.0/js/select2.min.js"></script>

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
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/plugins/select2/select2.min.js"></script><!-- Styled select boxes -->

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
	
	<script type="text/javascript">
		function setUniversity(uid, code, name,active)
		{
			$("#code").val(code);
			$("#uname").val(name);
			$("#uid").val(uid);
			$("#active").val(active);
			if(active==1)
			{
				$("#active").prop("checked","checked");
			}	
			else
				{
				$("#active").removeAttr("checked");
				}
			
			$("#submit").html("Update");
			$("#universityForm").attr("action","./university/update")
			
		}
		
		
    </script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$(".module-link").click(function(){
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
								menuText +='                            <li><a href=\"#\">'+submenu.menuName+'</a></li>';
								
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
	</script>
	</head>
	
	<body class="breakpoint-1200" style="height: 609px;">
<!-- Header -->
<header class="header navbar navbar-fixed-top" role="banner"> 
      <!-- Top Navigation Bar -->
      <div class="container"> 
    <!-- Only visible on smartphones, menu toggle -->
    <ul class="nav navbar-nav">
          <li class="nav-toggle"><a href="javascript:void(0);" title=""><i class="icon-reorder"></i></a></li>
        </ul>
    
    <!-- Logo --> 
    <a class="navbar-brand" href="index.html"> <img src="resources/bootstrap/img/master_logo.png" alt="logo"> <!-- <strong>RITENOW</strong>Infra --> </a> 
    <!-- /logo --> 
    
    <!-- Sidebar Toggler --> 
    <!--<a href="#" class="toggle-sidebar bs-tooltip" data-placement="bottom" data-original-title="Toggle navigation">
				<i class="icon-reorder"></i>
			</a>--> 
    <!-- /Sidebar Toggler --> 
    
    <!-- Top Left Menu -->
    <ul class="nav navbar-nav navbar-left">
          <!-- Project Switcher Button -->
          <li class="dropdown"> <a href="#" class="project-switcher-btn dropdown-toggle"> <i class="icon-reorder fontsize_24"></i> </a> </li>
        </ul>
    <!-- /Top Left Menu --> 
    
    <!-- Top Right Menu -->
    <ul class="nav navbar-nav navbar-right">
      <li> 
      	<a href="index.html" class="bs-tooltip" data-original-title="Admin Dashboard" data-placement="bottom"> 
          <i class="icon-home fontsize_24"></i> 
        </a> 
      </li>
      <!-- User Login Dropdown -->
      <li class="dropdown user"> 
      	<a href="#" class="dropdown-toggle" data-toggle="dropdown">
          <i class="icon-male"></i> 
          <span class="username">Admin</span> 
          <i class="icon-caret-down small"></i> 
        </a>
        <ul class="dropdown-menu">
          
           <li class="divider"></li>
            <li><a href="<c:url value="logout"/>"><i class="icon-off "></i> Sign Out</a></li>
        </ul>
      </li>
      <!-- /user login dropdown -->
    </ul>
    <!-- /Top Right Menu --> 
  </div>
      <!-- /top navigation bar --> 
      
      <!--=== Project Switcher ===-->
      <div id="project-switcher" class="container project-switcher" style="position: relative; margin-top: 0px; display: none;"> 
    <!--<div id="scrollbar">
				<div class="handle"></div>
			</div>-->
   <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: 100%; height: auto;"><div id="frame" style="overflow: hidden; width: 100%; height: auto;">
      <ul class="project-list" style="width: 799px;">
    <c:forEach items="${ModuleList}" var="module">
        <li> <a href="#" class="module-link" for="${module.id}"> <span class="image nav-dashboard"><i></i></span> <span class="title">${module.moduleName}</span> </a> </li>
    </c:forEach>  
      </ul>
        </div>
      <!-- /#project-switcher --> 
    </header>
<!-- /.header -->

<div id="container" class="fixed-header">
      <div id="content">
    <div class="layout-container">
          <div class=""> 
        <!--=== Page Header ===-->
        <div class="page-header">
        
<!--         <div class="container"> -->
 
<div id="navbar">    
  <nav class="navbar navbar-default navbar-static-top" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            <!--   <a class="navbar-brand" href="#">Brand</a> -->
            </div>
            
            <div class="collapse navbar-collapse" id="navbar-collapse-1">
               
            </div><!-- /.navbar-collapse -->
        </nav>
</div>


    <!-- </div> -->
        
          
          
          
          
          
          
          
          
          
          
          
          
          
          
            </div>
        <!-- /Page Header -->
        
        <div class="second-column one-child-container relative padding-top-75px"> 
              <!--=== Navigation Vertical ===-->

              <!-- /Navigation Vertical -->
          <div id="my_documents_container" class="column-one clearfix">
            <div class="grid box-filters">
                  <div class="table-header">
                <form class="form-inline ng-pristine ng-valid" method="post" action="./university/add"  id="universityForm">
                      <div class="row-fluid">
                    
                    
                      <div class="span4">
                        <table  width="10%" cellspacing="0" cellpadding="0">
                              <tr>
                               
                            <td ><label class="float_left mrgall-01 font13"> <strong class="">University/Board Code</strong> </label></td>
                            <td class="no_border"><div >
                               <input type="hidden" name="uid" id="uid"/>
                               <input type="text" name="univCode" id="code" />
                              </div></td></tr></table>
                        </div>
                   <div class="span4">
                        <table  width="10%" cellspacing="0" cellpadding="0">
                              <tr>
                            <td ><label class="float_left mrgall-01 font13"> <strong class="">University/Board Name</strong> </label></td>
                            <td class="no_border"><div >
                               <input type="text" name="univName" id="uname"/>
                              </div></td></tr></table>
                        </div>
                          <div class="span4">     
                             <table  width="10%" cellspacing="0" cellpadding="0">
                              <tr>  
                              <td ><label class="float_left mrgall-01 font13"> <strong class="">Active</strong> </label></td>
                            <td class="no_border"><div >
                               <input type="checkbox" name="active" value="1" id="active" />
                              </div></td>
                             

                          <td class="no_border" style="position:relative;left: 20px">
															<button type="submit" 
																class="btn btn-xl btn-success button-submit font13"
																id="submit">Submit Query</button>
														</td>
														
														<td class="no_border" style="position:relative;left: 27px">
															<button type="button"
																class="btn btn-xl btn-success button-submit font13"
																data-dismiss="modal">Reset</button>
														</td>
                          
                         </tr>
                            </table>
                         </div>   
                             
                      </div>
                    </div> 
                    
                    </form>
              </div>
                  <div class="grid-title">
                <div class="pull-left">University List</div>
                <!--<div class="pull-right">
                        <a href="assets-create-reminders-form.html" target="_blank" class="btn btn-xl btn-success button-submit font13">
                          <i class="icon-plus-sign margin_right5"></i>Add
                        </a>
                    </div>-->
                <div class="clear"></div>
              </div>
                  <div class="grid-content">
                <div id="DataTables_Table_0_wrapper" class="dataTables_wrapper form-inline" role="grid">
                <div class="row">
                <div class="dataTables_header clearfix">
                <div class="col-md-6">
                <!-- <div id="DataTables_Table_0_length" class="dataTables_length">
                <label><div class="select2-container" id="s2id_autogen8" style="width: 75px;">
                <a href="javascript:void(0)" onclick="return false;" class="select2-choice select3-choice select4-choice select5-choice" tabindex="-1">  
                 <span class="select2-chosen">5</span>
                 <abbr class="select2-search-choice-close"></abbr>  
                  <span class="select2-arrow">
                  <b></b>
                  </span>
                  </a>
                  <input class="select2-focusser select2-offscreen" type="text" id="s2id_autogen9">
                  <div class="select2-drop select2-display-none">  
                   <div class="select2-search select2-search-hidden select2-offscreen">  
                        <input type="text" autocomplete="off" autocorrect="off" autocapitalize="off" spellcheck="false" class="select2-input"> 
                          </div>   
                          <ul class="select2-results">  
                           </ul></div></div>
                           <select size="1" name="DataTables_Table_0_length" aria-controls="DataTables_Table_0" class="select2-offscreen" tabindex="-1">
                           <option value="5" selected="selected">5
                           </option>
                           <option value="10">10</option>
                           <option value="25">25</option>
                           <option value="50">50</option>
                           <option value="-1">All</option>
                           </select> records per page
                           </label></div> --></div>
                          <!--  <div class="col-md-6">
                           <div class="dataTables_filter" id="DataTables_Table_0_filter">
                           <label>
                           <div class="input-group">
                           <span class="input-group-addon">
                           <i class="icon-search"></i>
                           </span><input type="text" aria-controls="DataTables_Table_0" class="form-control">
                           </div>
                           </label></div></div> --></div></div>
                           <table class="table table-striped table-bordered table-hover table-checkable table-responsive datatable dataTable" id="DataTables_Table_0" aria-describedby="DataTables_Table_0_info">
                  <thead>
                    <tr role="row">
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="PHOTO: activate to sort column ascending">University / Board Code</th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="ID: activate to sort column ascending">University / Board Name</th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="First Name: activate to sort column ascending">Status</th>
                    <th class="sorting" role="columnheader" tabindex="0" aria-controls="DataTables_Table_0" rowspan="1" colspan="1" aria-label="First Name: activate to sort column ascending">Action</th>   </tr> 
                  </thead>
                      
                    <tbody role="alert" aria-live="polite" aria-relevant="all">
                    <c:forEach items="${universityList}" var="university">  
                        <tr class="odd">
                          <td class=" "><c:out value="${university.univCode}"/></td>
                          <td class=" "><c:out value="${university.univName}"/></td>
                          <c:choose  >
                             <c:when test="${university.active eq 1}">
                                 <td class=" ">active</td>
                             </c:when>
                             <c:otherwise>
                                  <td class=" ">inactive</td>
                             </c:otherwise>
                          </c:choose>
                          <td class=" ">
                          	<a href="#assigntoProject" data-toggle="modal" data-original-title="Add to Project" data-placement="top" style="border-radius:40px; padding:4px 6px 2px;" class="btn btn-xl btn-success button-submit font13 bs-tooltip" onclick="setUniversity(${university.uid}, '${university.univCode}', '${university.univName}',${university.active})">
                            	<i class="icon-cog font14" ></i>
                            </a>
                          </td>
                        </tr>
                        </c:forEach>
                       </tbody>
                      </table>
                       <!--  <div class="row">
                        <div class="dataTables_footer clearfix"
                        ><div class="col-md-6">
                        <div class="dataTables_info" id="DataTables_Table_0_info">Showing 1 to 4 of 4 entries
                        </div></div>
                        <div class="col-md-6">
                        <div class="dataTables_paginate paging_bootstrap">
                        <ul class="pagination"><li class="prev disabled">
                        <a href="#">? Previous</a></li><li class="active">
                        <a href="#">1</a></li><li class="next disabled"><a href="#">Next ? 
                        </a></li></ul></div></div></div></div> --></div>
               
        <!-- Modal dialog -->
<!-- <div class="modal fade" id="assigntoProject">
                <div class="modal-dialog">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                      <h4 class="modal-title">University</h4>
                    </div>
                    <div class="modal-body">
                      <div class="row">
                        <div class="col-md-12">
                          <div class="">
                          <label>Note: </label>
                            <span class="label label-danger">* Marked is Mandatory</span>
                    </br></br>
                            <div class="form-group">
                              <label class="col-md-2 control-label-2">University/Board Code<span style="color: red">* </span>:</label>
                              <div class="col-md-7">
                                <div class="select2-container select2-container-multi col-md-6 select2 full-width-fix required" id="s2id_input20" style="width: 90%;"><ul class="select2-choices">
                                   <li class="select2-search-field">   
                                    <input type="text" autocomplete="off" autocorrect="off" autocapitilize="off" spellcheck="false" class="select2-input select2-default" id="s2id_autogen7" style="width: 100%;" placeholder="Enter University Code ">
                                      </li></ul>
                                      <div class="select2-drop select2-drop-multi select2-display-none"> 
                                        <ul class="select2-results">   <li class="select2-no-results">No matches found
                                        </li></ul></div></div>
                              </div>
                            </div>
                            <div class="form-group">
                              <label class="col-md-2 control-label-2">University/Board Name<span style="color: red">* </span> :</label>
                              <div class="col-md-7">
                                 <div class="select2-container select2-container-multi col-md-6 select2 full-width-fix required" id="s2id_input20" style="width: 90%;"><ul class="select2-choices">
                                   <li class="select2-search-field">   
                                    <input type="text" autocomplete="off" autocorrect="off" autocapitilize="off" spellcheck="false" class="select2-input select2-default" id="s2id_autogen7" style="width: 100%;" placeholder="Enter University Name ">
                                      </li></ul>
                                      <div class="select2-drop select2-drop-multi select2-display-none"> 
                                        <ul class="select2-results">   <li class="select2-no-results">No matches found
                                        </li></ul></div></div>
                              </div>
                            </div>  
                             <div class="form-group">
                              <label class="col-md-2 control-label-2">Active :</label>
                              <div class="col-md-7">
                                <input type="checkbox" name="chkbox">
                              
                              </div>
                            </div>
                          </div>
                          <div class="modal-footer">
                            <button type="button" class="btn btn-xl btn-success button-submit font13" data-dismiss="modal">Cancel</button>
                            <a href="admin-projects.html" class="btn btn-xl btn-success button-submit font13 float_right">Submit</a>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  /.modal-content 
                </div>
                /.modal-dialog 
              </div> -->
                  <!-- /.modal --> 
      </div>
          
          <!--=== Page Content ===--> 
          <!--=== Managed Tables ===--> 
          
          <!--=== Horizontal Scrolling ===--> 
          
          <!-- /Horizontal Scrolling --> 
          <!-- /Page Content --> 
        </div>
    <!-- /.container --> 
    
  </div>
    </div>

</body>

