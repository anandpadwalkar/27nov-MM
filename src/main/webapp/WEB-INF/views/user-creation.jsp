<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>User Creation | RFCampus</title>

<jsp:include page="script.jsp" />

<script type="text/javascript">
	function getUserInformation(userId) {
		$.ajax({
			async : false,
			url : "./user-creation/" + userId,
			type : "POST",
			success : function(response) {
				//setter for college info
				var jsonOb = JSON.parse(JSON.stringify(response));
				//alert(jsonOb.collegeLogo);
				$("[type='radio']").removeAttr("checked");
				
				$("#userId").val(jsonOb.userId);
				$("#name").val(jsonOb.name);
				$("#username").val(jsonOb.username);
				$("#password").val(jsonOb.password);
				$("#password1").val(jsonOb.password);
				$("#oldUserPhoto").val(jsonOb.userPhoto);//
				 $("#Image2").attr(
						'src',
						'./resources/uploads/authorization/user/'
								+ jsonOb.userPhoto); 
				$("#counter").val(jsonOb.counter);
				$("#mobileNumber").val(jsonOb.mobileNumber);
				$("#emailid").val(jsonOb.emailid);

				if (jsonOb.setWorkingDate == 1) {
					$("#setWorkingDate").prop("checked", "checked");
					$("#setWorkingDate").val(1);
				} else {
					$("#setWorkingDate").removeAttr("checked");
					$("#setWorkingDate").val(0);
				}

				if (jsonOb.active == 1) {
					$("#active").prop("checked", "checked");
					$("#active").val(1);
				} else {
					$("#active").removeAttr("checked");
					$("#active").val(0);
				}

				if(jsonOb.roleIds != null){
					$.each(jsonOb.roleIds.split(","), function(index, roleId) {
						$("#role-" + roleId).prop("checked", "checked");
					});
				}
				

				$("form").valid();
				$("#user-add-edit-form").prop("action", "./user-creation/update");
				$("#add-update-btn").val('Update');
				$("#close-dialog-box").click();
			},
			error : function() {
				alert('error...');
			}
		});
	}

	function showImage() {
		var src = document.getElementById("collegeLogo");
		var target = document.getElementById("Image2");

		var fr = new FileReader();
		// when image is loaded, set the src of the image where you want to display it
		fr.onload = function(e) {
			target.src = this.result;
		};
		src.addEventListener("change", function() {
			// fill fr with image data    
			fr.readAsDataURL(src.files[0]);
		});
	}

	function resetModelDialogBox(){
		$("#searchByUserName").prop("checked", "checked");
		$("#searchText").val('');
		$("#table-body").empty();
	}
	
	$(document).ready(function() {
		
		 $("#search-btn").click(function() {
			 $("#table-body").empty();
			 
			 var searchBy = $('input[name=searchBy]:checked').val();
			 var searchText = $("#searchText").val();
			 
			 //alert(searchBy  + " - " + searchText );
			 $.ajax({
					async : false,
					url : "./user-creation/search",
					type : "POST",
					data:{"searchBy" : searchBy, "searchText": searchText},
					success : function(response) {
						//setter for college info
						var jsonOb = JSON.parse(JSON.stringify(response));
						var text = '';
						
						$.each(response, function(index, user){
							text += "<tr class=\"customers\">"+
							"<td style=\"width: 20%;\"><a "+
							"id=\"ContentPlaceHolder1_lsvSearchResult_lnkRecpt_0\" "+
							"href=\"javascript:getUserInformation("+user.userId+")\">"+user.userId+"</a>"+
							"</td>"+
							"<td style=\"width: 40%;\"><a "+
							"id=\"ContentPlaceHolder1_lsvSearchResult_lnkName_0\""+
							"href=\"javascript:getUserInformation("+user.userId+")\">"+user.name+"</a>"+
							"</td>"+
							"<td style=\"width: 40%;\"><a "+
							"id=\"ContentPlaceHolder1_lsvSearchResult_lnkId_0\""+
							"href=\"javascript:getUserInformation("+user.userId+")\">"+user.username+"</a>"+
							"</td>"+
							"</tr>";
						});
						
						$("#table-body").empty().html(text);
						//alert(jsonOb.collegeLogo);
						/* $("#collegeId").val(jsonOb.collegeId);
						$("#collegeName").val(jsonOb.collegeName);
						$("#collegeCode").val(jsonOb.collegeCode); */
						
						//alert(JSON.stringify(response));
					},
					error : function() {
						alert('error...');
					}
				});
		}); 
		
		 $("#reset-dialog").click(function(){
			 $("#table-body").empty();
		 });
		 
		$("#reset").click(function() {
		//	alert('click');
			$("#Image2").attr(
					'src',
					'./resources/No_image_available.svg');
			$("#user-add-edit-form").prop("action", "./user-creation/add");
			$("#add-update-btn").val('Add');

		});

		$(".setWorkingDate_n_statuc").change(function() {
			if ($(this).is(":checked")) {

				$(this).val(1);
			}
		});

		jQuery.validator.addMethod('selectcheck', function(value) {
			return (value == $("#password").val());
		}, "");

		$("#user-add-edit-form").validate({
			// Specify the validation rules
			rules : {
				name : {
					required : true
				//,
				},
				username : {
					required : true,
					nowhitespace:true
				//,
				},
				/* password : {
					required : true
				//,
				},
				password1 : {
					required : true,
					selectcheck:true
				//,
				}, */
				emailid : {
					required : true,
					email: true
				//,
				},
				mobileNumber : {
					required : false,
					number: true,
					maxlength:10
				},
				counter : {
					required : false,
					number: true
				}
			},

			// Specify the validation error messages
			messages : {
				name : {
					required : "Please Enter Name"
				},
				username : {
					required : "Please User Name",
					nowhitespace:"User Name should not have any spaces"
				},
				/* password : {
					required : "Please Enter Password"//,
				},
				password1 : {
					required : "Please Re Enter Password",
					selectcheck:"Entered Password Dosent Match"
				}, */
				mobileNumber : {
					number: "Please Enter Valid Mobile Number",
					maxlength:"Please Enter 10 Digit Mobile Number"
				}
			},

			submitHandler : function(form) {
				form.submit();
			}
		});

	});
