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

<jsp:include page="script.jsp" />
	
	<script type="text/javascript">
		function setUniversity(uid, code, name, active)
		{
			$("#universityId").val(uid);
			$("#code").val(code);
			$("#uname").val(name);
			if(active == 1){
				$("#active").prop("checked", true);
				$("#active").val(1);
			}else{
				$("#active").prop("checked", false);
				$("#active").val(0);
			} 
			$("#add-update-university").attr('action', './university/update');
			$("#submit-btn").html('Update');
			
		}
    </script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			
			$('#active').change(function() {
		        if($(this).is(":checked")) {
		            
		        	$("#active").val(1);
		        }
		                
		    });
			
			$("#cancel-btn").click(function(){
				$("#universityId").val(0);
				$("#code").val('');
				$("#uname").val('');
				$("#add-update-university").attr('action', './university/add');
				$("#active").prop("checked", true);
				$("#active").val(1);
				$("#submit-btn").html('Add');
				
			});
			
			$("#add-update-university").validate({
		        // Specify the validation rules
		        rules: {
		        	universityCode: {
		            	required:true//,
		            },
		            universityName: {
		            	required:true//,
		            }
		        },
		        
		        // Specify the validation error messages
		        messages: {
		        	universityCode: {
		        		required : "Please Enter University Code"//,
		        	},
		        	universityName: {
		        		required : "Please Enter University Name"//,
		            }
		        },
		        
		        submitHandler: function(form) {
		            form.submit();
		        }
		    });
			
		});
		
		
	</script>
	</head>
	
	<body class="breakpoint-1200" style="height: 609px;">
<!-- Header -->
<jsp:include page="header.jsp" />
<!-- /.header -->

<div id="container" class="fixed-header">
      <div id="content">
    <div class="layout-container">
          <div class=""> 
        <!--=== Page Header ===-->
        <jsp:include page="page-header.jsp" />
        <!-- /Page Header -->
        
        <div class="second-column one-child-container relative "> 
              <!--=== Navigation Vertical ===-->

              <!-- /Navigation Vertical -->
          <div id="my_documents_container" style="" class="doc-container column-one clearfix ">
          
          
           <div class="grid-header text">University Master </div>
            <div class="grid box-filters">
                  <div class="table-header">
                <form class="form-inline ng-pristine ng-valid" method="post" action="./university/add" id="add-update-university">
                <input type="hidden" name="id" id="universityId" value="0">
                      <div class="row-fluid">
                      <div class="span4">
                        <table  width="10%" cellspacing="0" cellpadding="0">
                              <tr>
                            <td ><label class="float_left mrgall-01 font13"> <strong class="">University/Board Code</strong> </label></td>
                            <td class="no_border"><div >
                               <input type="text" name="universityCode" id="code" />
                              </div></td></tr></table>
                        </div>
                   <div class="span4">
                        <table  width="10%" cellspacing="0" cellpadding="0">
                              <tr>
                            <td ><label class="float_left mrgall-01 font13"> <strong class="">University/Board Name</strong> </label></td>
                            <td class="no_border"><div >
                               <input type="text" name="universityName" id="uname"/>
                              </div></td></tr></table>
                        </div>
                          <div class="span4">     
                             <table  width="10%" cellspacing="0" cellpadding="0">
                              <tr>  
                              <td ><label class="float_left mrgall-01 font13"> <strong class="">Active</strong> </label></td>
                            <td class="no_border"><div >
                               <input type="checkbox" name="active" value="1" id="active"/>
                              </div></td>
                             

                          <td class="no_border" style="position:relative;left: 20px">
															<button type="submit" id="submit-btn"
																class="btn btn-xl btn-success button-submit font13"
																>Add</button>
														</td>
														
														<td class="no_border" style="position:relative;left: 27px">
															<button type="button"
																class="btn btn-xl btn-cancel button-submit font13"
																id="cancel-btn">Cancel</button>
														</td>
                          
                         </tr>
                            </table>
                         </div>   
                             
                      </div>
                       </form>
                    </div> 
                    
                   
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
                </div>
                          </div></div>
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
                          <td class=" "><c:out value="${university.universityCode}"/></td>
                          <td class=" "><c:out value="${university.universityName}"/></td>
                          <c:choose  >
                             <c:when test="${university.active eq 1}">
                                 <td class=" ">active</td>
                             </c:when>
                             <c:otherwise>
                                  <td class=" ">inactive</td>
                             </c:otherwise>
                          </c:choose>
                          <td class=" ">
                          	<a href="#" data-toggle="modal" data-original-title="Add to Project" data-placement="top" style="border-radius:40px; padding:4px 6px 2px;" class="btn btn-xl btn-success button-submit font13 bs-tooltip" onclick="setUniversity(${university.id}, '${university.universityCode}', '${university.universityName}', ${university.active})">
                            	<i class="icon-cog font14" ></i>
                            </a>
                          </td>
                        </tr>
                        </c:forEach>
                       </tbody>
                      </table>
                       </div>
               
        <!-- Modal dialog -->

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

