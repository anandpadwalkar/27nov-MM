<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<title>Staff Details | RITENOW Infra</title>

	<jsp:include page="script.jsp" />
	


<script>
	function set_value(socid) {
		//alert(socid);

		if (socid.trim() != '') {
			$.ajax({
				url : "./society/get-society-module-populated",
				type : "POST",
				data : {
					"socId" : socid
				},
				success : function(response) {
					var text = '';
					//alert(JSON.stringify(response));
					var jsonOb = JSON.parse(JSON.stringify(response));
					if (JSON.stringify(response) != '[]') {

						//making the default list to be unchecked all
						$('input[type="checkbox"]').removeAttr("checked");

						$("#socId").val(jsonOb.socId);
						$("#society_code").val(jsonOb.socCode);
						$("#SocietyName").val(jsonOb.socName);
						$("#Image2").attr(
								'src',
								'./resources/uploads/authorization/society/'
										+ jsonOb.socLogo);
						$("#oldSocietyLogo").val(jsonOb.socLogo);
						$("#RegNo").val(jsonOb.socRegno);
						$("#ChairmanName").val(jsonOb.societyChairman);
						$("#SecretoryName").val(jsonOb.societySecretory);

						$("#City").val(jsonOb.city);
						$("#Address").val(jsonOb.address);
						$("#addId").val(jsonOb.addId);
						$("#Pin").val(jsonOb.pinCode);
						$("#Phone1").val(jsonOb.phone1);
						$("#Phone2").val(jsonOb.phone2);
						$("#Phone3").val(jsonOb.phone3);
						$("#Fax1").val(jsonOb.fax1);
						$("#Fax2").val(jsonOb.fax1);
						$("#Email1").val(jsonOb.email1);
						$("#Email2").val(jsonOb.email2);
						$("#Website").val(jsonOb.website);

						$.each(jsonOb.modules,
								function(index, moduleId) {
									$("#module-" + moduleId).prop("checked",
											"checked");
								});

						$("form").valid();
						$("#society-add-edit-form").prop("action",
								"./society/update-society-module");
						$("#add-update-btn").val('Update');

					}
					// 			$("#itemNameId").html(text);
					// 			if(tempItemId != ''){
					// 				$("#society_code").val(socid);
					// 			}

				},
				error : function() {

				}
			});
		}
	}

	$(document).ready(
			function() {
				$("#reset").click(
						function() {
							$("#society-add-edit-form").prop("action",
									"./society/add-society-module");
							$("#add-update-btn").val('Add');

						});

				$(".active_n_socialcollege").change(function() {
					if ($(this).is(":checked")) {

						$(this).val(1);
					}
				});

				$("#society-add-edit-form").validate({
					// Specify the validation rules
					rules : {
						socCode : {
							required : true
						//,
						},
						socName : {
							required : true
						//,
						}
					},

					// Specify the validation error messages
					messages : {
						socCode : {
							required : "Please select Society Code"//,
						},
						socName : {
							required : "Please select Society Name"//,
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
      
     
      <div class="second-column one-child-container relative ">
        <div id="my_documents_container" style="" class="doc-container column-one clearfixs ">
          <div class="">
            <div class="row">
              <div class="create_project_tbl"> 
              
                  
                  
                  
                  <!-- jaskirat code start here -->
                 
					
					<div class="row">

			<form action="./society/add-society-module" method="post" id="society-add-edit-form" enctype="multipart/form-data">
				<input type="hidden" id="socId" name="socId" value="0" /> <input
					type="hidden" id="addId" name="addId" value="0" />
					<input type="hidden" name="oldSocietyLogo"
												id="oldSocietyLogo" value="0">
				<div class="col-md-12">
					<fieldset class="scheduler-border">
							
                <div class="grid-header text">Society </div>
               
                
						<div class="form-group">
							<div class="col-sm-12 ">
								<div class="col-sm-3">
									Note <b>:</b> <span style="color: #FF0000">* Marked Is
										Mandatory !</span>
								</div>
							</div>

						</div>

						<div class="col-md-6">
							<div class="form-horizontal">

								<div class="form-group">
									<div class="col-sm-4">
										Society Code <span style="color: #FF0000; font-weight: bold">*</span>
									</div>
									<div class="col-sm-8">
										<input name="socCode" type="text" maxlength="6"
											id="society_code" class="form-control"
											placeholder="Please Enter Society Code"> <span
											id="ContentPlaceHolder1_rfvFaculty" style="display: none;"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4">
										Society Name <span style="color: #FF0000; font-weight: bold">*</span>
									</div>
									<div class="col-sm-8">
										<input name="socName" type="text" maxlength="200"
											id="SocietyName" class="form-control"
											placeholder="Please Enter Society Name"> <span
											id="RequiredFieldValidator1" style="display: none;"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4">Registration No.</div>
									<div class="col-sm-8">
										<input name="socRegno" type="text" maxlength="20" id="RegNo"
											class="form-control"
											placeholder="Please Enter Society Reg No">

									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4">Chairman Name</div>
									<div class="col-sm-8">
										<input name="societyChairman" type="text" maxlength="200"
											id="ChairmanName" class="form-control"
											placeholder="Please Enter Chairman Name">


									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4">Secretory Name</div>
									<div class="col-sm-8">
										<input name="societySecretory" type="text" maxlength="200"
											id="SecretoryName" class="form-control"
											placeholder="Please Enter Secretory Name">


									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-4">Society Logo</div>
									<div class="col-sm-8">
										<input type="file" name="societyLogo" id="societyLogo"
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

								<div class="form-group">

									<div class="col-sm-4"></div>
									<div class="col-sm-8">
										<input type="submit" name="Upload" value="Upload" id="Upload"
											title="Click To Upload" class="btn btn-default">
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4">Address</div>
									<div class="col-sm-8">
										<textarea name="address" rows="2" cols="20" id="Address"
											class="form-control" placeholder="Please Enter Address "></textarea>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-4">City</div>
									<div class="col-sm-8">
										<input name="city" type="text" id="City" class="form-control"
											placeholder="Please Enter City">

									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-4">Pin Code</div>
									<div class="col-sm-8">
										<input name="pinCode" type="text" maxlength="6" id="Pin"
											class="form-control" placeholder="Please Enter Pin">

									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4">Phone No.1</div>
									<div class="col-sm-8">
										<input name="phone1" type="text" maxlength="15" id="Phone1"
											class="form-control" placeholder="Please Enter Phone No. 1">

									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4">Phone No.2</div>
									<div class="col-sm-8">
										<input name="phone2" type="text" maxlength="15" id="Phone2"
											class="form-control" placeholder="Please Enter Phone No. 2">

									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4">Phone No.3</div>
									<div class="col-sm-8">
										<input name="phone3" type="text" maxlength="15" id="Phone3"
											class="form-control" placeholder="Please Enter phone No. 3">

									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-4">Fax 1</div>
									<div class="col-sm-8">
										<input name="fax1" type="text" maxlength="15" id="Fax1"
											class="form-control" placeholder="Please Enter Fax No. 1">

									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-4">Fax 2</div>
									<div class="col-sm-8">
										<input name="fax2" type="text" maxlength="15" id="Fax2"
											class="form-control" placeholder="Please Enter Fax No. 2">

									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-4">Email ID 1</div>
									<div class="col-sm-8">
										<input name="email1" type="text" maxlength="100" id="Email1"
											class="form-control" placeholder="Please Enter Email 1">
										<span id="ContentPlaceHolder1_ref1" style="display: none;"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4">Email ID 2</div>
									<div class="col-sm-8">
										<input name="email2" type="text" maxlength="100" id="Email2"
											class="form-control" placeholder="Please Enter Email 2">
										<span id="ContentPlaceHolder1_RegularExpressionValidator1"
											style="display: none;"></span>
									</div>
								</div>
								<div class="form-group">
									<div class="col-sm-4">Web Site</div>
									<div class="col-sm-8">
										<input name="website" type="text" maxlength="100" id="Website"
											class="form-control" placeholder="Please Enter Website URL">
										<span id="ContentPlaceHolder1_RegularExpressionValidator4"
											style="display: none;"></span>

									</div>
								</div>





							</div>
						</div>

						<div class="col-md-6">






							<div id="ContentPlaceHolder1_divHeader" class="row"
								style="border: solid 1px #CCCCCC; position: relative; height: 300px; overflow: auto;">
								<table class="table table-hover table-striped">
										<tr class="customers">
											<th style="text-align: center; width: 5%">SELECT</th>
											<th style="text-align: center; width: 10%">CODE</th>
											<th style="text-align: center; width: 85%">SOCIETY NAME</th>

										</tr>
								</table>
								<div class="DocumentList">

									<table class="table table-hover table-striped">

										<tbody>
											<c:forEach items="${societyList}" var="society">
												<tr class="customers">
													<td style="width: 5%;"><input type="button"
														name="ctl00$ContentPlaceHolder1$rptSociety$ctl01$btnEdit"
														value="Select" onclick="set_value('${society.societyId}')"
														tabindex="11" title="Edit Record"></td>
													<td style="width: 10%; text-align: center">
														${society.societyCode}</td>
													<td style="width: 85%; text-align: left">
														${society.societyName}</td>

												</tr>

											</c:forEach>

										</tbody>
									</table>

								</div>
							</div>


							<div class="row"
								style="border: solid 1px #CCCCCC; position: relative; height: 300px; overflow: auto; margin-top: 20px">

								<table class="table table-hover table-striped">
										<tr class="customers">
											<th style="width: 10%">SELECT</th>
											<th style="width: 90%; text-align: center">MODULE NAME</th>
										</tr>
								</table>
								<div class="DocumentList">
									<table id="module_table"
										class="table table-hover table-striped">
										<tbody>

											<c:forEach items="${moduleList}" var="module">
												<tr class="customers">
													<td style="width: 10%; padding-left: 14px;"><span
														title="1"><input id="module-${module.moduleId}"
															type="checkbox" name="modIds" value="${module.moduleId}"></span>
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
										<div id="ContentPlaceHolder1_valSave" style="display: none;">

										</div>
									</div>

								</div>

							</div>

						</div>
					</fieldset>
				</div>
</form>
                  <!-- jaskirat code end here -->
       </div>       
                  
                  
              </div>
            </div>
          </div>
        </div>
      <!--=== Page Content ===--> 
    </div>
    </div>
    
    </div></div>
    <!-- /.container --> 
    <!-- /.container --> 
</body>