</script>
<body class="breakpoint-1200" style="height: 609px;">
	<!-- Header -->
	<jsp:include page="header.jsp" />
	<!-- /.header -->

	<div id="container" class="fixed-header">

		<div id="content">
			<div class="layout-container">
				<!--=== Page Header ===-->
				<jsp:include page="page-header.jsp" />
				<!-- /Page Header -->
				
				
				<form action="./user-creation/add" method="post"
					id="user-add-edit-form" enctype="multipart/form-data">
					<input type="hidden" name="userId" id="userId" value="0">
					<input type="hidden" name="oldUserPhoto" id="oldUserPhoto" value="0">
					<div
						class="second-column one-child-container relative ">


						<div id="my_documents_container"
							style="margin-left: 0px; margin: auto; width: 90%"
							class="column-one clearfixs">
							<div class="">
							
<div class="grid-header text">User Master</div>

								<div class="row">
									<div class="col-md-12">

										<!-- Model Dialog Box -->
										<div id="myModal" class="modal fade"
											style="position: absolute; top: 0px">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<button type="button" class="close" data-dismiss="modal"
															aria-hidden="true">&times;</button>
														<h4 class="modal-title">Select User</h4>

													</div>
													<div class="modal-body" style="padding: 0px 0px 0px">
														<div class="col-sm-12">
															<div class="form-horizontal">
																<div class="form-group">
																	<div class="col-sm-4">Search By</div>
																	<div class="col-sm-8">
																		<table id="ContentPlaceHolder1_rblSearchBy"
																			onclick="RblChange();">
																			<tbody>
																				<tr>
																					<td><input
																						id="searchByUserName"
																						type="radio"
																						name="searchBy"
																						value="1" checked="checked"><label
																						for="ContentPlaceHolder1_rblSearchBy_0">USER
																							NAME</label></td>
																					<td><input
																						id="searchByUserId"
																						type="radio"
																						name="searchBy"
																						value="2"><label
																						for="ContentPlaceHolder1_rblSearchBy_1">USERID</label></td>
																					<td><input
																						id="searchByLoginId"
																						type="radio"
																						name="searchBy"
																						value="3"><label
																						for="ContentPlaceHolder1_rblSearchBy_2">LOGINID</label></td>
																				</tr>
																			</tbody>
																		</table>
																	</div>
																</div>
																<div class="form-group">
																	<div class="col-sm-4">Search Text</div>
																	<div class="col-sm-8">
																		<input name="ctl00$ContentPlaceHolder1$txtNameSearch"
																			type="text" id="searchText"
																			class="form-control"
																			style="width: 100%;">
																	</div>
																</div>
																<div class="form-group">
																	<div class="col-sm-12 text-center Height35px">
																		<input type="button"
																			name="search"
																			value="Search"
																			id="search-btn"
																			class="btn btn-default"> <input type="button"
																			name="cancel"
																			value="Cancel"
																			id="reset-dialog"
																			class="btn btn-default">
																	</div>
																</div>
																<div class="form-group">
																	<div class="col-sm-12">

																		<div class="table-responsive TabContainer">
																			<table class="table table-hover table-striped">
																				<thead>
																					<tr class="customers">
																						<th style="width: 20%;">USER ID</th>
																						<th style="width: 40%;">USER NAME</th>
																						<th style="width: 40%;">LOGIN ID</th>
																					</tr>
																				</thead>
																			</table>

																			<div class=""
																				style="position: relative; overflow: auto; width: auto; height: 150px;">
																				<div class="TabScroll"
																					style="overflow: auto; width: auto; height: 150px;">
																					<table class="table table-hover table-striped">
																						<tbody id="table-body">


																							


																							

																						</tbody>
																					</table>

																				</div>
																				<div class="slimScrollBar"
																					style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 93.361px; background: rgb(0, 0, 0);"></div>
																				<div class="slimScrollRail"
																					style="width: 7px; height: 100%; position: absolute; top: 0px; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; display: none; background: rgb(51, 51, 51);"></div>
																			</div>
																		</div>

																	</div>
																</div>
															</div>
														</div>
													</div>
													<div class="modal-footer" style="margin: 0">
														<button type="button" class="btn btn-default"
															data-dismiss="modal" id="close-dialog-box">Close</button>
														<!-- <button type="button" class="btn btn-primary">Save
															changes</button> -->
													</div>
												</div>
												<!-- /.modal-content -->
											</div>
											<!-- /.modal-dialog -->
										</div>
										<!-- /.modal-dialog -->

										<fieldset class="scheduler-border">

											<div class="form-group">
												<div class="col-sm-12 ">
													Note <b>:</b> <span style="color: #FF0000">* Marked
														Is Mandatory !</span>
												</div>

											</div>
											<div class="col-md-8">
												<div class="form-horizontal">

													<div class="form-group">
														<div class="col-sm-4">
															User Name <span style="color: #FF0000; font-weight: bold">*</span>
														</div>
														<div class="col-sm-8">
															<div class="input-group">
																<input name="name" type="text" id="name" tabindex="2"
																	class="form-control" placeholder="Search USER">
																<span id="name" style="display: none;"></span> <span
																	class="input-group-addon"><i><a
																		href="#myModal" data-backdrop="false"
																		data-toggle="modal" onclick="resetModelDialogBox()"> <span
																			class="glyphicon glyphicon-search"></span>
																	</a></i></span>
															</div>


														</div>

													</div>
													<div class="form-group">
														<div class="col-sm-4">User Photo</div>
														<div class="col-sm-4">
															<input type="file" name="userImage" id="userImage"
																title="Please Select Photo">

														</div>
														
													</div>
													<div class="form-group">
														<div class="col-sm-4"></div>
														<div class="col-sm-8">

															<img id="Image2"
																src="./resources/No_image_available.svg"
																style="height: 75px; width: 75px;">
														</div>
													</div>

													<div class="form-group">
														<div class="col-sm-4">
															User Login <span
																style="color: #FF0000; font-weight: bold">*</span>
														</div>
														<div class="col-sm-6">

															<input name="username" type="text" id="username"
																class="form-control" placeholder="Enter User Login">


														</div>
														<div class="col-sm-2">
															<span id="ContentPlaceHolder1_lblAssias">@RSML.com</span>
															<span id="ContentPlaceHolder1_RequiredFieldValidator4"
																style="display: none;"></span>
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-4">
															Password <span style="color: #FF0000; font-weight: bold">*</span>
														</div>
														<div class="col-sm-8">
															<input name="password" type="password" maxlength="10" disabled="disabled"
																id="password" class="form-control"
																placeholder="Enter Password For New User"> <span
																id="ContentPlaceHolder1_rfPassword"
																style="display: none;"></span>
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-4">
															Confirm Password <span
																style="color: #FF0000; font-weight: bold">*</span>
														</div>
														<div class="col-sm-8">
															<input name="password1" type="password" maxlength="10" disabled="disabled"
																id="password1" class="form-control"
																placeholder="Confirm Password For New User">
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-4">Counter No.</div>
														<div class="col-sm-4">
															<input name="counter" type="text" maxlength="2"
																id="counter" class="form-control"
																placeholder="Enter Counter No"> <span
																id="ContentPlaceHolder1_rgSocity" style="display: none;"></span>
															<span id="ContentPlaceHolder1_rgCollege"
																style="display: none;"></span>
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-4">Change Working Date</div>
														<div class="col-sm-8">
															<input id="setWorkingDate" type="checkbox"
																name="setWorkingDate" class="setWorkingDate_n_statuc" value="0"><label
																for="ContentPlaceHolder1_chkWorkingDate" >Check
																If Allow</label>
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-4">Status</div>
														<div class="col-sm-8">
															<input id="active" type="checkbox" name="active" class="setWorkingDate_n_statuc" value="0"><label
																for="ContentPlaceHolder1_chkStatus" >Check If
																Active</label>
														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-4">Mobile No.</div>
														<div class="col-sm-4">
															<input name="mobileNumber" type="text" maxlength="15"
																id="mobileNumber" class="form-control"
																placeholder="Enter Mobile No">

														</div>
													</div>
													<div class="form-group">
														<div class="col-sm-4">
															Email ID <span style="color: #FF0000; font-weight: bold">*</span>
														</div>
														<div class="col-sm-4">
															<input name="emailid" type="text" maxlength="100"
																id="emailid" class="form-control"
																placeholder="Enter Email ID"> <span
																id="ContentPlaceHolder1_RequiredFieldValidator15"
																style="display: none;"></span> <span
																id="ContentPlaceHolder1_revEmail" style="display: none;"></span>

														</div>
													</div>
													<div class="help-block"></div>



												</div>
											</div>

											<div class="col-md-4"
												style="border: 1px solid black; padding: 10px">
												<div class="form-horizontal">

													<fieldset class="scheduler-border">
														<legend class="scheduler-border"
															style="background: #318FE8; padding: 5px; color: white">Roles</legend>
														<div class="form-group">
															<div class="DocumentList">

																<div class="col-sm-8">
																	<table id="ContentPlaceHolder1_chkRole">
																		<tbody>
																			<c:forEach items="${roleList}" var="role">
																				<tr>
																					<td><input id="role-${role.roleId}"
																						type="checkbox" name="roleIds"
																						value="${role.roleId}"><label
																						for="ContentPlaceHolder1_chkRole_0">${role.roleName}</label></td>
																				</tr>
																			</c:forEach>
																		</tbody>
																	</table>
																	<span id="ContentPlaceHolder1_CustomValidator1"
																		style="display: none;"></span>
																</div>
															</div>
														</div>
													</fieldset>

												</div>

												<div class="form-group">
													<div class="col-sm-4"></div>
													<div class="col-sm-8">
														<input type="submit" name="" value="Add" 
															id="add-update-btn" tabindex="12" title="Click to Save"
															class="btn btn-xl btn-primary button-submit font13">
														<input type="reset"
															name="ctl00$ContentPlaceHolder1$btnCancel" value="Cancel"
															id="reset" tabindex="13" title="Click to Cancel"
															class="btn btn-default">
														<div id="ContentPlaceHolder1_valsummarySubmit"
															style="display: none;"></div>
													</div>
												</div>
											</div>
										</fieldset>
									</div>
								</div>

								<!--           jaskirtat code end here -->



							</div>
						</div>
					</div>
				</form>
				<!--=== Page Content ===-->
			</div>

		</div>
	</div>
	<!-- /.container -->
	<!-- /.container -->

</body>

