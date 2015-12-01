<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>Change Password</title>

<jsp:include page="script.jsp" />

</head>
<body>
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
        
       
      </div>
          
          
        </div>
    <!-- /.container --> 
    
  </div>
  <h1>${message}</h1>
	<a href='<c:url value="/success"/>'>Back to the Dashboard</a>
    </div>
	
	
</body>
</html>