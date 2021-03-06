<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Online Shopping Website Using Spring MVC and Hibernate">
<meta name="author" content="Rahul Sharma">
<meta name="_csrf" content="${_csrf.token}">
<meta name="_csrf_header" content="${_csrf.headerName}">


<title>Online Shopping - ${title}</title>

<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap Core CSS -->
<!--  <link href="${css}/bootstrap.min.css" rel="stylesheet">
<link href="${css}/bootstrap.css" rel="stylesheet">
-->
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<!-- Bootstrap Readable Theme -->
<link href="${css}/bootstrap-simplex.css" rel="stylesheet">


<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">


<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->



		<%@include file="./shared/navbar.jsp"%>


		<div class="content">
			<!-- Page Content -->
			<!-- Loading the home page -->
			<c:if test="${userClickHome == true }">

				<%@include file="home.jsp"%>

			</c:if>

			<!-- When we click on About -->
			<c:if test="${userClickAbout == true }">

				<%@include file="about.jsp"%>

			</c:if>

			<!-- When we click on Contact Us -->
			<c:if test="${userClickContact == true }">

				<%@include file="contact.jsp"%>

			</c:if>



			<!-- When we click on All Products -->
			<c:if test="${userClickAllProducts == true or userClickCategoryProducts == true}">

				<%@include file="listProducts.jsp"%>

			</c:if>
			
			<!-- When we click on Product -->
			<c:if test="${userClickShowProduct == true }">

				<%@include file="singleProduct.jsp"%>

			</c:if>
			
			<!-- When we click on Manage Products -->
			<c:if test="${userClickManageProducts == true }">

				<%@include file="manageProducts.jsp"%>

			</c:if>
			
			<!-- When we click on Manage Products -->
			<c:if test="${userClickShowCart == true }">

				<%@include file="cart.jsp"%>

			</c:if>


		</div>
		<!-- /.container -->

		<!-- Footer -->
		<!-- Footer comes hare -->


		<%@include file="./shared/footer.jsp"%>


		<!-- Jquery -->
		<script src="${js}/jquery.min.js"></script>
		
		<!-- Jquery -->
		<script src="${js}/jquery.validate.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		
		<!-- DataTable plugin-->
		<script src="${js}/jquery.dataTables.js"></script>
		
		<!-- Data Table Bootstrap Script-->
		<script src="${js}/dataTables.bootstrap.js"></script>
		
		<!-- BootBox -->
		<script src="${js}/bootbox.min.js"></script>
		
		
		<!-- Self coded javascript -->
		<script src="${js}/myapp.js"></script>
		
		
	</div>
</body>

</html>
