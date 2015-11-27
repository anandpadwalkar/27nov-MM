<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page session="true"%>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<title>Staff Details | RITENOW Infra</title>
	
	<style>
	
	.modal
{
    overflow: hidden;
}
.modal-dialog{
    margin-right: 0;
    margin-left: 0;
}
	</style>
	
	
	<jsp:include page="script.jsp" />
	
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
      <form:form commandName="menuCreation" action="./add-menu-creation" method="post" >
      <div class="second-column one-child-container relative padding-top-75px"> 
       
        
        <div id="my_documents_container" style="margin-left:0px; margin:auto;width:90%" class="column-one clearfixs">
          <div class="">
            
<!--             jaskirat code start here -->


<!-- /.modal -->

<div class="row">
                <div class="col-md-12">
                    
                    

<div id="myModal" class="modal fade" style="position:absolute;top:0px">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                 <h4 class="modal-title">Select User</h4>

            </div>
            <div class="modal-body" style="padding:0px 0px 0px">
               <div class="col-sm-12">
                        <div class="form-horizontal">
                            <div class="form-group">
                                <div class="col-sm-4">
                                    Search By
                                </div>
                                <div class="col-sm-8">
                                    <table id="ContentPlaceHolder1_rblSearchBy" onclick="RblChange();">
			<tbody><tr>
				<td><input id="ContentPlaceHolder1_rblSearchBy_0" type="radio" name="ctl00$ContentPlaceHolder1$rblSearchBy" value="USERNAME" checked="checked"><label for="ContentPlaceHolder1_rblSearchBy_0">USER NAME</label></td><td><input id="ContentPlaceHolder1_rblSearchBy_1" type="radio" name="ctl00$ContentPlaceHolder1$rblSearchBy" value="USERID"><label for="ContentPlaceHolder1_rblSearchBy_1">USERID</label></td><td><input id="ContentPlaceHolder1_rblSearchBy_2" type="radio" name="ctl00$ContentPlaceHolder1$rblSearchBy" value="USERLOGIN"><label for="ContentPlaceHolder1_rblSearchBy_2">LOGINID</label></td>
			</tr>
		</tbody></table>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4">
                                    Search Text 
                                </div>
                                <div class="col-sm-8">
                                    <input name="ctl00$ContentPlaceHolder1$txtNameSearch" type="text" id="ContentPlaceHolder1_txtNameSearch" class="form-control" onkeypress="return validate(event);" style="width:100%;">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12 text-center Height35px">
                                    <input type="submit" name="ctl00$ContentPlaceHolder1$btncheck" value="Search" onclick="return submitPopup(this.name);" id="ContentPlaceHolder1_btncheck" class="btn btn-default">
                                    <input type="submit" name="ctl00$ContentPlaceHolder1$btncancemodal" value="Cancel" onclick="return ClearSearchBox(this.name);" id="ContentPlaceHolder1_btncancemodal" class="btn btn-default">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-12">

                                            <div class="table-responsive TabContainer">
                                                <table class="table table-hover table-striped">
                                                    <thead>
                                                        <tr class="customers">
                                                            <th style="width: 20%;">USER ID
                                                            </th>
                                                            <th style="width: 40%;">USER NAME
                                                            </th>
                                                            <th style="width: 40%;">LOGIN ID
                                                            </th>
                                                        </tr>
                                                    </thead>
                                                </table>

                                                <div class="" style="position: relative; overflow: auto; width: auto; height: 150px;"><div class="TabScroll" style="overflow: auto; width: auto; height: 150px;">
                                                    <table class="table table-hover table-striped">
                                                        <tbody>
                                                            

                                            <tr class="customers">
                                                <td style="width: 20%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkRecpt_0" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl0$lnkRecpt','')">38</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkName_0" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl0$lnkName','')">ADMIN</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkId_0" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl0$lnkId','')">ADMIN150001@RSML.COM</a>
                                                </td>
                                            </tr>
                                        

                                            <tr class="customers">
                                                <td style="width: 20%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkRecpt_1" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl1$lnkRecpt','')">282</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkName_1" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl1$lnkName','')">paful suryawanshi</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkId_1" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl1$lnkId','')">praful@RSML.com</a>
                                                </td>
                                            </tr>
                                        

                                            <tr class="customers">
                                                <td style="width: 20%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkRecpt_2" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl2$lnkRecpt','')">289</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkName_2" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl2$lnkName','')">Nakul</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkId_2" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl2$lnkId','')">Nakul@RSML.com</a>
                                                </td>
                                            </tr>
                                        

                                            <tr class="customers">
                                                <td style="width: 20%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkRecpt_3" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl3$lnkRecpt','')">290</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkName_3" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl3$lnkName','')">Nitin</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkId_3" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl3$lnkId','')">Nitin@RSML.com</a>
                                                </td>
                                            </tr>
                                        

                                            <tr class="customers">
                                                <td style="width: 20%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkRecpt_4" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl4$lnkRecpt','')">291</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkName_4" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl4$lnkName','')">TestUser</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkId_4" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl4$lnkId','')">testuser@RSML.com</a>
                                                </td>
                                            </tr>
                                        

                                            <tr class="customers">
                                                <td style="width: 20%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkRecpt_5" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl5$lnkRecpt','')">298</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkName_5" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl5$lnkName','')">NakulC</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkId_5" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl5$lnkId','')">NakulC@RSML.COM</a>
                                                </td>
                                            </tr>
                                        

                                            <tr class="customers">
                                                <td style="width: 20%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkRecpt_6" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl6$lnkRecpt','')">299</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkName_6" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl6$lnkName','')">NitinM</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkId_6" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl6$lnkId','')">NitinM@RSML.COM</a>
                                                </td>
                                            </tr>
                                        

                                            <tr class="customers">
                                                <td style="width: 20%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkRecpt_7" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl7$lnkRecpt','')">300</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkName_7" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl7$lnkName','')">TestUsers</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkId_7" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl7$lnkId','')">TestUsers@RSML.COM</a>
                                                </td>
                                            </tr>
                                        

                                            <tr class="customers">
                                                <td style="width: 20%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkRecpt_8" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl8$lnkRecpt','')">341</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkName_8" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl8$lnkName','')">RAHUL VARMA</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkId_8" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl8$lnkId','')">RAHUL@RSML.com</a>
                                                </td>
                                            </tr>
                                        

                                            <tr class="customers">
                                                <td style="width: 20%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkRecpt_9" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl9$lnkRecpt','')">356</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkName_9" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl9$lnkName','')">xxx</a>
                                                </td>
                                                <td style="width: 40%;">
                                                    <a id="ContentPlaceHolder1_lsvSearchResult_lnkId_9" href="javascript:__doPostBack('ctl00$ContentPlaceHolder1$lsvSearchResult$ctrl9$lnkId','')">xtest@RSML.com</a>
                                                </td>
                                            </tr>
                                        
                                                        </tbody>
                                                    </table>
                                                    
                                                </div><div class="slimScrollBar" style="width: 7px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 7px; z-index: 99; right: 1px; height: 93.361px; background: rgb(0, 0, 0);"></div><div class="slimScrollRail" style="width: 7px; height: 100%; position: absolute; top: 0px; border-radius: 7px; opacity: 0.2; z-index: 90; right: 1px; display: none; background: rgb(51, 51, 51);"></div></div>
                                            </div>
                                        
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
            <div class="modal-footer" style="margin:0">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
                    
                    <fieldset class="scheduler-border">
                       
                        <div class="form-group">
                            <div class="col-sm-12 ">Note <b>:</b> <span style="color: #FF0000">* Marked Is Mandatory !</span></div>

                        </div>
                        <div class="col-md-8">
                            <div class="form-horizontal">

                                <div class="form-group">
                                    <div class="col-sm-4">
                                        User Name
                                        <span style="color: #FF0000; font-weight: bold">*</span>
                                    </div>
                                    <div class="col-sm-8">
                                        <div class="input-group">
                                            <input name="ctl00$ContentPlaceHolder1$txtUserFullName" type="text" id="ContentPlaceHolder1_txtUserFullName" tabindex="2" class="form-control" placeholder="Search USER">
                                            
                                            <span id="ContentPlaceHolder1_rfUserName" style="display:none;"></span>
                                              <span class="input-group-addon"><i><a href="#myModal" data-backdrop="false" data-toggle="modal">  <span class="glyphicon glyphicon-search"></span> </a></i></span>
                                        </div>


                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4">
                                        User Photo
                                    </div>
                                    <div class="col-sm-4">
                                        <input type="file" name="ctl00$ContentPlaceHolder1$FileUpload1" id="ContentPlaceHolder1_FileUpload1" title="Please Select Photo">

                                    </div>
                                    <div class="col-sm-4">
                                        <input type="submit" name="ctl00$ContentPlaceHolder1$btnUpload" value="Upload" id="ContentPlaceHolder1_btnUpload" class="btn btn-default">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4">
                                    </div>
                                    <div class="col-sm-8">
                                      
                                      <img id="ContentPlaceHolder1_Image2" src="../images/nophoto.jpg" style="height:75px;width:75px;">
                                         </div>
                                </div>

                                <div class="form-group">
                                    <div class="col-sm-4">
                                        User Login
                                        <span style="color: #FF0000; font-weight: bold">*</span>
                                    </div>
                                    <div class="col-sm-6">

                                        <input name="ctl00$ContentPlaceHolder1$txtUserId" type="text" id="ContentPlaceHolder1_txtUserId" class="form-control" placeholder="Enter User Login">
                                           

                                    </div>
                                    <div class="col-sm-2">
                                        <span id="ContentPlaceHolder1_lblAssias">@RSML.com</span>
                                        <span id="ContentPlaceHolder1_RequiredFieldValidator4" style="display:none;"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4">
                                        Password
                                        <span style="color: #FF0000; font-weight: bold">*</span>
                                    </div>
                                    <div class="col-sm-8">
                                        <input name="ctl00$ContentPlaceHolder1$txtPassword" type="password" maxlength="10" id="ContentPlaceHolder1_txtPassword" class="form-control" placeholder="Enter Password For New User">
                                        <span id="ContentPlaceHolder1_rfPassword" style="display:none;"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4">
                                        Confirm Password
                                        <span style="color: #FF0000; font-weight: bold">*</span>
                                    </div>
                                    <div class="col-sm-8">
                                        <input name="ctl00$ContentPlaceHolder1$txtConPass" type="password" maxlength="10" id="ContentPlaceHolder1_txtConPass" class="form-control" placeholder="Confirm Password For New User">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4">
                                        Counter No.
                                    </div>
                                    <div class="col-sm-4">
                                        <input name="ctl00$ContentPlaceHolder1$txrtCouterNo" type="text" maxlength="2" id="ContentPlaceHolder1_txrtCouterNo" class="form-control" placeholder="Enter Counter No">
                                        
                                        <span id="ContentPlaceHolder1_rgSocity" style="display:none;"></span>
                                        <span id="ContentPlaceHolder1_rgCollege" style="display:none;"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4">
                                        Change Working Date
                                    </div>
                                    <div class="col-sm-8">
                                        <input id="ContentPlaceHolder1_chkWorkingDate" type="checkbox" name="ctl00$ContentPlaceHolder1$chkWorkingDate"><label for="ContentPlaceHolder1_chkWorkingDate">Check If Allow</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4">
                                        Status
                                    </div>
                                    <div class="col-sm-8">
                                        <input id="ContentPlaceHolder1_chkStatus" type="checkbox" name="ctl00$ContentPlaceHolder1$chkStatus"><label for="ContentPlaceHolder1_chkStatus">Check If Active</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4">
                                        Mobile No.
                                    </div>
                                    <div class="col-sm-4">
                                        <input name="ctl00$ContentPlaceHolder1$txtMobile" type="text" maxlength="15" id="ContentPlaceHolder1_txtMobile" class="form-control" placeholder="Enter Mobile No">
                                        
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4">
                                        Email ID
                                          <span style="color: #FF0000; font-weight: bold">*</span>
                                    </div>
                                    <div class="col-sm-4">
                                        <input name="ctl00$ContentPlaceHolder1$txtEmailID" type="text" maxlength="100" id="ContentPlaceHolder1_txtEmailID" class="form-control" placeholder="Enter Email ID">
                                        <span id="ContentPlaceHolder1_RequiredFieldValidator15" style="display:none;"></span>
                                   
                                          <span id="ContentPlaceHolder1_revEmail" style="display:none;"></span> 

                                    </div>
                                </div>
                                <div class="help-block"></div>



                            </div>
                        </div>

                        <div class="col-md-4" style="border:1px solid black;padding:10px">
                            <div class="form-horizontal">

                                <fieldset class="scheduler-border">
                                    <legend class="scheduler-border" style="background:#318FE8;padding:5px;color:white">Roles</legend>
                                    <div class="form-group">
                                        <div class="DocumentList">
                                            
                                            <div class="col-sm-8">
                                                <table id="ContentPlaceHolder1_chkRole">
			<tbody><tr>
				<td><input id="ContentPlaceHolder1_chkRole_0" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$0" value="322"><label for="ContentPlaceHolder1_chkRole_0">ADM</label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_1" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$1" value="89"><label for="ContentPlaceHolder1_chkRole_1">ADMIN</label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_2" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$2" value="367"><label for="ContentPlaceHolder1_chkRole_2">APPROVAL USER</label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_3" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$3" value="91"><label for="ContentPlaceHolder1_chkRole_3">DEMO</label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_4" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$4" value="95"><label for="ContentPlaceHolder1_chkRole_4">DSSS</label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_5" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$5" value="97"><label for="ContentPlaceHolder1_chkRole_5">FACULTY </label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_6" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$6" value="93"><label for="ContentPlaceHolder1_chkRole_6">GHGH</label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_7" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$7" value="366"><label for="ContentPlaceHolder1_chkRole_7">REQUISITION USER</label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_8" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$8" value="94"><label for="ContentPlaceHolder1_chkRole_8">RFTG</label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_9" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$9" value="90"><label for="ContentPlaceHolder1_chkRole_9">RRRRR</label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_10" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$10" value="96"><label for="ContentPlaceHolder1_chkRole_10">SD</label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_11" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$11" value="321"><label for="ContentPlaceHolder1_chkRole_11">STUDENT</label></td>
			</tr><tr>
				<td><input id="ContentPlaceHolder1_chkRole_12" type="checkbox" name="ctl00$ContentPlaceHolder1$chkRole$12" value="92"><label for="ContentPlaceHolder1_chkRole_12">TEST</label></td>
			</tr>
		</tbody></table>
                                                <span id="ContentPlaceHolder1_CustomValidator1" style="display:none;"></span>
                                            </div>
                                        </div>
                                    </div>
                                </fieldset>
                                
                            </div>

                            <div class="form-group">
                                <div class="col-sm-4">
                                </div>
                                <div class="col-sm-8">
                                    <input type="button" name="" value="Save" onclick="" id="ContentPlaceHolder1_btnSubmit" tabindex="12" title="Click to Save" class="btn btn-xl btn-primary button-submit font13">
                                    <input type="submit" name="ctl00$ContentPlaceHolder1$btnCancel" value="Cancel" id="ContentPlaceHolder1_btnCancel" tabindex="13" title="Click to Cancel" class="btn btn-default">
                                    <div id="ContentPlaceHolder1_valsummarySubmit" style="display:none;">

		</div>
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
        </form:form>
      <!--=== Page Content ===--> 
    </div>
    
    </div></div>
    <!-- /.container --> 
    <!-- /.container --> 
    
    
    <script type="text/javascript">
    var validator;
	$(document).ready(function(){
		
		 $("#myModal").draggable({
		      handle: ".modal-header"
		  });
// 		alert();
		$.ajax({
						        			url:"./modules-list",
						        			success:function(response){
						        				//alert(JSON.stringify(response));
						        				var text = '';
						        				text += '<option value="0" selected="selected">Select Module</option>'
						        				$.each(response, function(index, module){
						        					text += '<option value="'+module.id+'">'+module.moduleName+'</option>'
						        				});
						        				$("#module_id").html(text);
						        					$("#module_id").val("${module.id}");	
						        			},
						        			error:function(){
						        				
						        			}
						        		});
	});
		
		/* DEPARTMENT ON CHANGE  */
			var tempItemId = '';
		$("#module_id").change(function(){
			var Modulavalue = $("#module_id").val();
			$("#menu_id").empty();
			
			if(Modulavalue != 0){
				$.ajax({
					url:"./get_menu-lists",
					type:"POST",
					data:{"module_id" : Modulavalue},
					success:function(response){
// 						alert()
						var text = '';
						var text2=''
						text += '<option value="0" selected="selected">Select Module</option>';
						
						if(JSON.stringify(response) != '[]'){
							$.each(response, function(index, MainMenuEntityList){
								text += '<option value="'+MainMenuEntityList.menuId+'">'+MainMenuEntityList.menuName+'</option>'
							    text2+=""
							    	+ "<tr class=\"odd\"> "
							    	+ "                          <td class=\" \"> "
							    	+ "                          	<a href=\"#\" onclick=\"updateMenu('module_id','"+MainMenuEntityList.menuId+"','"+MainMenuEntityList.menuName+"','"+MainMenuEntityList.menuLink+"','"+MainMenuEntityList.menuToolTip+"','"+MainMenuEntityList.menuSrno+"','"+MainMenuEntityList.active+"')\" data-toggle=\"modal\" data-original-title=\"Add to Project\" data-placement=\"top\" style=\"border-radius:40px; padding:4px 6px 2px;\" class=\"btn btn-xl btn-success button-submit font13 bs-tooltip\"> "
							    	+ "                            	<i class=\"icon-cog font14\"></i> "
							    	+ "                            </a> "
							    	+ "                          </td> "
							    	+ "                          <td class=\" \">"+MainMenuEntityList.menuId+"</td> "
							    	+ "                          <td class=\" \">"+MainMenuEntityList.menuName+"</td> "
							    	+ "                          <td class=\" \">"+MainMenuEntityList.menuLink+"</td> "
							    	+ "                        </tr>";
							
							});
						}
						$("#menu_table tr td").remove();
						$("#menu_id").html(text);
						$('#menu_table').append(text2);
						$('#call').val('update');
// 						$("#submit_button").text('Update');
						if(tempItemId != ''){
							$("#menu_id").val(tempItemId);
						}
						
					},
					error:function(){
						
					}
				});
			}else{
				$("#menu_id").empty();
				var text = '';
				text += '<option value="0" selected="selected">Select Module</option>';
				$("#menu_id").html(text);
			}
			
        });
	
		
		/* DEPARTMENT ON CHANGE ENDS */
		
		
		function updateMenu(id, parent, menu_name, menulink, menutooltip, menusrno, status){
		//alert(itemId+" - "+itemCode+ " - "+itemName+ " - "+minStock+ " - "+maxStock+ " - "+currentStock+ " - "+itemUnit + " - "+ deptId + " - " + complaintTypeId);
		
		
		$("#menuId").val(parent);
// 		$("#module_id").val(parent).change();
		//$("#complaintTypeId").val(complaintTypeId).change();
		$("#menu_id").val(parent);
		$("#menu_name").val(menu_name);
		$("#menu_link").val(menulink);
		$("#menu_tool_tip").val(menutooltip);
		$("#menu_srno").val(menusrno);
// 		if( status.trim()=='1')
// 		$("#menu_status").prop('checked','checked');
// 		alert(status)
		$("#submit_button").text('Update');
		
		if( status.trim()=='1'){
			$("#menu_status").prop('checked','checked');
	}
		}
		
		$("#cancel_id").click(function(){
			$("#submit_button").text('Save');
		});
    </script>
 

</body>
</html>
