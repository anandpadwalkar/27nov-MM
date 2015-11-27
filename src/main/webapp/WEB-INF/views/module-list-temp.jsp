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

	<jsp:include page="header.jsp" />
	<div id="container" class="fixed-header">
		<div id="content">
			<div class="layout-container">
				<div class="">
					<!--=== Page Header ===-->
					<jsp:include page="page-header.jsp" />
					<!-- /Page Header -->

					<div
						class="second-column one-child-container relative padding-top-75px">
						<!--=== Navigation Vertical ===-->
						
						<!-- /Navigation Vertical -->

						<div id="my_documents_container" style="margin-left: 0px; margin: auto; width: 90%" class="column-one clearfix">
							<div class="grid box-filters">
								<div class="table-header">
									<form id="add-edit-module" class="form-inline ng-pristine ng-valid" method="post"
										action="./modules/add">
										<div class="row-fluid">
											<div class="span4">
												<div class="">
												<input type="hidden" name="moduleId" id="moduleId" value="0">
													
												</div>
											</div>

											<div class="span4">
												<div class="">
													<table width="100%" cellspacing="0" cellpadding="0">
														<tr>
															<td class="padding0 no_border" width="15%"><label
																class="float_left mrgall-01 font13"> <strong
																	class="">Module Name</strong>
															</label></td>
															<td class="no_border"><div
																	class="controls project-input-contr">
																	<input type="text"
																	class="controls project-input-contr"
																	name="moduleName" id="moduleName" >
																</div></td>
															
															
														</tr>
													</table>
												</div>
											</div>

											<div>
												<table width="10%" cellspacing="0" cellpadding="0">
													<tr>
														<td><label class="float_left mrgall-01 font13">
																<strong class="">Sr.No.</strong>
														</label></td>
														<td class="no_border"><div>
																<input type="text"
																	class="select2-input select2-default"
																	id="serialNumber" name="serialNumber" style="width: 100%;">
															</div></td>
														

														<td><label class="float_left mrgall-01 font13">
																<strong class="">Active</strong>
														</label></td>
														<td class="no_border"><div>
																<input type="checkbox" name="moduleStatus" id="active">
															</div></td>
													</tr>
													<tr>
														<td class="no_border" style="position:relative;left: 15px">
															<button type="submit" id="submit-btn"
																class="btn btn-xl btn-success button-submit font13"
																>Add</button>
														</td>
														<td class="no_border" style="position:relative;left: 25px">
															<button type="button"
																class="btn btn-xl  font13"
																data-dismiss="modal" id="cancel-btn">Cancel</button>
														</td>
													</tr>
												</table>
											</div>
										</div>

									</form>
								</div>
								<div class="grid-title">
									<div class="pull-left">Module List</div>
									<!--<div class="pull-right">
                        <a href="assets-create-reminders-form.html" target="_blank" class="btn btn-xl btn-success button-submit font13">
                          <i class="icon-plus-sign margin_right5"></i>Add
                        </a>
                    </div>-->
									<div class="clear"></div>
								</div>
								<div class="grid-content">
									<div id="DataTables_Table_0_wrapper"
										class="dataTables_wrapper form-inline" role="grid">
										<div class="row">
											<div class="dataTables_header clearfix">
												<div class="col-md-6">
													
											</div>
										</div>
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
														aria-label="Assign to Project: activate to sort column ascending">Operation</th>
												</tr>
											</thead>

											<tbody role="alert" aria-live="polite" aria-relevant="all">
											<c:set var="srno" value="1" />
											<c:forEach items="${allModuleList}" var="module">
												<tr class="odd">
													<td class=" "><a href="staff-user-profile.html">${srno}</a></td>
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

					</div>
					<!-- Modal dialog -->
					<div class="modal fade" id="assigntoProject">
					<form action="./modules/add" id="add-edit-module" method="post" >
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">×</button>
									<h4 class="modal-title">Module Master</h4>
								</div>
								<div class="modal-body">
									<div class="row">
										<div class="col-md-12">
											<div class="">
												<label>Note: </label> <span class="label label-danger">*
													Marked is Mandatory</span> </br>
												</br>
												<input type="hidden" name="id" id="moduleId">
												<div class="form-group">
													<label class="col-md-2 control-label-2">Module Name<span
														style="color: red">* </span>:
													</label>
													<div class="col-md-7">
														<div
															class="select2-container select2-container-multi col-md-6 select2 full-width-fix required"
															id="s2id_input20" style="width: 90%;">
															<ul class="select2-choices">
																<li class="select2-search-field"><input type="text"
																	autocomplete="off" autocorrect="off"
																	autocapitilize="off" spellcheck="false"
																	class="select2-input select2-default"
																	name="moduleName" id="moduleName" style="width: 100%;"></li>
															</ul>
															<div
																class="select2-drop select2-drop-multi select2-display-none">
																<ul class="select2-results">
																	<li class="select2-no-results">No matches found</li>
																</ul>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-2 control-label-2">Sr.No<span
														style="color: red">* </span> :
													</label>
													<div class="col-md-7">
														<div
															class="select2-container select2-container-multi col-md-6 select2 full-width-fix required"
															id="s2id_input20" style="width: 90%;">
															<ul class="select2-choices">
																<li class="select2-search-field"><input type="text"
																	autocomplete="off" autocorrect="off"
																	autocapitilize="off" spellcheck="false"
																	class="select2-input select2-default"
																	id="serialNUmber" style="width: 100%;"></li>
															</ul>
															<div
																class="select2-drop select2-drop-multi select2-display-none">
																<ul class="select2-results">
																	<li class="select2-no-results">No matches found</li>
																</ul>
															</div>
														</div>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-2 control-label-2">Active :</label>
													<div class="col-md-7">
														<input type="checkbox" name="moduleStatus" id="active">

													</div>
												</div>
											</div>
											<div class="modal-footer">
												<button type="button"
													class="btn btn-xl btn-cancel button-submit font13"
													data-dismiss="modal">Cancel</button>
												<!-- <a href="admin-projects.html"
													class="btn btn-xl btn-success button-submit font13 float_right">Submit</a> -->
													<button type="submit"
													class="btn btn-xl btn-success button-submit font13 float_right" id="add-edit-btn">Add</button>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						</form>
						<!-- /.modal-dialog -->
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