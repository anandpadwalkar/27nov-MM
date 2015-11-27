<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>College Creation</title>

<jsp:include page="script.jsp" />

<script type="text/javascript">
	function getCollegeInformation(collegeId) {
		$.ajax({
			async : false,
			url : "./college/" + collegeId,
			type : "POST",
			success : function(response) {
				//setter for college info
				var jsonOb = JSON.parse(JSON.stringify(response));
				//alert(jsonOb.collegeLogo);
				$("#collegeId").val(jsonOb.collegeId);
				$("#collegeName").val(jsonOb.collegeName);
				$("#collegeCode").val(jsonOb.collegeCode);
				$("#Image2").attr('src','./resources/uploads/authorization/college/'+jsonOb.collegeLogo);
				$("#oldCollegeLogo").val(jsonOb.collegeLogo);
				$("#panNumber").val(jsonOb.panNumber);
				$("#tinNumber").val(jsonOb.tinNumber);
				$("#tanNumber").val(jsonOb.tanNumber);
				$("#principalName").val(jsonOb.principalName);
				$("#workOrderNumber").val(jsonOb.workOrderNumber);
				$("#workOrderDateString").val(jsonOb.workOrderDateString);
				$("#socialCollege").val(jsonOb.socialCollege);
				$("#active").val(jsonOb.active);
				$("#numberOfUsers").val(jsonOb.numberOfUsers);
				$("#societyId").val(jsonOb.societyId);
				$("#universityId").val(jsonOb.universityId);

				if (jsonOb.active == 1) {
					$("#active").prop("checked", "checked");
				} else {
					$("#active").removeAttr("checked");
				}

				if (jsonOb.socialCollege == 1) {
					$("#socialCollege").prop("checked", "checked");
				} else {
					$("#socialCollege").removeAttr("checked");
				}
				//setter for Address info
				$("#addId").val(jsonOb.addId);
				$("#address").val(jsonOb.address);
				$("#city").val(jsonOb.city);
				$("#pinCode").val(jsonOb.pinCode);
				$("#phone1").val(jsonOb.phone1);
				$("#phone2").val(jsonOb.phone2);
				$("#phone3").val(jsonOb.phone3);
				$("#fax1").val(jsonOb.fax1);
				$("#fax2").val(jsonOb.fax2);
				$("#email1").val(jsonOb.email1);
				$("#email2").val(jsonOb.email2);
				$("#website").val(jsonOb.website);
				$("#socId").val(jsonOb.socId);
				$("#collegeIdInAddress").val(jsonOb.collegeIdInAddress);

				$.each(jsonOb.modules, function(index, moduleId){
					$("#module-" + moduleId).prop("checked", "checked");
				});
				
				$("form").valid();
				$("#college-add-edit-form").prop("action", "./college/update");
				$("#add-update-btn").val('Update');
			},
			error : function() {
				alert('error...');
			}
		});
	}

	function showImage() {
		var src = document.getElementById("collegeLogo");
		var target = document.getElementById("Image2");
		
		  var fr=new FileReader();
		  // when image is loaded, set the src of the image where you want to display it
		  fr.onload = function(e) { target.src = this.result; };
		  src.addEventListener("change",function() {
		    // fill fr with image data    
		    fr.readAsDataURL(src.files[0]);
		  });
		}
	
	$(document).ready(function() {
		$("#reset").click(function() {
			$("#college-add-edit-form").prop("action", "./college/add");
			$("#add-update-btn").val('Add');

		});

		$(".active_n_socialcollege").change(function() {
			if ($(this).is(":checked")) {

				$(this).val(1);
			}
		});
	  
		 $("#college-add-edit-form").validate({
		        // Specify the validation rules
		        rules: {
		        	societyId: {
		            	required:true//,
		            },
		            universityId: {
		            	required:true//,
		            },
		            collegeName: {
		            	required:true//,
		            },
		            collegeCode: {
		            	required:true//,
		            },
		            address: {
		            	required:true//,
		            },
		            city: {
		            	required:true//,
		            },
		            pinCode: {
		            	required:true//,
		            },
		            phone1: {
		            	required:true//,
		            },
		            email1: {
		            	required:true//,
		            }
		        },
		        
		        // Specify the validation error messages
		        messages: {
		        	societyId: {
		        		required : "Please select Society"//,
		        	},
		        	universityId: {
		        		required : "Please select University"//,
		            },
		            collegeName: {
		        		required : "Please Enter College Name"//,
		            },
		            collegeCode: {
		        		required : "Please Enter College Code"//,
		            },
		            address: {
		        		required : "Please Enter Address"//,
		            },
		            city: {
		        		required : "Please Enter City"//,
		            },
		            pinCode: {
		        		required : "Please Enter PIN Code"//,
		            },
		            phone1: {
		        		required : "Please Enter Phone Number"//,
		            },
		            email1: {
		        		required : "Please Enter Email Id"//,
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
				<!--=== Page Header ===-->
				<jsp:include page="page-header.jsp" />
				<!-- /Page Header -->

				<div class="container">
					<div class="row">

						<form action="./college/add" method="post"
							id="college-add-edit-form" enctype="multipart/form-data">
							<input type="hidden" name="collegeId" id="collegeId" value="0">
							<input type="hidden" name="addId" id="addId" value="0"> <input
								type="hidden" name="collegeIdInAddress" id="collegeIdInAddress"
								value="0">
							<input type="hidden" name="oldCollegeLogo" id="oldCollegeLogo" value="0"> 	
							<div class="col-md-12">
								<fieldset class="scheduler-border">
									<legend class="scheduler-border">College</legend>
									<div class="form-group">
										<div class="col-sm-12 ">
											<div class="col-sm-3">
												Note <b>:</b> <span style="color: #FF0000">* Marked
													Is Mandatory !</span>
											</div>
										</div>

									</div>

									<div class="col-md-6">
										<div class="form-horizontal">

											<!-- ptu -->
											<div class="form-group">
												<div class="col-sm-4">
													Society <span style="color: #FF0000; font-weight: bold">*</span>
												</div>
												<div class="col-sm-8">
													<select name="societyId" id="societyId" tabindex="1"
														class="form-control">
														<option value="0">Please Select</option>
														<option value="1">AUTHORISATION</option>
														<option selected="selected" value="50">ACADEMIC</option>
														<option value="3">EXAMINATION</option>
														<option value="4">HOSTEL</option>
														<option value="6">ATTENDANCE</option>
														<option value="7">LIBRARY</option>
														<option value="9">ACCOUNT</option>
														<option value="10">STORE</option>
														<option value="12">PAYROLL</option>
														<option value="14">SOCIETY</option>
														<option value="16">TEST MODULE</option>
														<option value="17">HR</option>

													</select> <span id="ContentPlaceHolder1_rfvFaculty"
														style="display: none;"></span>
												</div>
											</div>


											<div class="form-group">
												<div class="col-sm-4">
													University <span style="color: #FF0000; font-weight: bold">*</span>
												</div>
												<div class="col-sm-8">
													<select name="universityId" id="universityId" tabindex="2"
														class="form-control">
														<option value="0">Please Select</option>
														<option value="1">AUTHORISATION</option>
														<option selected="selected" value="2">ACADEMIC</option>
														<option value="3">EXAMINATION</option>
														<option value="4">HOSTEL</option>
														<option value="6">ATTENDANCE</option>
														<option value="7">LIBRARY</option>
														<option value="9">ACCOUNT</option>
														<option value="10">STORE</option>
														<option value="12">PAYROLL</option>
														<option value="14">SOCIETY</option>
														<option value="16">TEST MODULE</option>
														<option value="17">HR</option>

													</select> <span id="ContentPlaceHolder1_rfvFaculty"
														style="display: none;"></span>
												</div>
											</div>



											<div class="form-group">
												<div class="col-sm-4">
													Name <span style="color: #FF0000; font-weight: bold">*</span>
												</div>
												<div class="col-sm-8">
													<input name="collegeName" type="text" maxlength="200"
														id="collegeName" class="form-control"
														placeholder="Please Enter College Name">


												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-4">
													Code <span style="color: #FF0000; font-weight: bold">*</span>
												</div>
												<div class="col-sm-8">
													<input name="collegeCode" type="text" maxlength="200"
														id="collegeCode" class="form-control"
														placeholder="Please Enter College Code">


												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-4">College Logo</div>
												<div class="col-sm-8">
													<input type="file" name="collegeLogo" id="collegeLogo"
														title="Please Select Logo" class="btn btn-default" onchange="showImage()">

												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-4"></div>
												<div class="col-sm-8">

													<img id="Image2" src="../images/nophoto.jpg"
														style="height: 75px; width: 75px;">


												</div>
											</div>

											<!-- <div class="form-group">

												<div class="col-sm-4"></div>
												<div class="col-sm-8">
													<input type="submit" name="Upload" value="Upload"
														id="Upload" title="Click To Upload"
														class="btn btn-default">
												</div>
											</div> -->


											<!-- /ptu -->

											<div class="form-group">
												<div class="col-sm-4">
													PAN No <span style="color: #FF0000; font-weight: bold">*</span>
												</div>
												<div class="col-sm-8">
													<input name="panNumber" type="text" maxlength="6"
														id="panNumber" class="form-control"
														placeholder="Please Enter PAN Number"> <span
														id="ContentPlaceHolder1_rfvFaculty" style="display: none;"></span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-4">
													TAN No <span style="color: #FF0000; font-weight: bold">*</span>
												</div>
												<div class="col-sm-8">
													<input name="tanNumber" type="text" maxlength="200"
														id="tanNumber" class="form-control"
														placeholder="Please Enter TAN Number"> <span
														id="RequiredFieldValidator1" style="display: none;"></span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-4">TIN No</div>
												<div class="col-sm-8">
													<input name="tinNumber" type="text" maxlength="20"
														id="tinNumber" class="form-control"
														placeholder="Please Enter TIN Number">

												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-4">Principal Name</div>
												<div class="col-sm-8">
													<input name="principalName" type="text" maxlength="20"
														id="principalName" class="form-control"
														placeholder="Please Enter Principal Name">

												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-4">
													Address <span style="color: #FF0000; font-weight: bold">*</span>
												</div>
												<div class="col-sm-8">
													<textarea name="address" rows="2" cols="20" id="address"
														class="form-control" placeholder="Please Enter Address "></textarea>
												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-4">
													City <span style="color: #FF0000; font-weight: bold">*</span>
												</div>
												<div class="col-sm-8">
													<input name="city" type="text" id="city"
														class="form-control" placeholder="Please Enter City">

												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-4">
													Pin Code <span style="color: #FF0000; font-weight: bold">*</span>
												</div>
												<div class="col-sm-8">
													<input name="pinCode" type="text" maxlength="6"
														id="pinCode" class="form-control"
														placeholder="Please Enter Pin">

												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-4">
													Phone No.1 <span style="color: #FF0000; font-weight: bold">*</span>
												</div>
												<div class="col-sm-8">
													<input name="phone1" type="text" maxlength="15" id="phone1"
														class="form-control"
														placeholder="Please Enter Phone No. 1">

												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-4">Phone No.2</div>
												<div class="col-sm-8">
													<input name="phone2" type="text" maxlength="15" id="phone2"
														class="form-control"
														placeholder="Please Enter Phone No. 2">

												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-4">Phone No.3</div>
												<div class="col-sm-8">
													<input name="phone3" type="text" maxlength="15" id="phone3"
														class="form-control"
														placeholder="Please Enter phone No. 3">

												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-4">
													Email ID 1 <span style="color: #FF0000; font-weight: bold">*</span>
												</div>
												<div class="col-sm-8">
													<input name="email1" type="text" maxlength="100"
														id="email1" class="form-control"
														placeholder="Please Enter Email 1"> <span
														id="ContentPlaceHolder1_ref1" style="display: none;"></span>
												</div>
											</div>
											<div class="form-group">
												<div class="col-sm-4">Email ID 2</div>
												<div class="col-sm-8">
													<input name="email2" type="text" maxlength="100"
														id="email2" class="form-control"
														placeholder="Please Enter Email 2"> <span
														id="ContentPlaceHolder1_RegularExpressionValidator1"
														style="display: none;"></span>
												</div>
											</div>


											<div class="form-group">
												<div class="col-sm-4">Status</div>


												<div class="col-sm-8">
													<input id="active" type="checkbox" name="active" value="1"
														checked="checked" tabindex="8" class="active_n_socialcollege">
													<!-- <label for="ContentPlaceHolder1_chkActive"> </label> -->
													<span id="ContentPlaceHolder1_RegularExpressionValidator1"
														style="display: none;"></span>
												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-4">Society Status</div>


												<div class="col-sm-8">
													<input id="socialCollege" type="checkbox" value="1"
														name="socialCollege" checked="checked" tabindex="8"
														class="active_n_socialcollege">
													<!-- <label for="ContentPlaceHolder1_chkActive"></label> -->
													<span id="ContentPlaceHolder1_RegularExpressionValidator1"
														style="display: none;"></span>
												</div>
											</div>





											<div class="form-group">
												<div class="col-sm-4">Work Order Date</div>


												<div class="col-sm-8">

													<!--  <input name="WorkOrder" type="text" maxlength="100" id="Email2" class="form-control" placeholder="Please Enter Work Order Date"> -->
													<input type="text" name="workOrderDateString"
														id="workOrderDateString"
														placeholder="Press to Select date">



												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-4">Bill Date From</div>


												<div class="col-sm-8">

													<!--  <input name="WorkOrder" type="text" maxlength="100" id="Email2" class="form-control" placeholder="Please Enter Work Order Date"> -->
													<input type="text" name="billDateFrom" id="billDateFrom"
														placeholder="Press to Select date">



												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-4">Bill Date To</div>


												<div class="col-sm-8">

													<!--  <input name="WorkOrder" type="text" maxlength="100" id="Email2" class="form-control" placeholder="Please Enter Work Order Date"> -->
													<input type="text" name="billDateTo" id="billDateTo"
														placeholder="Press to Select date">



												</div>
											</div>











											<div class="form-group">
												<div class="col-sm-4">Work Order No</div>
												<div class="col-sm-8">
													<input name="workOrderNumber" type="text" maxlength="100"
														id="workOrderNumber" class="form-control"
														placeholder="Please Enter Email 2"> <span
														id="ContentPlaceHolder1_RegularExpressionValidator1"
														style="display: none;"></span>
												</div>
											</div>



											<div class="form-group">
												<div class="col-sm-4">Fax 1</div>
												<div class="col-sm-8">
													<input name="fax1" type="text" maxlength="15" id="fax1"
														class="form-control" placeholder="Please Enter Fax No. 1">

												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-4">Fax 2</div>
												<div class="col-sm-8">
													<input name="fax2" type="text" maxlength="15" id="fax2"
														class="form-control" placeholder="Please Enter Fax No. 2">

												</div>
											</div>


											<div class="form-group">
												<div class="col-sm-4">Web Site</div>
												<div class="col-sm-8">
													<input name="website" type="text" maxlength="100"
														id="website" class="form-control"
														placeholder="Please Enter Website URL"> <span
														id="ContentPlaceHolder1_RegularExpressionValidator4"
														style="display: none;"></span>

												</div>
											</div>

											<div class="form-group">
												<div class="col-sm-4">No of Users</div>
												<div class="col-sm-8">
													<input name="numberOfUsers" type="text" maxlength="100"
														id="numberOfUsers" class="form-control"
														placeholder="Please Enter Website URL"> <span
														id="ContentPlaceHolder1_RegularExpressionValidator4"
														style="display: none;"></span>

												</div>
											</div>












										</div>
									</div>

									<div class="col-md-6">






										<div id="ContentPlaceHolder1_divHeader" class="row"
											style="border: solid 1px #CCCCCC; position: relative; height: 300px; overflow: auto;">
											<table class="customers">
												<tbody>
													<tr class="customers">
														<th style="text-align: center; width: 5%">SELECT</th>
														<th style="text-align: center; width: 10%">CODE</th>
														<th style="text-align: center; width: 85%">COLLEGE
															NAME</th>

													</tr>
												</tbody>
											</table>
											<div class="DocumentList">

												<table class="table table-hover table-striped">

													<tbody>
														<c:forEach items="${collegeList}" var="college">
															<tr class="customers">
																<td style="width: 5%;"><input type="button"
																	name="ctl00$ContentPlaceHolder1$rptSociety$ctl01$btnEdit"
																	value="Select"
																	onclick="getCollegeInformation('${college.collegeId}')"
																	tabindex="11" title="Edit Record"></td>
																<%-- <td style="width: 10%; text-align: center">
																	${college.collegeId}</td> --%>
																<td style="width: 85%; text-align: left">
																	${college.collegeName}</td>

															</tr>

														</c:forEach>

													</tbody>
												</table>

											</div>
										</div>



										<div class="row"
											style="border: solid 1px #CCCCCC; position: relative; height: 300px; overflow: auto; margin-top: 20px">

											<table class="customers">
												<tbody>
													<tr class="customers">
														<th style="width: 10%">SELECT</th>
														<th style="width: 90%; text-align: center">MODULE
															NAME</th>



													</tr>
												</tbody>
											</table>
											<div class="DocumentList">


												<table id="module_table"
													class="table table-hover table-striped">

													<tbody>


														 <c:forEach items="${moduleList}" var="module">
															<tr class="customers">
																<td style="width: 10%; padding-left: 14px;"><span
																	title="1"><input id="module-${module.id}"
																		type="checkbox" name="moduleIds" value="${module.id}"></span>
																</td>
																<td style="width: 90%; text-align: left"><span
																	id="ContentPlaceHolder1_Repeater_Module_lblFields_0">${module.moduleName}</span>
																</td>


															</tr>
														</c:forEach> 
														
														
													</tbody>

												</table>
												<span id="ContentPlaceHolder1_CustomValidator1"
													style="display: none;"></span>

											</div>
										</div>

										<br>

										<div class="form-group">
											<div class="col-sm-12">
												<div class="col-sm-4"></div>
												<div class="col-lg-8">
													<input type="submit" name="update" value="Save" onclick=""
														id="add-update-btn" title="Click to Save"
														class="btn btn-default"> <input type="reset"
														name="reset" value="Cancel" id="reset"
														title="Click to Cancel" class="btn btn-default">
													<div id="ContentPlaceHolder1_valSave"
														style="display: none;"></div>
												</div>

											</div>

										</div>

									</div>
								</fieldset>
							</div>

						</form>
					</div>
				</div>
</body>
</html>