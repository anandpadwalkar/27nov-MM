<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Module Details | RF-Campus</title>

<!--=== CSS ===-->

 <jsp:include page="script.jsp" /> 



<script type="text/javascript"
	src="<c:url value="/resources/common/ajax-call.js"/>"></script>

<script type="text/javascript">
var currentModuleId;
	
	$(document).ready(function(){
		
	    $("#add-edit-module").validate({
	    
	        // Specify the validation rules
	        rules: {
	            moduleName: {
	            	required:true//,
	            	//remote: './modules/exist'
	            },
	            serialNumber: {
	            	required:true//,
	            }
	        },
	        
	        // Specify the validation error messages
	        messages: {
	        	moduleName: {
	        		required : "Please enter Module name"//,
	        	},
	        	serialNumber: {
	        		required : "Please enter Serial Number"//,
	        	}
	        },
	        
	        submitHandler: function(form) {
	            form.submit();
	        }
	    });
	    
	    
		$('#active').change(function() {
	        if($(this).is(":checked")) {
	            
	        	$("#active").val(1);
	        }
	                
	    });
		
		$("#add-edit-btn").click(function(){
			var moduleId = $("#moduleId").val();;
			var moduleName = $("#moduleName").val();
			
			ajaxParams.url = "./modules/exist";
			ajaxParams.data = {"moduleId":moduleId, "moduleName":moduleName};
			ajaxParams.formType = "module";
			
			if($("form").valid()){
				alert('valid...');
				var flag = ajaxRequest();
				if(flag == true){
					$("#add-edit-module").submit();
				}
				
				
			}
		});
		
		$("#cancel-btn").click(function(){
			$("#moduleId").val(0);
			$("#moduleName").val('');
			$("#serialNumber").val('');
			$("#active").prop("checked", true);
			$("#active").val(1);
			$("#submit-btn").html('Add');
			$("#add-edit-module").attr("action", "./modules/add");
		});
	});
	
	function updateModule(moduleId, moduleName, active, serialNumber){
			//alert(moduleId +" - "+ moduleName +" - "+ active);
			currentModuleId = moduleId
			console.log(currentModuleId);
			$("#moduleId").val(moduleId);
			$("#moduleName").val(moduleName);
			$("#serialNumber").val(serialNumber);
			if(active == 1){
				$("#active").prop("checked", true);
				$("#active").val(1);
			}else{
				$("#active").prop("checked", false);
				$("#active").val(0);
			} 
			
			$("#submit-btn").html('Update');
			$("#add-edit-module").attr("action", "./modules/update");
		}
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

					<div
						class="second-column one-child-container relative ">
						<!--=== Navigation Vertical ===-->

						<!-- /Navigation Vertical -->

						<!-- Modal dialog -->
						<!-- /Navigation Vertical -->
						<div id="my_documents_container"
							style=""
							class="doc-container column-one clearfix">
							 <div class="grid-header text">Module Master </div>
							<div class="grid box-filters">
								<div  class="table-header">
									<form id="add-edit-module" class="form-inline ng-pristine ng-valid" method="post"
										action="./modules/add">
										<input type="hidden" name="moduleId" id="moduleId" value="0">
										<div class="row-fluid">
											<div class="span4">
												<table width="10%" cellspacing="0" cellpadding="0">
													<tr>
														<td><label class="float_left mrgall-01 font13">
																<strong class="">Module Name</strong>
														</label></td>
														<td class="no_border"><div>
																<input type="text"
																	class="controls project-input-contr"
																	name="moduleName" id="moduleName" >
															</div></td>
													</tr>
												</table>
											</div>
											<div class="span4">
												<table width="10%" cellspacing="0" cellpadding="0">
													<tr>
														<td><label class="float_left mrgall-01 font13">
																<strong class="">Serial.No.</strong>
														</label></td>
														<td class="no_border"><div>
																<input type="text"
																	class="controls project-input-contr"
																	id="serialNumber" name="serialNumber" >
															</div></td>
													</tr>
												</table>
											</div>
											<div class="span4">
												<table width="10%" cellspacing="0" cellpadding="0">
													<tr>
														<td><label class="float_left mrgall-01 font13">
																<strong class="">Active</strong>
														</label></td>
														<td class="no_border"><div>
																<input type="checkbox" name="moduleStatus" id="active">
															</div></td>

														<td class="no_border"
															style="position: relative; left: 15px">
															<button type="submit" id="submit-btn"
															data-original-title="Add"
														data-placement="top"
																class="btn btn-xl btn-success button-submit font13 bs-tooltip">Add</button>
														</td>

														<td class="no_border"
															style="position: relative; left: 25px">
															<button type="button"
															data-original-title="Cancel"
														data-placement="top"
																class="btn btn-xl btn-default button-submit font13 bs-tooltip"
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
								<div class="pull-left">Module List</div>
								<div class="clear"></div>
							</div>
							<div class="grid-content">
								<div id="DataTables_Table_0_wrapper"
									class="dataTables_wrapper form-inline" role="grid">
									<div class="row">
										<div class="dataTables_header clearfix">
											<div class="col-md-6"></div>
										</div></div>
										<table
											class="table table-striped table-bordered table-hover table-checkable table-responsive datatable dataTable"
											id="DataTables_Table_0"
											aria-describedby="DataTables_Table_0_info">
											<thead>
												<tr role="row">
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
														aria-label="Email ID: activate to sort column ascending">Sr
														No</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
														aria-label="Job Category: activate to sort column ascending">Module
														Name</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
														aria-label="Department: activate to sort column ascending">Status</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
														aria-label="Assign to Project: activate to sort column ascending">Action</th>
												</tr>
											</thead>

											<tbody role="alert" aria-live="polite" aria-relevant="all" id="role-table-body">
												<c:set var="srno" value="1" />
											<c:forEach items="${allModuleList}" var="module">
												<tr class="odd">
													<td class=" "><a href="staff-user-profile.html">${module.serialNumber}</a></td>
													<td class=" ">${module.moduleName}</td>
													<c:if test="${module.moduleStatus eq 1}">
														<td class=" ">Active</td>
													</c:if>
													<c:if test="${module.moduleStatus eq 0}">
														<td class=" ">Inactive</td>
													</c:if>
													<td class=" "><a href="#"
														 data-original-title="Edit"
														data-placement="top"
														style="border-radius: 40px; padding: 4px 6px 2px;"
														class="btn btn-xl btn-success button-submit font13 bs-tooltip" 
														onclick="updateModule(${module.moduleId}, '${module.moduleName}', ${module.moduleStatus}, ${module.serialNumber})">
															<i class="icon-cog font14"></i>
													</a></td>
												</tr>
												<c:set var="srno" value="${srno+1}"/>
											</c:forEach>
											</tbody>
										</table>

									</div>
									<div class="info-popup">
										<table width="100%" cellpadding="0" cellspacing="0">
											<tbody>
												<tr>

												</tr>
											</tbody>
										</table>

									</div>
								</div>
							</div>
						</div>

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
	</div>
</body>

</html>