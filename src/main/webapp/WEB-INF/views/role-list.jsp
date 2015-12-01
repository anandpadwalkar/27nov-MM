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
	var dataTableOb = null;
	var text = '';
	
	$(document).ready(function() {

		jQuery.validator.addMethod('selectcheck', function (value) {
	        return (value != '0');
	    }, "");
		
		$("#add-edit-module").validate({

			// Specify the validation rules
			rules : {
				userTypeId:{
					selectcheck: true
				},
				roleName : {
					required : true
				},
				roleDescription : {
					required : true
				}
			},

			// Specify the validation error messages
			messages : {
				userTypeId:{
					selectcheck: "Please Select Role Type"
				},
				roleName : {
					required : "Please enter Role"//,
				},
				roleDescription : {
					required : "Please enter Role Description"
				}
			},

			submitHandler : function(form) {
				form.submit();
			}
		});

		$('#active').change(function() {
			if ($(this).is(":checked")) {

				$("#active").val(1);
			}

		});

		$("#add-edit-btn").click(function() {
			var moduleId = $("#moduleId").val();
			;
			var moduleName = $("#moduleName").val();

			ajaxParams.url = "./modules/exist";
			ajaxParams.data = {
				"moduleId" : moduleId,
				"moduleName" : moduleName
			};
			ajaxParams.formType = "module";

			if ($("form").valid()) {
				alert('valid...');
				var flag = ajaxRequest();
				if (flag == true) {
					$("#add-edit-module").submit();
				}

			}
		});

		
		
		$("#roleType").change(function() {
			var roleTypeId = $(this).val();
		//	alert(roleTypeId);
			if (roleTypeId != 0) {
				//$("#role-table-body").empty();
				//$('.dataTable').DataTable.destroy();
				$('.dataTable').dataTable().fnDestroy();
				/* if(dataTableOb != null)
					dataTableOb.destroy(); */
				$.ajax({
					async:false,
					url:"./roles/roles-by-type",
					type:"POST",
					data:{"roleTypeId":roleTypeId},
					success:function(response){
						//alert(JSON.stringify(response));
						var jsonOb  = JSON.parse(JSON.stringify(response));
						text = "";
						$.each(jsonOb, function(index, roleOb){
							text += "<tr class=\"odd\">"+
							"														<td class=\" \">"+roleOb.roleName+"</td>"+
							"														<td class=\" \">"+roleOb.roleDescription+"</td>";
							if(roleOb.active == 1){
								text += "															<td class=\" \">Active</td>";
							}else{
								text += "															<td class=\" \">Inactive</td>";
							}
							
							text += "														<td class=\" \">"+'<a href=\"#\"'+
							'data-toggle=\"modal\" data-original-title=\"Edit\"'+
							'data-placement=\"top\"'+
							'style=\"border-radius: 40px; padding: 4px 6px 2px;\"'+
							'class=\"btn btn-xl btn-success button-submit font13 bs-tooltip\"'+ 
'														onclick=\"updateModule('+roleOb.roleId+',\''+roleOb.roleName+'\',\''+roleOb.roleDescription+'\','+roleOb.active+','+roleOb.userTypeId+')\">'+
'															<i class=\"icon-cog font14\"></i>'+
'													</a>'+"</td>"+
							"													</tr>";
						});
						
						$("#role-table-body").empty().html(text);
						applyDatatable();
						//alert(text);
					},
					error:function(){
						alert('error...');
					}
				});
				
				/* $('.dataTable').DataTable({
					"sPaginationType" : "bootstrap",
					"bPaginate" : true,
					"bDestroy" : true,
					//"bRetrieve" : false,
					"bProcessing" : true,
					"iDisplayLength":10,
					"bFilter" : true,
					"bServerSide" : true,
					"sAjaxSource" : "./roles/records?roleTypeId="+roleTypeId,
					"fnServerParams" : function(aoData) {
						aoData.push({});
					},

					"aoColumns" : [  {
						"mData" : "roleName"
					}, {
						"mData" : "roleDescription"
					}, {
						"mData" : function ( source, type, val ){
							return source.active == 1 ? "Active" : "Inactive"
						}
					},{
						"mData" : function ( source, type, val ){
							return '<a href=\"#\"'+
							'data-toggle=\"modal\" data-original-title=\"Edit\"'+
							'data-placement=\"top\"'+
							'style=\"border-radius: 40px; padding: 4px 6px 2px;\"'+
							'class=\"btn btn-xl btn-success button-submit font13 bs-tooltip\"'+ 
'														onclick=\"updateModule('+source.roleId+',\''+source.roleName+'\',\''+source.roleDescription+'\','+source.active+','+source.userTypeId+')\">'+
'															<i class=\"icon-cog font14\"></i>'+
'													</a>'
						}
					} ],
				}); */
				
				
				$("#roleName").val('');
				$("#roleDescription").val('');
				$("#add-edit-module").attr('action', './roles/add');
				$("#submit-btn").html('Add');
			}else{
				//$("#role-table-body").empty();
				//$('.dataTable').dataTable().fnDestroy();
				$("#role-table-body").empty().html('');
				//$('.dataTable').dataTable().fnDestroy();
				//if(dataTableOb != null)
					//dataTableOb.destroy();
				applyDatatable();
			}
		});
		/*dataTable = $('.dataTable').dataTable({
			
			"sPaginationType" : "bootstrap",
			"bPaginate" : true,
			"bDestroy" : true,
			//"bRetrieve" : false,
			"bProcessing" : true,
			"iDisplayLength":1,
			"bFilter" : true,
			"bServerSide" : true,
			"sAjaxSource" : "./roles/records",
			"fnServerParams" : function(aoData) {
				aoData.push({});
			},

			"aoColumns" : [ {
				"mData" : "fName"
			}, {
				"mData" : "lName"
			}, {
				"mData" : "responseMessage"
			}, {
				"mData" : "hasError"
			} ],
		});*/
		//alert('ready...');
		
		$.ajax({
			async:false,
			url:"./roles/role-type",
			type:"GET",
			success:function(response){
				//alert(JSON.stringify(response));
				var jsonString = JSON.stringify(response);
				var text = '<option selected value="0">Select Role Type</option>';
				$.each(JSON.parse(jsonString), function(index, roleType){
					text += '<option value="'+roleType.id+'">'+roleType.roleTypeName+'</option>';
				});
				$("#roleType").html(text);
			//	alert(text);
			},
			error:function(){
				alert('error...');
			}
		});
		
		
		$("#cancel-btn").click(function(){
				$("#roleType").val(0).change();
				$("#roleName").val('');
				$("#roleDescription").val('');
				$("#add-edit-module").attr('action', './roles/add');
				$("#submit-btn").html('Add');
		});
	});

	function updateModule(roleId, roleName, roleDescription, active, userTypeId) {
		//alert(roleId+" - "+roleName+" - "+roleDescription+" - "+active);
		// currentModuleId = moduleId
		console.log(currentModuleId);
		$("#roleType").val(userTypeId);
		$("#roleId").val(roleId);
		$("#roleName").val(roleName);
		$("#roleDescription").val(roleDescription);
		if (active == 1) {
			$("#active").prop("checked", true);
			$("#active").val(1);
		} else {
			$("#active").prop("checked", false);
			$("#active").val(0);
		} 
		$("#add-edit-module").attr('action', './roles/update');
		$("#submit-btn").html('Update');
	}
	
	function applyDatatable(){
		dataTableOb = $('.dataTable').DataTable({
			"sPaginationType" : "bootstrap",
			"bPaginate" : true,
			"bDestroy" : true,
			//"bRetrieve" : false,
			"iDisplayLength":10,
			"bFilter" : true
		});
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
						class="second-column one-child-container relative padding-top-75px">
						<!--=== Navigation Vertical ===-->

						<!-- /Navigation Vertical -->

						<!-- Modal dialog -->
						<!-- /Navigation Vertical -->
						<div id="my_documents_container"
							style="margin-left: 0px; margin: auto; width: 90%"
							class="column-one clearfix">
							 <div class="grid-header text">Role Master </div>
							<div class="grid box-filters">
								<div style="height: 75px" class="table-header">
									<form id="add-edit-module"
										class="form-inline ng-pristine ng-valid" method="post"
										action="./roles/add">
										<input type="hidden" name="roleId" id="roleId" value="0">
										<div class="row-fluid">
											<div class="span3">
												<div class="">
													<table width="100%" cellspacing="0" cellpadding="0">
														<tr>
															<td class="padding0 no_border" width="15%"><label
																class="float_left mrgall-01 font13"> <strong
																	class="">Role Type</strong>
															</label></td>
															<td class="no_border"><div
																	class="controls project-input-contr">
																	<select name="userTypeId" id="roleType"
																		class=" select2 full-width-fix required">
																	</select>
																</div></td>
														</tr>
													</table>
												</div>
											</div>

											<div class="span3">
												<table width="10%" cellspacing="0" cellpadding="0">
													<tr>
														<td><label class="float_left mrgall-01 font13">
																<strong class="">Role Name</strong>
														</label></td>
														<td class="no_border"><div>
																<input type="text" name="roleName" id="roleName">
															</div></td>
													</tr>
												</table>
											</div>
											<div class="span3">
												<table width="10%" cellspacing="0" cellpadding="0">
													<tr>
														<td><label class="float_left mrgall-01 font13">
																<strong class="">Description</strong>
														</label></td>
														<td class="no_border"><div>
																<input type="text" name="roleDescription"
																	id="roleDescription" />
															</div></td>
													</tr>
												</table>
											</div>
											<div class="span3">
												<table width="10%" cellspacing="0" cellpadding="0">
													<tr>
														<td><label class="float_left mrgall-01 font13">
																<strong class="">Active</strong>
														</label></td>
														<td class="no_border"><div>
																<input type="checkbox" name="active" id="active" />
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
								<div class="pull-left">Role List</div>
								<div class="clear"></div>
							</div>
							<div class="grid-content">
								<div id="DataTables_Table_0_wrapper"
									class="dataTables_wrapper form-inline" role="grid">
									<div class="row">
										<div class="dataTables_header clearfix">
											<div class="col-md-6"></div>
										</div> </div>
										<table
											class="table table-striped table-bordered table-hover table-checkable table-responsive datatable dataTable"
											id="DataTables_Table_0"
											aria-describedby="DataTables_Table_0_info">
											<thead>
												<tr role="row">
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
														aria-label="Email ID: activate to sort column ascending">Role
														Name</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
														aria-label="Job Category: activate to sort column ascending">Role
														Description</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
														aria-label="Department: activate to sort column ascending">Status</th>
													<th class="sorting" role="columnheader" tabindex="0"
														aria-controls="DataTables_Table_0" rowspan="1" colspan="1"
														aria-label="Assign to Project: activate to sort column ascending">Edit</th>
												</tr>
											</thead>

											<tbody role="alert" aria-live="polite" aria-relevant="all" id="role-table-body">
												
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